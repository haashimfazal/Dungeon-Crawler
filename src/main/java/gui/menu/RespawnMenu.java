package gui.menu;


import gui.GameScreen;
import gui.animation.AnimationGroup;
import logic.GameLogic;
import logic.entities.Player;
import logic.entities.PlayerEntity;
import logic.level.Tier;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import resources.SoundManager;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class RespawnMenu {
    private Texture background = new Texture();
    private Texture respawnText = new Texture();
    private Texture graveStone = new Texture();

    private Sprite grave = new Sprite(graveStone);

    private RenderWindow window;
    private Player p = PlayerEntity.getPlayer();

    private int xPosOnDeath;
    private int yPosOnDeath;
    private int levelIndexOnDeath;
    public static boolean alreadyPlayed = false;

    int count = 0;

    public RespawnMenu(RenderWindow w) {
        this.xPosOnDeath = p.getXPosition();
        this.yPosOnDeath = p.getYPosition();
        this.levelIndexOnDeath = GameLogic.getCurrentLevelIndex();
        this.window = w;
        this.loadImages();
    }

    public void drawGrave() {
        count++;
//        System.out.println(count);
        if(GameLogic.getCurrentLevelIndex() == this.levelIndexOnDeath) {
            grave.setPosition(xPosOnDeath, yPosOnDeath);
            window.draw(grave);
        }
    }

    public void playDeathSound() {
        if(!alreadyPlayed) {
            SoundManager.INSTANCE.playSound("die");
            SoundManager.INSTANCE.setSound(false);
        }
        alreadyPlayed = true;
    }

    public void draw() {
        this.playDeathSound();
        p.setPlayerAlive(false);
        p.respawn();
        Sprite gameBackground = new Sprite(background);
        Sprite reText = new Sprite(respawnText);
        reText.setOrigin(Vector2f.div(new Vector2f(respawnText.getSize()), 2));
        gameBackground.setPosition(0, 0);
        // sets scale of background depending on resolution
        gameBackground.setScale(GameScreen.getWindow().getSize().x / gameBackground.getLocalBounds().width, GameScreen.getWindow().getSize().y / gameBackground.getLocalBounds().height);
        reText.setPosition(GameScreen.getWindow().getSize().x / 2, GameScreen.getWindow().getSize().y / 2);
        window.draw(gameBackground);
        window.draw(reText);
    }

    public void respawnPlayer() {

        p.setXPosition(xPosOnDeath); // Ensures player can't move
        p.setYPosition(yPosOnDeath);
        p.setHealth(0); // Make sure player health doesn't go below 0 whilst dead

        if(Keyboard.isKeyPressed(Keyboard.Key.F1)) {
            SoundManager.INSTANCE.setSound(true);
            GameLogic.setCurrentLevel(0);
            GameLogic.setPlayLevel(true);
            GameScreen.setZoom(GameScreen.getInitialZoom());
            int actualTileSize = GameScreen.getInitialActualTileSize();
            p.setYPosition((int) (actualTileSize + actualTileSize * 0.3));
            p.setXPosition(actualTileSize + actualTileSize / 2);
            p.setHealth(100);
            p.setPlayerAlive(true);
            alreadyPlayed = false;
            this.drawGrave();
        }
    }

    public void loadImages() {
        try {
            background.loadFromFile(Paths.get("Images/G1 - GUI/Death/bg.png"));
            respawnText.loadFromFile(Paths.get("Images/G1 - GUI/Death/diedText.png"));
            graveStone.loadFromFile(Paths.get("Images/death.png"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }


}
