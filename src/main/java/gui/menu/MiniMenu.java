package gui.menu;

import org.jsfml.graphics.*;

public class MiniMenu {
    RectangleShape rectangle;
    int high = 0;
    public RenderWindow window;
    Font f;

    /**
     * Constructor for MiniMenu class
     *
     * @param win RenderWindow MiniMenu instance will be rendered on
     * @param f   Font to be used.
     */
    public MiniMenu(RenderWindow win, Font f) {
        window = win;
        this.f = f;
    }


    /**
     * Set High to 1
     */
    public void setHigh() {
        high = 1;
    }

    /**
     * Set High to 0.
     */
    public void setLow() {
        high = 0;
    }
}
