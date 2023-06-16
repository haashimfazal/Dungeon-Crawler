package gui.menu;

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.Mouse;
import java.util.ArrayList;

public class ClickMenu {
    Mouse mouse;
    Vector2i mousePosition;
    Float x;
    Float y;
    Float xDim;
    Float yDim;
    Text[] strOptions;
    RectangleShape cursor = new RectangleShape(new Vector2f(5, 5));
    int numOptions;
    ArrayList<OptionPanel> opt = new ArrayList<OptionPanel>();
    int high = 0;
    RenderWindow window;
    int id = 0;

    /**
     * Constructor for ClickMenu
     * @param win RenderWindow ClickMenu instance will be rendered in
     * @param options Options in ClickMenu instance
     * @param f Front ClickMenu will use.
     */
    public ClickMenu(RenderWindow win, String[] options, Font f) {
        window = win;
        this.x = 10f;
        this.y = 10f;
        xDim = 200f;
        yDim = 30f;

        numOptions = options.length;
        for (int i = 0; i < numOptions; i++) {
            OptionPanel o = new OptionPanel(win, new Vector2f(xDim, yDim), options[i], f, i);
            o.setPos(x, y);
            y = y + yDim;
            opt.add(o);
        }

        cursor.setFillColor(Color.RED);
    }


    /**
     * Renders ClickMenu instance in current RenderWindow instance
     */
    public void draw() {

        mousePosition = mouse.getPosition(window);
        if (high == 1) {

            for (int i = 0; i < numOptions; i++) {
                detectPanel(opt.get(i));
                opt.get(i).draw();
            }
        }
        cursor.setPosition(mousePosition.x, mousePosition.y);

        window.draw(cursor);
    }


    /**
     * Detect a certain panel in ClickMenu
     * @param o OptionPanel we are detecting
     */
    public void detectPanel(OptionPanel o) {
        if (high == 1) {
            Float xMin = o.rectangle.getPosition().x;
            Float xMax = xMin + xDim;
            Float yMin = o.rectangle.getPosition().y;
            Float yMax = yMin + yDim;

            if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax) { // if
                                                                                                                        // within
                                                                                                                        // range
                                                                                                                        // of
                                                                                                                        // coordinates
                                                                                                                        // of
                                                                                                                        // first
                                                                                                                        // tile
                o.rectangle.setFillColor(Color.BLUE);
                id = o.id;
                // System.out.println(id);
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    closeCode();
                    setLow();
                }
            } else {
                o.rectangle.setFillColor(Color.WHITE);
            }
        } else {
            // when low
        }
    }

    /**
     * Code prior to shutting down running application.
     */
    public void closeCode() { // put code in here for what you want to happen before closed

    }


    /**
     * Sets High instance variable to 1.
     */
    public void setHigh() { // put code in here for what you want to happen before closed
        high = 1;
    }


    /**
     * Sets High instance variable to 0.
     */
    public void setLow() { // put code in here for what you want to happen before closed
        high = 0;
    }


    /**
     * Set Position of Option Panels
     * @param x xPosition of OptionPanel
     * @param y yPosition of OptionPanel
     */
    public void setPos(Float x, Float y) { // put code in here for what you want to happen before closed
        this.x = x;
        this.y = y;
        for (int i = 0; i < numOptions; i++) {
            opt.get(i).setPos(x, y);
            y = y + yDim;
        }

    }

}
