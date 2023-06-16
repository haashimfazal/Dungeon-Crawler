package logic.entities;

import gui.ArmourList;
import gui.GameScreen;

import java.io.IOException;

import logic.GameLogic;
import org.jsfml.graphics.RenderWindow;

public class PlayerEntity {
    public static Player player;
    /**
     * Initiates player.
     *
     * @param armour list
     * @return player
     */
    public static Player initPlayer(ArmourList armour) throws IOException {
        RenderWindow window = GameScreen.getWindow();

        int actualTileSize = GameLogic.getCurrentPlace().getActualTileSize();
        int x = actualTileSize + actualTileSize / 2;
        int y = actualTileSize + actualTileSize / 2;

        player = new Player(window, x, y, 100, 100, 100, 100, 100, 100, "Images/G10 - fighting/sword.png", armour);

        return player;
    }

    /**
     * Accessor to the player.
     *
     * @return player
     */
    public static Player getPlayer() {
        return player;
    }
}
