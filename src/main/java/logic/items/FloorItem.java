package logic.items;

import gui.GameScreen;
import logic.GameLogic;
import logic.entities.Player;

import java.util.concurrent.ThreadLocalRandom;

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.system.Vector2f;
public class FloorItem {

    private RenderWindow window;
    private RectangleShape floorItem;

    private float xI = 10f;
    private float yI = 10f;
    private Clock clock = new Clock();
    private Items item;
    private int down = 1;
    private int bounce = 5;

    // gui.animation.AnimationGroup playerAnimation=new
    // gui.animation.AnimationGroup(window, 2, "Images/player/1/Fighting/"); //need
    // to change

    /**
     * Creates an instance of FloorItem.
     *
     * @param win  The instance of the RenderWindow the FloorItem will be rendered
     *             on
     * @param item Items to be added onto teh floor item.
     */
    public FloorItem(RenderWindow win, Items item) {
        float zoom = (float) GameScreen.getZoom();
        floorItem = new RectangleShape(new Vector2f(20 * zoom, 20 * zoom));        window = win;
        this.item = item;
        floorItem.setTexture(item.getTexture());
        floorItem.setPosition(xI, yI);
    }

    /**
     * Creates an instance of FloorItem.
     *
     * @param win  The instance of the RenderWindow the .FloorItem will be rendered
     *             on
     * @param item Items to be added onto teh floor item.
     * @param x    position
     * @param y    position
     */
    public FloorItem(RenderWindow win, Items item, int x, int y) {
        float zoom = (float) GameScreen.getZoom();
        floorItem = new RectangleShape(new Vector2f(20 * zoom, 20 * zoom));
        window = win;
        this.item = item;
        int min = -10;
        int max = 10;
        double randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        xI = (float)x + (float) randomNum;
        yI = (float)y + (float) randomNum;
//        down = 1;
        floorItem.setTexture(item.getTexture());
        floorItem.setPosition(xI, yI);
    }


    /**
     * Method to draw floor item.
     *
     * @param player Instance of Player class
     * @param inv    Current Inventory of User playing.
     */
    public void draw(Player player, Inv inv) {
        hoover(player, inv);
    }

    /**
     * Allows FloorItem position to be altered in terms of the player position.
     *
     * @param player Instance of Player class
     * @param inv    Current Inventory of User playing.
     */
    public void hoover(Player player, Inv inv) {

        if (down == 1) {
            window.draw(floorItem);
            xI = floorItem.getPosition().x;
            yI = floorItem.getPosition().y;
            float xP = player.getXPosition();
            float yP = player.getYPosition();
            float xVec = xP - xI;
            float yVec = yP - yI;
            double hy = Math.sqrt(xVec * xVec + yVec * yVec);
            float normX = xVec / (float) hy;
            float normY = yVec / (float) hy;

            if (hy >= 10 && hy <= 100) {
                float weight = 30 / (float) hy;
                float stepX = normX * weight * 3;
                float stepY = normY * weight * 3;
                floorItem.setPosition(xI + stepX, yI + stepY);
            } else {
                floorItem.setPosition(xI, yI + bounce);
                bounce--;
                if (bounce < -5) {
                    bounce = 5;
                }
            }

            if (hy < 10 && hy > -10) {
                if (inv.amountFree() > 0) {
                    inv.getInv().set(inv.findFree(), item);
                    down = 0;
                }
                // If the item to be collected is a key, it doesn't get added to inventory
                if (item instanceof Key) {
                    down = 0;
                    GameLogic.unlockNextLevel();
                    GameLogic.incrementKeyCount();
                }
            }
        }
        // floorItem.setPosition(xI+xVec*xScale,yI+yVec*yScale);
    }

    /**
     * Accessor method
     *
     * @return Current xPosition of the character instance.
     */
    public int getXPosition() {
        return (int) xI;
    }

    /**
     * Accessor method
     *
     * @return Current yPosition of the character instance.
     */
    public int getYPosition() {
        return (int) yI;
    }

    /**
     * Setter method Change the x position to given integer
     */

    public void setXPosition(int a) {
        xI = (float) a;
        floorItem.setPosition(xI, yI);
    }

    /**
     * Setter method Change the y position to given integer
     */
    public void setYPosition(int a) {
        yI = (float) a;
        floorItem.setPosition(xI, yI);
    }

    /**
     * Access if the item is on the floor ot not.
     *
     * @return down value
     */
    public int getDown() {
        return down;
    }

    /**
     * Sets the floor item down or up.
     *
     * @param down
     */
    public void setDown(int down) {
        this.down = down;
    }
}
