import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ASUS on 14.07.2017.
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Lütfen proje klasörü içinde bulunan okunacak dosya ismini sonuna .txt uzantısı EKLEMEDEN giriniz: ");
        Scanner user = new Scanner(System.in);
        String fileName = user.nextLine()+".txt";
        RadarFile radarFile = new RadarFile(fileName);
        Hero hero = new Hero(radarFile.getLines()); // hero nesnesine dosya gönderilir gerekli veriler orada çekilir.
        ArrayList<Enemy> enemies  = new ArrayList<Enemy>(); // düşman varlık tipleri ve özellikleri bu list içinde tutulacak
        ArrayList<EnemyOnThePath> enemiesOnThePath = new ArrayList<EnemyOnThePath>(); // yol üzerinde bulunan düşman varlıklar bu list içnde tutulacak


        detectEnemy(radarFile.getLines(),enemies);
        setEnemyHp(radarFile.getLines(), enemies);
        setEnemyAttackPoint(radarFile.getLines(), enemies);
        detectEnemiesOnThePath(radarFile.getLines(), enemies, enemiesOnThePath);

        fight(hero, enemiesOnThePath);


    } // end main

    private static void fight(Hero hero, ArrayList<EnemyOnThePath> enemiesOnThePath) throws FileNotFoundException {

        System.out.println("Lütfen proje klasörü içine yazdırılacak dosya ismini sonuna .txt uzantısı EKLEMEDEN giriniz: ");
        Scanner user = new Scanner(System.in);
        String outputFileName = user.nextLine()+".txt";
        PrintStream outFile = new PrintStream(new FileOutputStream(outputFileName)); // hem konsola hem dosyaya yazdırmak için duplicate ediyoruz
        PrintStream outConcolse = System.out;

        System.out.println("Hero Started Journey With " + hero.getHeroHp() + " HP!");
        outFile.println("Hero Started Journey With " + hero.getHeroHp() + " HP!");
        for(int k=0; k<enemiesOnThePath.size(); k++){
            hero.setHeroHp(hero.getHeroHp() - //burada düşmanla mücadele ettikten sonra
                    (enemiesOnThePath.get(k).getEnemyHp() / hero.getHeroAttackPoint()) //hero nesnesinin kalan can
                            *enemiesOnThePath.get(k).getEnemyAttackPoint()); //  puanları hesaplanır

            if(hero.getHeroHp() <= 0){ // hero nun kalan can puanına göre işlem yapılır
                System.out.println(enemiesOnThePath.get(k).getEnemyType() + " defated Hero");
                outFile.println(enemiesOnThePath.get(k).getEnemyType() + " defated Hero");
                System.out.println("Hero is Dead!! Last seen at position "+ enemiesOnThePath.get(k).getEnemylocation() +"!!"); //hero nun son görüldüğü lokasyonu get ediyoruz
                outFile.println("Hero is Dead!! Last seen at position "+ enemiesOnThePath.get(k).getEnemylocation() +"!!");
                break;
            }else{
                System.out.println("Hero defeated "+enemiesOnThePath.get(k).getEnemyType() + " with " + hero.getHeroHp() + " HP remaining"); //heronun düşmanını alt ettiği ve
                outFile.println("Hero defeated "+enemiesOnThePath.get(k).getEnemyType() + " with " + hero.getHeroHp() + " HP remaining"); // kalan canının yazıldığı yer
            }
        }
        if(hero.getHeroHp() > 0 ){
            System.out.println("Hero Survived!");
            outFile.println("Hero Survived!");

            System.out.println("Çıktılar Proje klasörü içinde '" +outputFileName+"' isimli text dosyası içine kayıt edildi");
        }
    } // end fight


    private static void detectEnemiesOnThePath(ArrayList<String> lines, ArrayList<Enemy> enemies, ArrayList<EnemyOnThePath> enemiesOnThePath) {
        int i;

        for(i=0; i<lines.size();i++){
            if(lines.get(i).contains("position")){ //yol üzerindeki düşmanlar dosyadaki position string i üzerinden belirlenir.
                EnemyOnThePath enemyOnThePath = new EnemyOnThePath();
                int enemyLocation = Integer.parseInt(lines.get(i).replaceAll("[^0-9]", "")); // düşman lokasyonu burada alınır.
                enemyOnThePath.setEnemylocation(enemyLocation);
                String [] line = lines.get(i).split(" ");
                String type = line[3]; // yol üzerindeki düşman tipi burada satırın içinden çekilir.
                enemyOnThePath.setEnemyType(type);
                for(int k=0; k<enemies.size(); k++){ // yol üzerindeki düşman tipi belirlenince Enemy sınıfından daha önce belirlenen özellikler
                    if(type.equals(enemies.get(k).getEnemyType())){ // yüklenir.
                        enemyOnThePath.setEnemyAttackPoint(enemies.get(k).getEnemyAttackPoint());
                        enemyOnThePath.setEnemyHp(enemies.get(k).getEnemyHp());
                    }
                }
                enemiesOnThePath.add(enemyOnThePath); //list kuruldu
            }
            Collections.sort(enemiesOnThePath,  // hesaplamada en yakından başlamak için list içindeki nesneleri
                    Comparator.comparingInt(EnemyOnThePath::getEnemylocation));// lokasyon değerlerine göre yakından uzağa sıraladık
        }
    } // end detectEnemiesOnThePath


    private static void detectEnemy(ArrayList<String> lines, ArrayList<Enemy> enemies) {
        int j;

        for (j = 0; j < lines.size(); j++) { // düşman varlıkların tip sınıflandırılması burada yapılır.
            if (lines.get(j).contains("Enemy")) {
                Enemy enemy = new Enemy();
                String [] line = lines.get(j).split(" ");
                String type = line[0];
                enemy.setEnemyType(type);
                enemies.add(enemy);
            }
        }

    } // end detectEnemy

    private static void setEnemyHp(ArrayList<String> lines, ArrayList<Enemy> enemies){
        int j;
        int i;
        for(j=0; j<enemies.size();j++){ // düşman varlığın can puanları burada dosyadan okunur.
            for(i=0; i<lines.size(); i++){
                if(lines.get(i).contains(enemies.get(j).getEnemyType()) && lines.get(i).contains("hp")){
                    enemies.get(j).setEnemyHp(Integer.parseInt(lines.get(i).replaceAll("[^0-9]", "")));
                }
            }
        }
    }// end setEnemyHp

    private static void setEnemyAttackPoint (ArrayList<String> lines, ArrayList<Enemy> enemies) {
        int j;
        int i;
        for(j=0; j<enemies.size();j++){ // düşman varlıkların atak puanları burada dosyadan okunur.
            for(i=0; i<lines.size(); i++){
                if(lines.get(i).contains(enemies.get(j).getEnemyType()) && lines.get(i).contains("attack")){
                    enemies.get(j).setEnemyAttackPoint(Integer.parseInt(lines.get(i).replaceAll("[^0-9]", "")));
                }
            }
        }
    } // end setEnemyAttackPoint
} // end all
