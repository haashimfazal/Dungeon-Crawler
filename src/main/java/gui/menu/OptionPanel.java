package gui.menu;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class OptionPanel {
    RectangleShape rectangle;
    Text text;
    RenderWindow window;
    int id;

    /**
     * Constructor for OptionPanel
     * @param window RenderWindow that OptionPanel will be rendered in
     * @param v Dimensions of RectangleShape
     * @param t Text for Option panel
     * @param f Font to be used
     * @param id Unique ID of optionPanel.
     */
    public OptionPanel(RenderWindow window, Vector2f v, String t, Font f, int id) {
        this.id = id;
        rectangle = new RectangleShape(v);
        // rectangle.setPosition(x,y);
        rectangle.setFillColor(Color.WHITE);
        text = new Text(t, f, 30);
        text.setColor(Color.BLACK);
        this.window = window;
    }


    /**
     * Draws OptionPanel visual representation onto RenderWindow
     */
    public void draw() {
        window.draw(rectangle);
        window.draw(text);
    }


    /**
     * Sets the position OptionPanel visualisation will be rendered at.
     * @param x x Position
     * @param y y Position
     */
    public void setPos(Float x, Float y) {
        rectangle.setPosition(x, y);
        text.setPosition(x, y);
    }
}
