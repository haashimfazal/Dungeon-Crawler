package logic.items;

import org.jsfml.window.*;
import org.jsfml.graphics.*;

public class Items {

    private Window win;
    private Texture t;
    private int id; // IA: don't make it into static
    /**
     * Constructor with Texture for item.
     *
     * @param win RenderWindow instance of class will be rendered in.
     * @param t   Texture of item
     * @param id  Unique ID of item
     */
    public Items(RenderWindow win, Texture t, int id) {
        this.win = win;
        this.t = t;
        this.id = id;
    }

    /**
     * Constructor without Texture for item.
     *
     * @param win RenderWindow instance of class will be rendered in.
     * @param id  Unique ID of item
     */
    public Items(RenderWindow win, int id) {
        this.win = win;
        this.id = id;
    }

    /**
     * Accessor method.
     *
     * @return Current texture of this instance of Item
     */
    public Texture getTexture() {
        return t;
    }

    /**
     * Accessor method.
     *
     * @return ID of this instance of Item
     */
    public int getID() {
        return id;
    }

    /**
     * Accessor method.
     *
     * @return ID of this instance of Item
     */
    public void setID(int a) {
        id = a;
    }
}
