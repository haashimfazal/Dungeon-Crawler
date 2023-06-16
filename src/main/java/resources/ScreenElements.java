//<<<<<<< HEAD:src/main/java/ScreenElements.java
//=======
package resources;

//>>>>>>> F10:src/main/java/resources/ScreenElements.java
import logic.entities.Boss;
import logic.items.Rock;
import logic.items.Tree;
import logic.level.Challenge;
import logic.items.FloorItem;
import logic.entities.EnemyCluster;
import logic.entities.NPC;

import java.util.List;

/**
 * Class containing lists of elements to be displayed on the screen.
 */
public class ScreenElements {

    private Challenge challenge;
    private List<EnemyCluster> enemies;
    private List<Tree> trees;
    private List<Rock> rocks;
    private List<FloorItem> floorItems;
    private String name;
    private NPC npc;
    private Boss boss;
    private Boolean bossKilled = false;

    // For levels
    public ScreenElements(String name, Challenge challenge, List<EnemyCluster> enemies, List<Tree> trees, List<Rock> rocks, List<FloorItem> floorItems, NPC npc, Boss boss) {
        this.challenge = challenge;
        this.name = name;
        this.enemies = enemies;
        this.trees = trees;
        this.rocks = rocks;
        this.npc = npc;
        this.floorItems = floorItems;
        this.boss = boss;
    }

    // For rooms
    public ScreenElements(String name, Challenge challenge,List<EnemyCluster> enemies, List<Tree> trees, List<Rock> rocks, List<FloorItem> floorItems) {

        this.name = name;
        this.challenge=challenge;
        this.enemies = enemies;
        this.trees = trees;
        this.rocks = rocks;
        this.floorItems = floorItems;
    }

    /**
     * Get a list of enemies within a level.
     * @return list of enemies
     */
    public List<EnemyCluster> getEnemies() {
        return enemies;
    }


    /**
     * Get a list of trees within a level.
     * @return list of trees
     */
    public List<Tree> getTrees() {
        return trees;
    }

    /**
     * Get a a of a level.
     * @return the name of the level
     */
    public String getName() {
        return name;
    }

    /**
     * Get a challenge of a game.
     * @return challenge
     */
    public Challenge getChallenge() {
        return challenge;
    }

    /**
     * Get a list of rocks within a level.
     * @return list of rocks
     */
    public List<Rock> getRocks() {
        return rocks;
    }

    public NPC getNPC()
    {
        return npc;
    }

    public List<FloorItem> getFloorItems() {
        return floorItems;
    }

    public Boss getBoss()
    {
        return boss;
    }

    public Boolean getBossKilled() {
        return bossKilled;
    }

    public void bossKilled()
    {
        bossKilled = true;
    }

}
