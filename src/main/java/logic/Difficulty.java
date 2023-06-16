package logic;

import logic.entities.*;

public class Difficulty {

    // private Enemy enemy;

    private EnemyCluster cluster;
    private Player player;
    private String difficultyType;
    public static float enemyHealth = 100;
    public static int enemyHitFrequency = 5;
    public static int enemyDamageMultiplier = 1;

    public Difficulty(String difficulty, Player p) {
        // this.enemy = e;
        this.difficultyType = difficulty;
        this.player = p;
        this.setDifficulty();
    }

    public void setDifficulty() {
        if(difficultyType.equals("easy")) {
            this.easyDifficulty();
        } else if (difficultyType.equals("hard")) {
            this.hardDifficulty();
        } else if (difficultyType.equals("medium")) {
            this.mediumDifficulty();
        }
        return;
    }


    public void mediumDifficulty() {
        player.setHealth(100);
    }
    /**
     * Changes stats of player/enemy to make the game easier to play
     */
    public void easyDifficulty() {
        //enemy.setHealth(enemy.getHealth() / 2);
        //enemy.setHitFrequency(enemy.getHitFrequency() / 2);
        //enemy.setRespawnTime(enemy.getRespawnTime() * 2);
        player.setHealth(100);
        enemyHealth = 50;
        enemyHitFrequency = 3;
        enemyDamageMultiplier = 1;
    }

    /**
     * Changes stats of player/enemy to make the game harder to play
     */
    public void hardDifficulty() {
        //enemy.setHealth(enemy.getHealth() * 2);
        //enemy.setHitFrequency(enemy.getHitFrequency() * 2);
        //enemy.setRespawnTime(enemy.getRespawnTime() / 2);
        player.setHealth(25);
        enemyHealth = 150;
        enemyHitFrequency = 10;
        enemyDamageMultiplier = 2;
    }
}
