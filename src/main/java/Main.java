import gui.GUI;
import gui.GameScreen;
import gui.Renderer;
import gui.menu.LocationInformation;
import gui.menu.MainMenu;
import gui.menu.TutorialMenu;
import logic.*;
import logic.Skills.Trading;
import logic.entities.Enemy;
import logic.entities.NPC;
import logic.entities.Player;
import logic.entities.PlayerEntity;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;
import resources.BackgroundMusic;
import resources.SoundManager;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        //System.load(System.getProperty("user.dir")+"/libfixXInitThreads.so");

        SaveGame save = new SaveGame();

        // Initialises window
        GameLogic.startGame();
        RenderWindow window = new GameScreen().getWindow();

        MainMenu menu = new MainMenu(window);
        boolean newGame = menu.getNewGame();
        boolean loadPreviousSave = menu.getLoadGame();

        // Changes back to the default view when not in the main menu
        window.setView(window.getDefaultView());

        // Creates a new game when player selects new game via menu, change to true for testing
        if (newGame) {
            String difficultyType = menu.getDifficulty();
            //Enemy enemy = new Enemy(GameScreen.getWindow(), 500, 500, 10, 10, 100, "Images/G10 - fighting/sword.png", GameScreen.getGui(), 4000, 5, true);

            //AnimationGroup playerAnimation = new AnimationGroup(window, 5, "Images/player/1/Fighting/"); // need to change
            //Food food = new Food(10f, window, 5, gui.getInven());

            GUI gui = GameScreen.getGui();

            gui.getInven().newGame();
            gui.getArmList().newGame();

            Player player = PlayerEntity.initPlayer(gui.getArmList());
            player.getStats().newGame();
            GameLogic.setCurrentLevel(0); // For testing: sets the current level, counts from 0
            LocationInformation informationAboutTier = new LocationInformation(window);
            Renderer renderer = new Renderer();
            BackgroundMusic backgroundMusic = BackgroundMusic.getInstance();
            SoundManager soundManager = SoundManager.INSTANCE;


            soundManager.setSound(menu.getSound());

            Difficulty diff = new Difficulty(difficultyType, player);

            // logic.Stats stats=new logic.Stats();

            TutorialMenu tutorialScreen = new TutorialMenu(window);
            RenderItems elements = new RenderItems();

            long time = System.currentTimeMillis();


            // Loads previous save if user opted for load recent game
            try {
                if (loadPreviousSave) {
                    save.loadFromFile();
                }
            } catch (Exception e) {
                System.out.println("User does not have a valid save file. Loaded new game.");
            }

            player.updateItemEquip();
            // Main loop
            while (window.isOpen()) {

                window.clear();


//                if (Mouse.isButtonPressed(Mouse.Button.LEFT) && time + 300 < System.currentTimeMillis()) {
//
//                    int x = Mouse.getPosition().x - window.getPosition().x;
//                    int y = Mouse.getPosition().y - window.getPosition().y;
////
////                    int printx = (int)(x / GameScreen.getInitialZoom() * 1.5);
////                    int printy = (int)(y / GameScreen.getInitialZoom() *1.5);
//                    int printx = (int)(x / GameScreen.getInitialZoom() - 25);
//                    int printy = (int)(y / GameScreen.getInitialZoom() - 35);
//
//                    System.out.println(printx + ", " + printy);
//
//                    time = System.currentTimeMillis();
//                }

                // stats.loop(player);
                if(menu.getSound()) {
                    backgroundMusic.playSound("Background/FREE MEDIEVAL BACKGROUND MUSIC (BURGLAR) [NO COPYRIGHT] [FREE DOWNLOAD]");
                }
                // sound.playSound("Background/PinkPanther");
                //sound.playSound("GUI/GUI Sound Effects_020");

                // Render level

                renderer.renderLevel(GameLogic.getCurrentPlace(), window);
                elements.renderLevelItems(); // Renders level items


                player.checkStatus();
                // player.attack(10, enemy);


                player.drawPt2();

                // window.draw(player.body);
                // enemy.move2(player);


                // enemy.move(10,0,player,gui.getInven());

                // food.eat(gui.inven,player);

                // enemy.collide(player);

                // player.checkStatus();
                // player.attack(10, enemy);
                // npc.talk(player);
                // window.draw(player.shieldRec);
                // Display what was drawn (... the red color!)

                // enemy.collide(player);
                // player.checkStatus();


                gui.draw(player);
                gui.getHealthBar().setHealth((int) player.getHealthPer());


                //enemy.draw();
                //enemy.fireArrow(player);

                informationAboutTier.draw(GameLogic.getCurrentPlace().getLevelName());
                //  ec.draw();
                // ec2.draw();


                tutorialScreen.driver();
                window.display();
                // Handle events
                for (Event event : window.pollEvents()) {
                    if (event.type == Event.Type.CLOSED) {
                        // The user pressed the close button
                        window.close();
                    }
                }
            }
        }
    }
}