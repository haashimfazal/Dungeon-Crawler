package gui.menu;

import gui.ArmourList;
import gui.GameScreen;
import logic.items.Inv;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.*;

public class Bar {
    RectangleShape rectangle;
    public RenderWindow window;
    Square squares[] = new Square[13];
    Square items[] = new Square[9];
    float sqC;
    Texture tex;
    Texture uiPanel1;
    Texture uiPanel2;
    public int selected=1;

    /**
     * Constructor for an instance of Bar class
     * @param tex Texture of Bar
     * @param inven Current Inventory
     * @param uiPanel1 Texture for UIPanel1
     * @param uiPanel2 Texture for UIPanel2
     */
    public Bar( Texture tex, Inv inven, Texture uiPanel1, Texture uiPanel2) {
        this.tex = tex;
        window = GameScreen.getWindow();
        float windowSizeY = GameScreen.getWindow().getSize().y;
        sqC = (float) (windowSizeY * 0.08);
        float sqP = 10;
        float winX = sqP * 12 + sqC * 11;
        rectangle = new RectangleShape(new Vector2f(winX, (float) (windowSizeY * 0.15)));
        float bX = 0;
        float bY = (float) (windowSizeY * 0.90); // Bar is in the last 10% of the window
        rectangle.setPosition(bX, bY);

        for (int i = 0; i < 13; i++) { // makes new squares and set the position
            if (i < 9) {
                squares[i] = new Square(sqC, sqC, uiPanel1, uiPanel2);
                this.uiPanel1 = uiPanel1;
                this.uiPanel2 = uiPanel2;
                items[i] = new Square(sqC, sqC);
                // squares[i].rectangle.setFillColor(Color.BLACK);
                items[i].rectangle.setFillColor(Color.WHITE);
                items[i].rectangle.setTexture(inven.getInv().get(i).getTexture());
            } else {
                squares[i] = new Square(sqC, sqC / 2, uiPanel1, uiPanel2);
            }

            float x = sqC * i + 10 * i + sqP;

            if (i < 9) {
                squares[i].rectangle.setPosition(x, bY + 10 / 2);
                items[i].rectangle.setPosition(x, bY + 10 / 2);
                //
            }
            if (9 <= i && i < 11) {
                squares[i].rectangle.setPosition(x, bY + 10 / 2);

                // squares[a].rectangle.setPosition(x,bY+sqC/2+10/2);
            }
            if (i >= 11) {
                x = sqC * (i - 2) + 10 * (i - 2) + sqP;
                squares[i].rectangle.setPosition(x, bY + sqC / 2 + 10 / 2);
            }

        }
    }

    /**
     * Draws Bar instance onto current RenderWindow
     * @param m Map
     * @param e Inventory
     * @param l Level Menu
     * @param f ArmourMenu
     * @param p Pause
     * @param inven Current Inventory
     * @param arm Current ArmourList
     * @param uiPanel1 UIPanel1
     */
    public void draw(Map m, Inventory e, LevelMenu l, ArmourMenu f, Pause p, Inv inven, ArmourList arm, Texture uiPanel1) {
        window.draw(rectangle);

        for (int i = 0; i < 13; i++) {
            squares[i].rectangle.setFillColor(Color.WHITE);
            if (squares[i].high == 0) {
                squares[i].rectangle.setTexture(uiPanel2);
            } else {
                squares[i].rectangle.setTexture(uiPanel1);
            }

            window.draw(squares[i].rectangle);
        }
        for (int i = 0; i < 9; i++) {

            // change to function that takes from list of items
            // items[i].rectangle.setSize(new Vector2f(sqC,sqC));
            items[i].rectangle.setTexture(inven.getInv().get(i).getTexture());

            window.draw(items[i].rectangle);

        }

        if (Keyboard.isKeyPressed(Keyboard.Key.NUM1)) {
            changeItem(1);
            // a.setColor(Color.RED);
            // b.setColor(Color.GREEN);
            // c.setColor(Color.BLUE);
            
            // d.setColor(Color.GREEN);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM2)) {
            changeItem(2);
            // a.setColor(Color.BLUE);
            // b.setColor(Color.RED);
            // c.setColor(Color.GREEN);
            // d.setColor(Color.RED);
            
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM3)) {
            changeItem(3);
            // a.setColor(Color.GREEN);
            // b.setColor(Color.BLUE);
            // c.setColor(Color.RED);
            // d.setColor(Color.YELLOW);
            

        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM4)) {
            changeItem(4);
            // a.setColor(Color.YELLOW);
            // b.setColor(Color.YELLOW);
            // c.setColor(Color.YELLOW);
            // d.setColor(Color.BLUE);
            
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM5)) {
            changeItem(5);
            
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM6)) {
            changeItem(6);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM7)) {
            changeItem(7);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM8)) {
            changeItem(8);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.NUM9)) {
            changeItem(9);
        }

        if (Keyboard.isKeyPressed(Keyboard.Key.G)) { // save

        }

        if (Keyboard.isKeyPressed(Keyboard.Key.E)) { // inventory
            f.setLow();
            l.setLow();
            e.setHigh();
            m.setLow();
            openMenu(10);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.L)) { // levels
            f.setLow();
            l.setHigh();
            e.setLow();
            m.setLow();
            openMenu(11);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.M)) { // map
            f.setLow();
            l.setLow();
            e.setLow();
            m.setHigh();
            openMenu(12);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.F)) { // armour
            f.setHigh();
            l.setLow();
            e.setLow();
            m.setLow();
            openMenu(13);
        }
        if (Keyboard.isKeyPressed(Keyboard.Key.O)) {
            p.setHigh();
            e.setLow();
            m.setLow();
        }

    }


    /**
     * changes item present in bar
     * @param a Index to be changed.
     */
    public void changeItem(int a) {
        selected=a-1;
        for (int i = 0; i < 9; i++) {
            if (a != i + 1) {
                squares[i].setLow();
            } else {
                squares[i].setHigh();
            }
        }
    }


    /**
     * Opens menu
     * @param a
     */
    public void openMenu(int a) {
        for (int i = 9; i < 13; i++) {
            if (a != i + 1) {
                squares[i].setLow();
            } else {
                squares[i].setHigh();
            }
        }
    }


    /**
     * Accessor Method
     * @return Gets xPosition
     */
    public float getX() {
        return sqC;
    }


    /**
     * Alters texture of the bar.
     */
    public void changeTexture() {

    }

}