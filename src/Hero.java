import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ASUS on 14.07.2017.
 */
public class Hero {
    private int resourceDistance;
    private int heroHp;
    private int heroAttackPoint;
    private ArrayList<String> lines = new ArrayList<String>();

    public Hero() {

    }

    public Hero(ArrayList<String> lines) {
        this.lines = lines;
        resourceDistance=findResourcesDistance(lines);
        heroHp = findHeroHp(lines);
        heroAttackPoint = findHeroAttackPoint(lines);
    }//end Hero Constr


    public int getResourceDistance() {
        return resourceDistance;
    }

    public int getHeroHp() {
        return heroHp;
    }

    public void setHeroHp(int heroHp) {
        this.heroHp = heroHp;
    }

    public int getHeroAttackPoint() {
        return heroAttackPoint;
    }

    private int findHeroAttackPoint(ArrayList<String> lines) {
        int attackPoint = 0;
        int j;
        for (j = 0; j < lines.size(); j++) {
            if (lines.get(j).contains("Hero") && lines.get(j).contains("attack")) {
                attackPoint = Integer.parseInt(lines.get(j).replaceAll("[^0-9]", ""));
            }
        }
        return attackPoint;
    }

    private int findHeroHp(ArrayList<String> lines) {
        int heroHp = 0;
        int j;
        for (j = 0; j < lines.size(); j++) {
            if (lines.get(j).contains("Hero") && lines.get(j).contains("hp")) {
                heroHp = Integer.parseInt(lines.get(j).replaceAll("[^0-9]", ""));
            }
        }
        return heroHp;
    }


    public static int findResourcesDistance(ArrayList<String> lines){
        int resourceDistance = 0;
        int j;
        for (j = 0; j < lines.size(); j++) {
            if (lines.get(j).contains("away")) {
                resourceDistance = Integer.parseInt(lines.get(j).replaceAll("[^0-9]", ""));
            }
        }
        return resourceDistance;
    }
}// end all
