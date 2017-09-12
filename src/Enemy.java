/**
 * Created by ASUS on 14.07.2017.
 */
public class Enemy {
    private String enemyType;
    private int enemyHp;
    private int enemyAttackPoint;


    public Enemy(){

    }

    public String getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    public int getEnemyHp() {
        return enemyHp;
    }

    public void setEnemyHp(int enemyHp) {
        this.enemyHp = enemyHp;
    }

    public int getEnemyAttackPoint() {
        return enemyAttackPoint;
    }

    public void setEnemyAttackPoint(int enemyAttackPoint) {
        this.enemyAttackPoint = enemyAttackPoint;
    }

}
