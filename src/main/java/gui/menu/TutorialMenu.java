package gui.menu;

import gui.GameScreen;
import logic.GameLogic;
import logic.entities.Player;
import logic.entities.PlayerEntity;
import logic.level.Tier;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import java.io.IOException;
import java.nio.file.Paths;

public class TutorialMenu {
    private Texture background = new Texture();
    private Texture tutorialText = new Texture();
    private Texture controlsText = new Texture();

    private RenderWindow window;
    private Player p = PlayerEntity.getPlayer();

    private boolean inTutorialMenu = true;
    private boolean controlsMenu = false;

    public static boolean loadState = false;

    public TutorialMenu(RenderWindow w) {
        this.window = w;
        this.loadImages();
    }

    public void driver() {
        // Checks if they are in a tutorial menu and this is not a load game (do not need tutorial menu if it's a load)
        if(inTutorialMenu && !loadState) {
            this.draw();
            this.checkForStart();
            this.checkForControls();
        } else {
            return;
        }
    }

    public void draw() {
        p.setPlayerAlive(false);
        Sprite bg = new Sprite(background);
        Sprite tutText = new Sprite(tutorialText);
        Sprite contText = new Sprite(controlsText);
        tutText.setOrigin(Vector2f.div(new Vector2f(tutorialText.getSize()), 2));
        contText.setOrigin(Vector2f.div(new Vector2f(controlsText.getSize()), 2));
        bg.setScale(GameScreen.getWindow().getSize().x / bg.getLocalBounds().width, GameScreen.getWindow().getSize().y / bg.getLocalBounds().height);
        bg.setPosition(0, 0);
        tutText.setPosition(GameScreen.getWindow().getSize().x / 2, GameScreen.getWindow().getSize().y / 2 - 50);
        contText.setPosition(GameScreen.getWindow().getSize().x / 2, GameScreen.getWindow().getSize().y / 2);
        window.draw(bg);
        window.draw(tutText);
        if(controlsMenu) {
            window.draw(contText);
        }
    }

    public void checkForControls() {
        if(Keyboard.isKeyPressed(Keyboard.Key.F2)) {
            this.controlsMenu = true;
        }
    }

    public void checkForStart() {
        if(Keyboard.isKeyPressed(Keyboard.Key.SPACE)) {
            this.inTutorialMenu = false;
            p.setPlayerAlive(true);
        }
    }

    public boolean getTutorialStatus() {
        return this.inTutorialMenu;
    }



    public void loadImages() {
        try {
            background.loadFromFile(Paths.get("Images/G1 - GUI/Tutorial/bg.png"));
            tutorialText.loadFromFile(Paths.get("Images/G1 - GUI/Tutorial/welcomeText.png"));
            controlsText.loadFromFile(Paths.get("Images/G1 - GUI/Tutorial/controls.png"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void inLoadState(boolean b) {
        loadState = b;
    }
}
