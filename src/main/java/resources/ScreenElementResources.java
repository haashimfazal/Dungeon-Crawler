package resources;

import gui.GameScreen;
import logic.Difficulty;
import logic.GameLogic;
import logic.Skills.Trading;
import logic.entities.*;
import logic.items.FloorItem;
import logic.items.Key;
import logic.items.Rock;
import logic.items.Tree;
import logic.level.Challenge;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * All the elements to be loaded on the screen to the specific level.
 */
public class ScreenElementResources {

    private static double zoom;
    private static Challenge challenge;
    private static float enemyHealth = Difficulty.enemyHealth;
    private static int enemyHitFrequency = Difficulty.enemyHitFrequency;
    private static float enemyDamageMultiplier = Difficulty.enemyDamageMultiplier;
  

    public ScreenElementResources() {
        zoom = GameScreen.getInitialZoom();
        
    }


    /**
     * Items to be drawn in level 1.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_1() throws IOException {

        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        challenge=new Challenge(window);
        Trading tradeSword = new Trading(5, 60, 1, 11);
        Trading tradePick = new Trading(5, 60, 1, 21);
        Trading tradeBow = new Trading(5, 60, 1, 31);
        Trading tradeAxe = new Trading(5, 60, 1, 41);
        Trading tradeCoal = new Trading(5, 60, 1, 51);
        Trading tradeWood = new Trading(5, 50, 1, 61);
        Trading tradeFood = new Trading(5, 50, 1, 71);
        Trading tradeHelmet = new Trading(5, 50, 1, 81);
        Trading tradeChest = new Trading(5, 50, 1, 91);
        Trading tradeLegs = new Trading(5, 50, 1, 101);
        Trading tradeBoot = new Trading(5, 50, 1, 111);
        Trading tradeShield = new Trading(5, 60, 1, 121);

        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/1.png", 204, 101, "LEVEL_1", "LEVEL_1", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();

        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (464 * zoom), (int) (550 * zoom)));

        //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Goblin/PNG/PNG Sequences/Run Slashing/0_Goblin_Run Slashing_008.png", GameScreen.getGui(), 4000, 1, enemyHitFrequency, false, 1 * enemyDamageMultiplier, 0);

        enemies.add(new EnemyCluster(window, enemy, 3, 890, 118, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));
        enemies.add(new EnemyCluster(window, enemy, 5, 87, 219, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));
        enemies.add(new EnemyCluster(window, enemy, 4, 1123, 489, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));
        enemies.add(new EnemyCluster(window, enemy, 7, 560, 544, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));

        trees.add(new Tree(window, 40, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 80, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 120, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 200, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 240, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 320, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 360, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 40, 580, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 50, 540, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 72, 500, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 240, 531, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 350, 520, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 828, 451, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 891, 454, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 918, 456, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 386, 136, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 1024, 265, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 1051, 264, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 1077, 268, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 1139, 263, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 1188, 268, 5000,1, 20, "Images/trees/coconut palm.png", 60, 40));


    rocks.add(new Rock(window, 660, 34, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 643, 704, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 672, 103, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 681, 81, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
    rocks.add(new Rock(window, 833, 36, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 861, 30, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
    rocks.add(new Rock(window, 904, 35, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 932, 44, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 924, 804, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
    rocks.add(new Rock(window, 657, 66, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
    rocks.add(new Rock(window, 908, 95, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));
        rocks.add(new Rock(window, 936, 86, 5000,1, 30, "Images/rocks/rock.png", Color.WHITE, 50, 20));

        Boss boss = new Boss(window, 1113, 515
                , 50,  50,  400, "Images/Bosses/Minotaur_01/PNG Sequences/Attacking/Minotaur_01_Attacking_000.png", GameScreen.getGui(), 10000, 1, 2, 3,  enemyHitFrequency, true, (float) (1.5 ), 0);

        return new ScreenElements("LEVEL_1", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 2.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_2() throws IOException {

        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();

        Trading tradeSword = new Trading(5, 61, 1, 12);
        Trading tradePick = new Trading(5, 61, 1, 22);
        Trading tradeBow = new Trading(5, 61, 1, 32);
        Trading tradeAxe = new Trading(5, 61, 1, 42);
        Trading tradeCoal = new Trading(5, 61, 1, 52);
        Trading tradeWood = new Trading(5, 51, 1, 62);
        Trading tradeFood = new Trading(5, 51, 1, 72);
        Trading tradeHelmet = new Trading(5, 51, 1, 82);
        Trading tradeChest = new Trading(5, 51, 1, 92);
        Trading tradeLegs = new Trading(5, 51, 1, 102);
        Trading tradeBoot = new Trading(5, 51, 1, 112);
        Trading tradeShield = new Trading(5, 61, 1, 122);
        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/2.png", 400, 200, "LEVEL_2", "LEVEL_2", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (57 * zoom), (int) (116 * zoom)));

        //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Ogre/PNG/PNG Sequences/Run Slashing/0_Ogre_Run Slashing_008.png", GameScreen.getGui(), 4000, 2, enemyHitFrequency, false, (float) 1.2 * enemyDamageMultiplier, 1);

        enemies.add(new EnemyCluster(window, enemy, 2, 217, 545, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 734, 290, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 1041, 541, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 1113, 163, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 132, 51, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 250f, 50f, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 350, 575, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 322, 576, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 304, 574, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 276, 573, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 446, 567, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 465, 557, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 473, 576, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 482, 553, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 51, 582, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 882, 574, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 862, 574, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 988, 441, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 1017, 442, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 1042, 443, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 1067, 446, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 965, 190, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 274, 59, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 296, 61, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 324, 61, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 346, 60, 5000,1, 21, "Images/trees/ashberry.png", 61, 41));


        rocks.add(new Rock(window, 1156, 513, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 1186, 519, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
    rocks.add(new Rock(window, 1157, 553, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 1175, 537, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
    rocks.add(new Rock(window, 1089, 519, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 779, 330, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 745, 330, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 857, 309, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 875, 333, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 396, 122, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 1186, 580, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 1162, 578, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
   rocks.add(new Rock(window, 806, 331, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 801, 305, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
        rocks.add(new Rock(window, 365, 132, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));
   rocks.add(new Rock(window, 317, 132, 5000,1, 31, "Images/rocks/rock.png", Color.RED, 51, 21));

        Boss boss = new Boss(window, 54, 63
                , 50,  50,  400, "Images/Bosses/Minotaur_02/PNG Sequences/Attacking/Minotaur_02_Attacking_001.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (2 ), 1);


        return new ScreenElements("LEVEL_2", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 3.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_3() throws IOException {
        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();

        Trading tradeSword = new Trading(5, 62, 1, 13);
        Trading tradePick = new Trading(5, 62, 1, 23);
        Trading tradeBow = new Trading(5, 62, 1, 33);
        Trading tradeAxe = new Trading(5, 62, 1, 43);
        Trading tradeCoal = new Trading(5, 62, 1, 53);
        Trading tradeWood = new Trading(5, 52, 1, 63);
        Trading tradeFood = new Trading(5, 52, 1, 73);
        Trading tradeHelmet = new Trading(5, 52, 1, 83);
        Trading tradeChest = new Trading(5, 52, 1, 93);
        Trading tradeLegs = new Trading(5, 52, 1, 103);
        Trading tradeBoot = new Trading(5, 52, 1, 113);
        Trading tradeShield = new Trading(5, 62, 1, 123);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/5.png", 201, 235, "LEVEL_3", "LEVEL_3", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/key.png"));
        Key key = new Key(window, keyTexture, 1);
        floorItems.add(new FloorItem(window, key, (int) (1077 * zoom), (int) (58 * zoom)));

       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.4 * enemyDamageMultiplier, 2);

        enemies.add(new EnemyCluster(window, enemy, 2, 303, 535, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 874, 378, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 1166, 63, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 723, 80, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
//        enemies.add(new EnemyCluster(window, enemy, 6, asdasdasd, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 50f, 50f, 5000,1, 22, "Images/trees/baobab.png", 62, 42));

        trees.add(new Tree(window, 219, 104, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 246, 103, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 485, 420, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 455, 420, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 431, 421, 5000,1, 22, "Images/trees/baobab.png", 62, 42));


        trees.add(new Tree(window, 319, 295, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 764, 582, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 767, 548, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 740, 582, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 709, 581, 5000,1, 22, "Images/trees/baobab.png", 62, 42));


;
        trees.add(new Tree(window, 1185, 547, 5000,1, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 1188, 521, 5000,1, 22, "Images/trees/baobab.png", 62, 42));


        rocks.add(new Rock(window, 800f, 300f, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 831, 308, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
     rocks.add(new Rock(window, 1036, 177, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 1011, 177, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
   rocks.add(new Rock(window, 64, 486, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 65, 507, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 26, 515, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 41, 516, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
   rocks.add(new Rock(window, 627, 179, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 23, 457, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 100, 532, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
    rocks.add(new Rock(window, 544, 182, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));

        Boss boss = new Boss(window, 1125, 63
                , 50,  50,  400, "Images/Bosses/Minotaur_03/PNG Sequences/Attacking/Minotaur_03_Attacking_001.png", GameScreen.getGui(), 10000, 1, 2, 3,  enemyHitFrequency, true, (float) (2.5 ), 2);


        return new ScreenElements("LEVEL_3", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 4.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_4() throws IOException {
        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();

        Trading tradeSword = new Trading(5, 63, 1, 1);
        Trading tradePick = new Trading(5, 63, 1, 24);
        Trading tradeBow = new Trading(5, 63, 1, 34);
        Trading tradeAxe = new Trading(5, 63, 1, 44);
        Trading tradeCoal = new Trading(5, 63, 1, 54);
        Trading tradeWood = new Trading(5, 53, 1, 64);
        Trading tradeFood = new Trading(5, 53, 1, 74);
        Trading tradeHelmet = new Trading(5, 53, 1, 84);
        Trading tradeChest = new Trading(5, 53, 1, 94);
        Trading tradeLegs = new Trading(5, 53, 1, 134);
        Trading tradeBoot = new Trading(5, 53, 1, 11);
        Trading tradeShield = new Trading(5, 63, 1, 124);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/1.png", 246, 552, "LEVEL_4", "LEVEL_4", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();

       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/4/craftpix-991117-free-fallen-angel-chibi-2d-game-sprites/Fallen_Angels_1/PNG/PNG Sequences/Run Slashing/0_Fallen_Angels_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.6 * enemyDamageMultiplier, 3);

        enemies.add(new EnemyCluster(window, enemy, 2, 49, 541, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 211, 153, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 609, 248, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 994, 44, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 988, 535, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 50f, 50f, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 894, 239, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 80, 73, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 34, 583, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 56, 583, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 10, 583, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 166, 580, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 709, 292, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 1183, 256, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 1183, 232, 5000,1, 23, "Images/trees/beech.png", 63, 43));


        trees.add(new Tree(window, 1052, 453, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 1022, 450, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 991, 452, 5000,1, 23, "Images/trees/beech.png", 63, 43));
        trees.add(new Tree(window, 965, 452, 5000,1, 23, "Images/trees/beech.png", 63, 43));

        rocks.add(new Rock(window, 954, 591, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 976, 589, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 1004, 589, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
     rocks.add(new Rock(window, 1054, 392, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 1085, 393, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
    rocks.add(new Rock(window, 589, 166, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 560, 169, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
    rocks.add(new Rock(window, 221, 461, 5000,1, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));

        Boss boss = new Boss(window, 1064, 522, 50,  50,  400, "Images/Bosses/Wraith_03/PNG Sequences/Attacking/Wraith_03_Attack_001.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (3 ), 3);


        return new ScreenElements("LEVEL_4", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 5.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_5() throws IOException {
        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 64, 1, 15);
        Trading tradePick = new Trading(5, 64, 1, 25);
        Trading tradeBow = new Trading(5, 64, 1, 35);
        Trading tradeAxe = new Trading(5, 64, 1, 45);
        Trading tradeCoal = new Trading(5, 64, 1, 55);
        Trading tradeWood = new Trading(5, 54, 1, 65);
        Trading tradeFood = new Trading(5, 54, 1, 75);
        Trading tradeHelmet = new Trading(5, 54, 1, 85);
        Trading tradeChest = new Trading(5, 54, 1, 95);
        Trading tradeLegs = new Trading(5, 54, 1, 15);
        Trading tradeBoot = new Trading(5, 54, 1, 115);
        Trading tradeShield = new Trading(5, 64, 1, 125);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/5.png", 384, 438, "LEVEL_5", "LEVEL_5", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (729 * zoom), (int) (158 * zoom)));

       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/7/craftpix-891178-free-golem-tiny-style-2d-character-sprites/PNG/Golem_01/PNG Sequences/Attacking/Golem_01_Attacking_007.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.8 * enemyDamageMultiplier, 4);

        enemies.add(new EnemyCluster(window, enemy, 3, 41, 327, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 464, 64, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 1080, 53, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 1113, 405, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 7, 651, 419, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 453, 194, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 443, 230, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 50f, 50f, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 1086, 236, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 740, 481, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 715, 484, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 179, 355, 5000,1, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 204, 359, 5000,1, 24, "Images/trees/birch.png", 64, 44));


        rocks.add(new Rock(window, 810, 292, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 773, 318, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 745, 318, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 444, 111, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
    rocks.add(new Rock(window, 280, 557, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
    rocks.add(new Rock(window, 307, 552, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 334, 552, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 373, 557, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
    rocks.add(new Rock(window, 319, 201, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));
        rocks.add(new Rock(window, 326, 189, 5000,1, 34, "Images/rocks/rock.png", Color.CYAN, 54, 24));

        Boss boss = new Boss(window, 795, 14, 50,  50,  400, "Images/Bosses/Minotaur_03/PNG Sequences/Attacking/Minotaur_03_Attacking_001.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (3.5 ), 4);


        return new ScreenElements("LEVEL_5", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 6.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_6() throws IOException {
        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 65, 1, 16);
        Trading tradePick = new Trading(5, 65, 1, 26);
        Trading tradeBow = new Trading(5, 65, 1, 36);
        Trading tradeAxe = new Trading(5, 65, 1, 46);
        Trading tradeCoal = new Trading(5, 65, 1, 56);
        Trading tradeWood = new Trading(5, 55, 1, 66);
        Trading tradeFood = new Trading(5, 55, 1, 76);
        Trading tradeHelmet = new Trading(5, 55, 1, 86);
        Trading tradeChest = new Trading(5, 55, 1, 96);
        Trading tradeLegs = new Trading(5, 55, 1, 156);
        Trading tradeBoot = new Trading(5, 55, 1, 116);
        Trading tradeShield = new Trading(5, 65, 1, 126);

        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/5.png", 350, 425, "LEVEL_6", "LEVEL_6", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();

       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2 * enemyDamageMultiplier, 5);

        enemies.add(new EnemyCluster(window, enemy, 2, 202, 536, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 448, 358, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 460, 173, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 198, 193, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 1161, 485, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 7, 971, 308, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 50f, 50f, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 856, 425, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 885, 423, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 444, 381, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 419, 137, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 446, 135, 5000,1, 25, "Images/trees/cedar.png", 65, 45));
      trees.add(new Tree(window, 24, 74, 5000,1, 25, "Images/trees/cedar.png", 65, 45));


        rocks.add(new Rock(window, 19, 507, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 607, 292, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
       rocks.add(new Rock(window, 573, 288, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 288, 299, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 287, 271, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 312, 290, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
      rocks.add(new Rock(window, 798, 37, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 355, 552, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
       rocks.add(new Rock(window, 329, 524, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 1188, 552, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 1191, 522, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));
        rocks.add(new Rock(window, 1131, 553, 5000,1, 34, "Images/rocks/rock.png", Color.MAGENTA, 55, 25));

        Boss boss = new Boss(window, 1086,78, 50,  50,  400, "Images/Bosses/Wraith_03/PNG Sequences/Attacking/Wraith_03_Attack_001.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (4 ), 5);

        return new ScreenElements("LEVEL_6", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 7.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_7() throws IOException {
        RenderWindow window = GameScreen.getWindow();

        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();

        Trading tradeSword = new Trading(5, 66, 1, 17);
        Trading tradePick = new Trading(5, 66, 1, 27);
        Trading tradeBow = new Trading(5, 66, 1, 37);
        Trading tradeAxe = new Trading(5, 66, 1, 47);
        Trading tradeCoal = new Trading(5, 66, 1, 57);
        Trading tradeWood = new Trading(5, 56, 1, 67);
        Trading tradeFood = new Trading(5, 56, 1, 77);
        Trading tradeHelmet = new Trading(5, 56, 1, 87);
        Trading tradeChest = new Trading(5, 56, 1, 97);
        Trading tradeLegs = new Trading(5, 56, 1, 167);
        Trading tradeBoot = new Trading(5, 56, 1, 117);
        Trading tradeShield = new Trading(5, 66, 1, 127);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/5.png", 607, 303, "LEVEL_7", "LEVEL_7", tradeBlock);

        List<FloorItem> floorItems = new LinkedList<>();
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (366 * zoom), (int) (530 * zoom)));


       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/2/craftpix-891123-free-golems-chibi-2d-game-sprites/Golem_2/PNG/PNG Sequences/Run Slashing/0_Golem_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.2 * enemyDamageMultiplier, 6);

        enemies.add(new EnemyCluster(window, enemy, 3, 183, 62, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 391, 99, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 823, 82, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 270, 471, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 7, 756, 488, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 8, 1109, 394, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 1061, 35, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 1086, 37, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 93, 282, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 123, 282, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 186, 484, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 215, 484, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 702, 65, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 763, 39, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 760, 65, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 897, 361, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 969, 360, 5000,1, 26, "Images/trees/coconut palm.png", 66, 46));


        rocks.add(new Rock(window, 800f, 300f, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
     rocks.add(new Rock(window, 68, 555, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 100, 549, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 813, 297, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
      rocks.add(new Rock(window, 880, 165, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 908, 169, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 930, 169, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
      rocks.add(new Rock(window, 872, 520, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 847, 520, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 824, 520, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
      rocks.add(new Rock(window, 804, 551, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 787, 557, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
      rocks.add(new Rock(window, 217, 193, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));
        rocks.add(new Rock(window, 241, 191, 5000,1, 36, "Images/rocks/rock.png", Color.YELLOW, 56, 26));

        Boss boss = new Boss(window, 340,543, 50,  50,  400, "Images/Bosses/Wraith_02/PNG Sequences/Taunt/Wraith_02_Taunt_010.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (4.5 ), 6);


        return new ScreenElements("LEVEL_7", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 8.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_8() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 67, 1, 18);
        Trading tradePick = new Trading(5, 67, 1, 28);
        Trading tradeBow = new Trading(5, 67, 1, 38);
        Trading tradeAxe = new Trading(5, 67, 1, 48);
        Trading tradeCoal = new Trading(5, 67, 1, 58);
        Trading tradeWood = new Trading(5, 57, 1, 68);
        Trading tradeFood = new Trading(5, 57, 1, 78);
        Trading tradeHelmet = new Trading(5, 57, 1, 88);
        Trading tradeChest = new Trading(5, 57, 1, 98);
        Trading tradeLegs = new Trading(5, 57, 1, 178);
        Trading tradeBoot = new Trading(5, 57, 1, 118);
        Trading tradeShield = new Trading(5, 67, 1, 128);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/1.png", 254, 434, "LEVEL_8", "LEVEL_8", tradeBlock);
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);

        Enemy enemy = new Enemy(window, 344, 533, 50, 50, enemyHealth, "Images/enemies/2/craftpix-891123-free-golems-chibi-2d-game-sprites/Golem_3/PNG/PNG Sequences/Run Slashing/0_Golem_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.4 * enemyDamageMultiplier, 7);

        enemies.add(new EnemyCluster(window, enemy, 2, 108, 503, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 365, 522, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 68, 300, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 516, 65, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 841, 88, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 1115, 466, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 50f, 50f, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 320, 489, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 349, 488, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 382, 487, 5000,1, 27, "Images/trees/spruce.png", 67, 47));


        trees.add(new Tree(window, 890, 387, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 797, 42, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 477, 97, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 510, 98, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 538, 100, 5000,1, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 191, 322, 5000,1, 27, "Images/trees/spruce.png", 67, 47));



        rocks.add(new Rock(window, 800f, 300f, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
     rocks.add(new Rock(window, 516, 543, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
        rocks.add(new Rock(window, 481, 552, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
        rocks.add(new Rock(window, 509, 161, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
     rocks.add(new Rock(window, 1177, 102, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
        rocks.add(new Rock(window, 1121, 227, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
        rocks.add(new Rock(window, 117, 228, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
     rocks.add(new Rock(window, 191, 418, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));
        rocks.add(new Rock(window, 189, 452, 5000,1, 37, "Images/rocks/rock.png", Color.BLACK, 57, 27));

        Boss boss = new Boss(window, 1095, 464, 50,  50,  400, "Images/Bosses/Minotaur_01/PNG Sequences/Attacking/Minotaur_01_Attacking_000.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (4.5 ), 7);


        return new ScreenElements("LEVEL_8", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 9.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_9() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 68, 1, 19);
        Trading tradePick = new Trading(5, 68, 1, 29);
        Trading tradeBow = new Trading(5, 68, 1, 39);
        Trading tradeAxe = new Trading(5, 68, 1, 49);
        Trading tradeCoal = new Trading(5, 68, 1, 59);
        Trading tradeWood = new Trading(5, 58, 1, 69);
        Trading tradeFood = new Trading(5, 58, 1, 79);
        Trading tradeHelmet = new Trading(5, 58, 1, 89);
        Trading tradeChest = new Trading(5, 58, 1, 99);
        Trading tradeLegs = new Trading(5, 58, 1, 189);
        Trading tradeBoot = new Trading(5, 58, 1, 119);
        Trading tradeShield = new Trading(5, 68, 1, 129);


        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        NPC npc = new NPC(window, "Images/NPCs/2.png", 645, 370, "LEVEL_9", "LEVEL_9", tradeBlock);
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/7/craftpix-891178-free-golem-tiny-style-2d-character-sprites/PNG/Golem_01/PNG Sequences/Attacking/Golem_01_Attacking_007.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.6 * enemyDamageMultiplier, 8);
        enemies.add(new EnemyCluster(window, enemy, 4, 188, 436, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 413, 505, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 125, 74, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 618, 198, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 924, 126, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 1104, 518, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        rocks.add(new Rock(window, 866, 34, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 868, 67, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 898, 61, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 47, 509, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 50, 534, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 74, 51, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 85, 493, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 99, 544, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 194, 455, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 209, 444, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 208, 474, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 231, 474, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 227, 461, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 554, 212, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 532, 192, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 579, 236, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 739, 153, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 736, 180, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 995, 552, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 986, 518, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 1184, 553, 5000,1, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));

        trees.add(new Tree(window, 613, 557, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 583, 552, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 544, 558, 5000,1, 28, "Images/trees/willow.png", 68, 48));


        trees.add(new Tree(window, 669, 559, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 698, 559, 5000,1, 28, "Images/trees/willow.png", 68, 48));


        trees.add(new Tree(window, 792, 560, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 898, 326, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 862, 327, 5000,1, 28, "Images/trees/willow.png", 68, 48));


        trees.add(new Tree(window, 1057, 323, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 1089, 324, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 250, 68, 5000,1, 28, "Images/trees/willow.png", 68, 48));


        trees.add(new Tree(window, 286, 135, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 312, 136, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 340, 134, 5000,1, 28, "Images/trees/willow.png", 68, 48));


        trees.add(new Tree(window, 197, 137, 5000,1, 28, "Images/trees/willow.png", 68, 48));
        trees.add(new Tree(window, 200, 126, 5000,1, 28, "Images/trees/willow.png", 68, 48));
       trees.add(new Tree(window, 80, 33, 5000,1, 28, "Images/trees/willow.png", 68, 48));

        Boss boss = new Boss(window, 114, 529, 50,  50,  400, "Images/Bosses/Wraith_01/PNG Sequences/Attacking/Wraith_01_Attack_000.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, (float) (5 ), 8);


        return new ScreenElements("LEVEL_9", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in level 10.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements LEVEL_10() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 68, 1, 18);
        // Trading tradePick = new Trading(5, 68, 1, 28);
        // Trading tradeBow = new Trading(5, 68, 1, 38);
        // Trading tradeAxe = new Trading(5, 68, 1, 48);
        // Trading tradeCoal = new Trading(5, 68, 1, 58);
        // Trading tradeWood = new Trading(5, 58, 1, 68);
        // Trading tradeFood = new Trading(5, 58, 1, 78);
        // Trading tradeHelmet = new Trading(5, 58, 1, 88);
        // Trading tradeChest = new Trading(5, 58, 1, 98);
        // Trading tradeLegs = new Trading(5, 58, 1, 188);
        // Trading tradeBoot = new Trading(5, 58, 1, 118);
        // Trading tradeShield = new Trading(5, 68, 1, 128);


        Trading tradeBlock[] = {tradeSword};
        NPC npc = new NPC(window, "Images/NPCs/5.png", 503, 532, "LEVEL_10", "LEVEL_10", tradeBlock);
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.8 * enemyDamageMultiplier, 9);
        enemies.add(new EnemyCluster(window, enemy, 2, 55, 441, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 2, 49, 13, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 84, 53, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 1120, 59, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 379, 535, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 2, 61, 327, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 2, 843, 532, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        rocks.add(new Rock(window, 800f, 300f, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 31, 550, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 644, 551, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 445, 33, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 408, 31, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 383, 35, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 1189, 33, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 1192, 551, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 1159, 547, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 110, 553, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        rocks.add(new Rock(window, 355, 327, 5000, 1, 39, "Images/rocks/rock.png", new Color(255, 128, 0), 59, 29));
        trees.add(new Tree(window, 567, 258, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 570, 289, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 568, 325, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 645, 329, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 648, 293, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 650, 255, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));


        trees.add(new Tree(window, 631, 258, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 585, 31, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 584, 53, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 628, 51, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 631, 73, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 1190, 172, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 1194, 334, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));
        trees.add(new Tree(window, 347, 263, 5000, 1, 29, "Images/trees/sakura.png", 69, 49));


        trees.add(new Tree(window, 871, 318, 5000,1, 29, "Images/trees/sakura.png", 69, 49));

        Boss boss = new Boss(window, 606, 308,
                50,  50,  400, "Images/Bosses/Wraith_02/PNG Sequences/Taunt/Wraith_02_Taunt_010.png", GameScreen.getGui(), 10000, 1, 2, 3,  3, true, 5 , 9);


        return new ScreenElements("LEVEL_10", challenge, enemies, trees, rocks, floorItems, npc, boss);
    }

    /**
     * Items to be drawn in room 1.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_1() throws IOException {

        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Goblin/PNG/PNG Sequences/Run Slashing/0_Goblin_Run Slashing_008.png", GameScreen.getGui(), 4000, 1, enemyHitFrequency, false, 1 * enemyDamageMultiplier, 0);

        enemies.add(new EnemyCluster(window, enemy, 4, 671, 451, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));
        enemies.add(new EnemyCluster(window, enemy, 5, 323, 167, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, true));

        trees.add(new Tree(window, 59, 553, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 98, 556, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 134, 555, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 163, 552, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 891, 377, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 917, 374, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 958, 376, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));
        trees.add(new Tree(window, 991, 377, 700, 3, 20, "Images/trees/coconut palm.png", 60, 40));

        return new ScreenElements("ROOM_1", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 2.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_2() throws IOException {

        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading tradeSword = new Trading(5, 69, 1, 19);
        Trading tradePick = new Trading(5, 69, 1, 29);
        Trading tradeBow = new Trading(5, 69, 1, 39);
        Trading tradeAxe = new Trading(5, 69, 1, 49);
        Trading tradeCoal = new Trading(5, 69, 1, 59);
        Trading tradeWood = new Trading(5, 59, 1, 69);
        Trading tradeFood = new Trading(5, 59, 1, 79);
        Trading tradeHelmet = new Trading(5, 59, 1, 89);
        Trading tradeChest = new Trading(5, 59, 1, 99);
        Trading tradeLegs = new Trading(5, 59, 1, 199);
        Trading tradeBoot = new Trading(5, 59, 1, 119);
        Trading tradeShield = new Trading(5, 69, 1, 129);

        Trading tradeBlock[] = {tradeSword, tradePick, tradeBow, tradeAxe, tradeCoal, tradeWood, tradeFood, tradeHelmet, tradeChest, tradeLegs, tradeBoot, tradeShield};
        List<FloorItem> floorItems = new LinkedList<>();

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Ogre/PNG/PNG Sequences/Run Slashing/0_Ogre_Run Slashing_008.png", GameScreen.getGui(), 4000, 2, enemyHitFrequency, false, (float) 1.2 * enemyDamageMultiplier, 1);

        enemies.add(new EnemyCluster(window, enemy, 3, 155, 185, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 922, 107, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 55, 265, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 81, 262, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 113, 260, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 934, 267, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 932, 240, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 925, 199, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));
        trees.add(new Tree(window, 930, 168, 700, 3, 21, "Images/trees/ashberry.png", 61, 41));

        return new ScreenElements("ROOM_2", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 3.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_3() throws IOException {
        
        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.4 * enemyDamageMultiplier, 2);

        enemies.add(new EnemyCluster(window, enemy, 2, 207, 104, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 2, 386, 275, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 2, 245, 412, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 69, 367, 700, 3, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 115, 371, 700, 3, 22, "Images/trees/baobab.png", 62, 42));
        trees.add(new Tree(window, 154, 367, 700, 3, 22, "Images/trees/baobab.png", 62, 42));

        rocks.add(new Rock(window, 360, 196, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 407, 190, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));
        rocks.add(new Rock(window, 456, 196, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 52, 22));

        return new ScreenElements("ROOM_3", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 4.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_4() throws IOException {

        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();

        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/door-key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (180 * zoom), (int) (100 * zoom)));

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/4/craftpix-991117-free-fallen-angel-chibi-2d-game-sprites/Fallen_Angels_1/PNG/PNG Sequences/Run Slashing/0_Fallen_Angels_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.6 * enemyDamageMultiplier, 3);

        enemies.add(new EnemyCluster(window, enemy, 5, 172, 136, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 699, 343, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        rocks.add(new Rock(window, 830, 380, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 53, 23));
        rocks.add(new Rock(window, 871, 378, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 53, 23));
        rocks.add(new Rock(window, 920, 379, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 53, 23));
        rocks.add(new Rock(window, 540, 204, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 53, 23));
        rocks.add(new Rock(window, 502, 204, 700, 3, 32, "Images/rocks/rock.png", Color.BLUE, 53, 23));

        return new ScreenElements("ROOM_4", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 5.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_5() throws IOException {
        
        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/7/craftpix-891178-free-golem-tiny-style-2d-character-sprites/PNG/Golem_01/PNG Sequences/Attacking/Golem_01_Attacking_007.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 1.8 * enemyDamageMultiplier, 4);

        enemies.add(new EnemyCluster(window, enemy, 6, 879, 138, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 138, 240, 700, 3, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 590, 94, 700, 3, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 618, 96, 700, 3, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 969, 248, 700, 3, 24, "Images/trees/birch.png", 64, 44));
        trees.add(new Tree(window, 1000, 240, 700, 3, 24, "Images/trees/birch.png", 64, 44));

        return new ScreenElements("ROOM_5",challenge, enemies, trees, rocks, floorItems);

    }


    /**
     * Items to be drawn in room 6.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_6() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/door-key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (341 * zoom), (int) (97 * zoom)));

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth,"Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2 * enemyDamageMultiplier, 5);

        enemies.add(new EnemyCluster(window, enemy, 4, 94, 369, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 4, 102, 86, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 415, 479, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 400, 134, 700, 3, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 425, 134, 700, 3, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 600, 558, 700, 3, 25, "Images/trees/cedar.png", 65, 45));
        trees.add(new Tree(window, 558, 555, 700, 3, 25, "Images/trees/cedar.png", 65, 45));


        return new ScreenElements("ROOM_6", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 7.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_7() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/2/craftpix-891123-free-golems-chibi-2d-game-sprites/Golem_2/PNG/PNG Sequences/Run Slashing/0_Golem_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.2 * enemyDamageMultiplier, 6);

        enemies.add(new EnemyCluster(window, enemy, 4, 708, 328, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 180, 115, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 97, 381, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 121, 380, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 151, 379, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 183, 381, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 515, 385, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));
        trees.add(new Tree(window, 539, 381, 700, 3, 26, "Images/trees/coconut palm.png", 66, 46));

        return new ScreenElements("ROOM_7", challenge,enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 8.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_8() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();
       //Challenge challenge = new Challenge(window);
        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth,"Images/enemies/2/craftpix-891123-free-golems-chibi-2d-game-sprites/Golem_3/PNG/PNG Sequences/Run Slashing/0_Golem_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.4 * enemyDamageMultiplier, 7);
        enemies.add(new EnemyCluster(window, enemy, 5, 644, 252, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 6, 244, 81, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 124, 283, 700, 3, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 192, 279, 700, 3, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 913, 167, 700, 3, 27, "Images/trees/spruce.png", 67, 47));
        trees.add(new Tree(window, 976, 173, 700, 3, 27, "Images/trees/spruce.png", 67, 47));

        return new ScreenElements("ROOM_8",challenge, enemies, trees, rocks, floorItems);

    }

    /**
     * Items to be drawn in room 9.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_9() throws IOException {
        
        RenderWindow window = GameScreen.getWindow();
       //Challenge challenge = new Challenge(window);
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
        List<FloorItem> floorItems = new LinkedList<>();

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth, "Images/enemies/7/craftpix-891178-free-golem-tiny-style-2d-character-sprites/PNG/Golem_01/PNG Sequences/Attacking/Golem_01_Attacking_007.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.6 * enemyDamageMultiplier, 8);
        enemies.add(new EnemyCluster(window, enemy, 6, 319, 129, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 7, 700, 464, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        rocks.add(new Rock(window, 319, 523, 700, 3, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 342, 504, 700, 3, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));
        rocks.add(new Rock(window, 366, 525, 700, 3, 38, "Images/rocks/rock.png", new Color(255, 0, 255), 58, 28));

        return new ScreenElements("ROOM_9", challenge,enemies, trees, rocks, floorItems);

    }


    /**
     * Items to be drawn in room 10.
     *
     * @return screen elements
     * @throws IOException
     */
    public static final ScreenElements ROOM_10() throws IOException {

        RenderWindow window = GameScreen.getWindow();
        List<EnemyCluster> enemies = new LinkedList<>();
        List<Tree> trees = new LinkedList<>();
        List<Rock> rocks = new LinkedList<>();
        Trading trade1 = new Trading(1, 1, 1, 3);
        Trading trade2 = new Trading(1, 3, 1, 1);
        Trading tradeBlock[] = {trade1, trade2};
       //Challenge challenge = new Challenge(window);
        List<FloorItem> floorItems = new LinkedList<>();
        Texture keyTexture = new Texture();
        keyTexture.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/door-key.png"));
        Key key = new Key(window, keyTexture, 0);
        floorItems.add(new FloorItem(window, key, (int) (510 * zoom), (int) (192 * zoom)));

        Enemy enemy = new Enemy(window, 100, 100, 50, 50, enemyHealth,  "Images/enemies/3/craftpix-064112-free-orc-ogre-and-goblin-chibi-2d-game-sprites/Orc/PNG/PNG Sequences/Run Slashing/0_Orc_Run Slashing_008.png", GameScreen.getGui(), 4000, enemyHitFrequency, false, (float) 2.8 * enemyDamageMultiplier, 9);
        enemies.add(new EnemyCluster(window, enemy, 8, 506, 159, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 3, 721, 138, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));
        enemies.add(new EnemyCluster(window, enemy, 5, 993, 203, PlayerEntity.getPlayer(), GameScreen.getGui(), 5, false));

        trees.add(new Tree(window, 834, 133, 700, 3, 28, "Images/trees/willow.png", 69, 49));
        trees.add(new Tree(window, 860, 129, 700, 3, 28, "Images/trees/willow.png", 69, 49));
        trees.add(new Tree(window, 895, 132, 700, 3, 28, "Images/trees/willow.png", 69, 49));
        trees.add(new Tree(window, 56, 309, 700, 3, 28, "Images/trees/willow.png", 69, 49));
        trees.add(new Tree(window, 86, 307, 700, 3, 28, "Images/trees/willow.png", 69, 49));

        return new ScreenElements("ROOM_10", challenge, enemies,trees, rocks, floorItems);

    }

}
