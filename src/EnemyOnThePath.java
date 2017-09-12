import java.util.ArrayList;

/**
 * Created by ASUS on 14.07.2017.
 */
public class EnemyOnThePath {

    private String enemyType;
    private int enemyLocation;
    private int enemyAttackPoint;
    private int enemyHp;



    public EnemyOnThePath() {

    }

    public String getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    public int getEnemylocation() {
        return enemyLocation;
    }

    public void setEnemylocation(int enemylocation) {
        this.enemyLocation = enemylocation;
    }

    public int getEnemyAttackPoint() {
        return enemyAttackPoint;
    }

    public void setEnemyAttackPoint(int enemyAttackPoint) {
        this.enemyAttackPoint = enemyAttackPoint;
    }

    public int getEnemyHp() {
        return enemyHp;
    }

    public void setEnemyHp(int enemyHp) {
        this.enemyHp = enemyHp;
    }

}
