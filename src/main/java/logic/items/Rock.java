package logic.items;

import gui.GameScreen;
import org.jsfml.graphics.*;

import logic.entities.Player;
import resources.SoundManager;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;

public class Rock extends SkillNode {
    /**
     * Constructor for creation of an instance of logic.items.Rock variable.
     *
     * @param win         RenderWindow the logic.items.Rock instance will be rendered in.
     * @param x           X position of logic.items.Rock
     * @param y           Y postion of logic.items.Rock
     * @param respawnTime Amount of time it will be until logic.items.Rock respawns
     * @param strength    Strength of logic.items.Rock
     * @throws IOException
     */
    public Rock(RenderWindow win, float x, float y, int respawnTime, int strength, int id, String s, Color color, int itemid, int minID) throws IOException {
        super(win, (float) (x * GameScreen.getInitialZoom()), (float) (y * GameScreen.getInitialZoom()), respawnTime, strength, id, s, color, itemid, minID);

        // heart.loadFromFile(Paths.get("Images/G6 - eating/Heart.png"));

        itemImg.loadFromFile(Paths.get("Images/G7 - mining/coal.png"));

        item = new Items(window, itemImg, 5);
        rec.setTexture(nodeImg);
        rec.setFillColor(color);
        //id=id;
    }

    // IA: add to the logic.entity.Player.java
    public void giveXP(Player player) {
        player.getStats().getMining().incXP(xp);
    }

    /**
     * Checks if the correct tool is being used.
     *
     * @return If an instance of Pickaxe is in the Inventory.
     */
    public boolean checkTool(Inv inv) {
        if (inv.getInv().get(selected) instanceof Pickaxe && inv.getInv().get(selected).getID() >= minID && inv.getInv().get(selected).getID() >= minID) {
            return true;
        } else {
            return false;
        }
    }

    public void playSound() {
        SoundManager.INSTANCE.playSound("pickaxe");
    }

    public RectangleShape getRec() {
        return rec;
    }

}
