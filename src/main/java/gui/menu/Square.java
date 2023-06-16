package gui.menu;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Square {
    RectangleShape rectangle;
    int high = 0;
    Texture a;
    Texture b;

    /**
     * Constructor for Square class.
     * @param x x position of square
     * @param y y position of square
     * @param a First texture for visualisation of square
     * @param b Second Texture for visualisation of square
     */
    public Square(float x, float y, Texture a, Texture b) {
        rectangle = new RectangleShape(new Vector2f(x, y));
        rectangle.setTexture(a); // implement toggle
        this.a = a;
        this.b = b;
    }


    /**
     * Alternate constructor for Square without textures
     * @param x x position of Square
     * @param y y position of Square
     */
    public Square(float x, float y) {
        rectangle = new RectangleShape(new Vector2f(x, y));
        rectangle.setFillColor(Color.WHITE);

    }

    /**
     * Sets Square to 1.
     * @param m MiniMenu to be setHigh()
     */
    public void setHigh(MiniMenu m) {

        high = 1;
        m.setHigh();
    }


    /**
     * Sets Square to 0.
     * @param m MiniMenu to be setLow()
     */
    public void setLow(MiniMenu m) {
        if (b != null) {
            rectangle.setTexture(b); // implement toggle
        }
        high = 0;
        m.setLow();
    }


    /**
     * Sets Square's high variable to 1, also sets texture if its null.
     */
    public void setHigh() {
        if (a != null) {
            rectangle.setTexture(a); // implement toggle
        }
        rectangle.setFillColor(Color.BLUE); // implement toggle
        high = 1;

    }

    /**
     * Sets Square's high variable to 0, also sets texture if its null.
     */
    public void setLow() {
        if (a != null) {
            rectangle.setTexture(a); // implement toggle
        }
        rectangle.setFillColor(Color.RED);
        high = 0;

    }


    /**
     * Accessor method
     * @returnt instance of high variable, integer, 0 or 1.
     */
    public int getState() {
        return high;
    }


    /**
     * Draws Square onto current RenderWindow
     */
    public void drawMenu() {

    }
}