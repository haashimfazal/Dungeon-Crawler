package gui.menu;

import gui.GameScreen;
import logic.GameLogic;
import logic.entities.PlayerEntity;
import logic.level.Tier;
import org.jsfml.window.*;
import org.jsfml.graphics.*;

import java.util.ArrayList;

public class Map extends MiniMenu {

    Sprite map;

    /**
     * Constructor for Map Class
     *
     * @param win  RenderWindow for Map
     * @param t    Texture for Map
     * @param font Font used in map.
     */
    public Map(RenderWindow win, Texture t, Font font) {
        super(win, font);
        map = new Sprite(t);

        float scale = window.getSize().x / map.getGlobalBounds().width;
        map.setScale(scale, scale);
    }

    /**
     * Renders map onto current RenderWindow.
     */
    public void draw() {

        if (high == 1) {

            window.draw(Maps.getCurrentSprite());

            if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {

                int x = Mouse.getPosition().x - window.getPosition().x;
                int y = Mouse.getPosition().y - window.getPosition().y;

                int levelCount = GameLogic.getKeyCount();

                ArrayList<Boolean> canChangeLevel = new ArrayList<>();

                double width = GameScreen.getWindow().getSize().x / 5;
                double height = GameScreen.getWindow().getSize().y / 2;


                for (int j = 1; j <= 2; j++) {
                    for (int i = 1; i <= 5; i++) {
                        if (width * i >= x && width * (i - 1) <= x && height * j >= y && height * (j - 1) <= y) {
                            canChangeLevel.add(true);
                        } else {
                            canChangeLevel.add(false);
                        }
                    }
                }

                // Checks if any of the levels are pressed
                boolean found = false;

                for (int i = 0; i <= levelCount; i++) { // IA: TODO: leave this line to detect which levels are unlocked
                //for (int i = 0; i <= 9; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (canChangeLevel.get(j) == true && found == false) {
                            GameLogic.setCurrentLevel(i);
                            setLow();
                            found = true;

                            // Open the level
                            GameLogic.setPlayLevel(true);

                            Tier currentLevel = GameLogic.getCurrentPlace();
                            int actualTileSize = GameScreen.getInitialActualTileSize();

                            // First level
                            if (currentLevel.openedDoorY == 0) {
                                PlayerEntity.getPlayer().setYPosition((int) (actualTileSize + actualTileSize * 0.3));
                            }
                            // Any other level
                            else  {
                                PlayerEntity.getPlayer().setYPosition((int) (actualTileSize * currentLevel.openedDoorY + actualTileSize * 0.3));
                            }

                            PlayerEntity.getPlayer().setXPosition(actualTileSize + actualTileSize / 2);

                            GameScreen.calculateZoom();
                            break;
                        }
                    }
                    if (!found) {
                        setLow();
                    }
                }
            }
            if (Keyboard.isKeyPressed(Keyboard.Key.G)) { // Close the map
                setLow();
            }
        }
    }
}

