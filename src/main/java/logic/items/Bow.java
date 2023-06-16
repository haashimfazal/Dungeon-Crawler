package logic.items;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;

import java.util.ArrayList;

public class Bow { // IA: removed drawable interface
    private RenderWindow spawnWindow;
    private Mouse mouse;
    private Vector2i mousePosition;
    private int xPosition;
    private int yPosition;
    private boolean equip = false;
    private RectangleShape aimDot = new RectangleShape(new Vector2f(5, 5));

    /**
     * Constructor for Bow
     *
     * @param spawnWindow RenderWindow the bow will be rendered in
     */
    public Bow(RenderWindow spawnWindow) {
        this.spawnWindow = spawnWindow;
    }

    /**
     * Draws the current location of the mouse cursor.
     */
    public void draw() {
        Vector2i mouseP = mouse.getPosition(spawnWindow);

        aimDot.setPosition(mouseP.x, mouseP.y);
        aimDot.setFillColor(Color.RED);
        xPosition = mouseP.x;
        yPosition = mouseP.y;
        spawnWindow.draw(aimDot);

    }


    /**
     * Accessor method
     *
     * @return the current xPosition of the mouse cursor.
     */
    public int getxPosition() {
        return xPosition;
    }


    /**
     * Accessor method
     *
     * @return the current yPosition of the mouse cursor.
     */
    public int getyPosition() {
        return yPosition;
    }

    public Vector2i getPositionVector() {
        return mouse.getPosition(spawnWindow);
    }

}
