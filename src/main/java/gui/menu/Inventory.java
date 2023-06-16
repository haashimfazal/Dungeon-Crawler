package gui.menu;

import java.io.IOException;
import java.util.LinkedList;

import gui.ArmourList;
// import gui.animation.parts.*;
import logic.entities.PlayerEntity;
import logic.items.Boots;
import logic.items.Chest;
import logic.items.Helmet;
//import logic.items.logic.items.FloorItem;
import logic.items.Inv;
import logic.entities.Player;
import logic.items.*;
//import logic.items.FloorItem;
import logic.items.Items;
import logic.items.Legs;
import logic.items.Sword;
import logic.items.Wearables;
import org.jsfml.window.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.Mouse;
import java.util.ArrayList;

public class Inventory extends MiniMenu {
    Mouse mouse;
    Vector2i mousePosition;
    Square squares[] = new Square[70];
    Square items[] = new Square[70];
    RectangleShape backRec;
    float x = 550;
    float y = 330;
    InvOpt invOpt;
    int swapping=0;
    //private ArrayList<logic.items.FloorItem> droppedItems = new ArrayList<logic.items.FloorItem>();


    /**
     *
     * @param win RenderWindow MiniMenu instance will be rendered on
     * @param f Font to be used.
     * @param uiPanel1 UIPanel1 Texture
     * @param uiPanel2 UIPanel2 Texture
     */
    public Inventory(RenderWindow win, Font f,Texture uiPanel1,Texture uiPanel2) throws IOException{
        super(win, f);

        String[] str = new String[4];
        str[0] = "equip";
        str[1] = "drop";
        str[2] = "swap";
        str[3] = "close";

        invOpt = new InvOpt(win, str, f,uiPanel1,uiPanel2);
        backRec = new RectangleShape(new Vector2f(x, y));
        float Pos = (640 - x) / 2;

        backRec.setPosition(Pos, Pos);
    }


    /**
     * Draws Inventory instance onto current RenderWindow instance
     * @param b Bar
     * @param inven Inventory of current items
     * @param arm ArmourList
     * @param uiPanel1 UIPanel Texture 1
     * @param uiPanel2 UIPanel Texture 2
     */
    public void draw(Bar b, Inv inven, ArmourList arm, Texture uiPanel1, Texture uiPanel2,Player player) throws IOException{
        // LinkedList<logic.items.Items> inv = inven.getInv();
        inven.eatCheck(player,b);
        if (high == 1) { // put bits in here if you want it to work when opened
            // if (Mouse.isButtonPressed(Mouse.Button.RIGHT)) {
            // invOpt.setHigh();
            // System.out.println("hewllo world");
            // }
            window.draw(backRec);

            addTiles(inven, arm, uiPanel1, uiPanel2);
            invOpt.draw(this, 3, inven, arm);
            if (Keyboard.isKeyPressed(Keyboard.Key.X)) { // close when condition is met
                setLow();
                b.openMenu(16);
            }
        } else { // stiff in here will only work when its closed

        }
    }


    /**
     * Adds tiles to Inventory
     * @param inven Gets current Inv
     * @param arm Current ArmourList
     * @param uiPanel1 UIPanel texture 1
     * @param uiPanel2 UIPanel texture 2
     */
    public void addTiles(Inv inven, ArmourList arm, Texture uiPanel1, Texture uiPanel2) { // need to change these tiles
                                                                                          // to icons that change whats
                                                                                          // equipped
        // LinkedList<logic.items.Items> inv = inven.getInv();
        float Pos = (640 - x) / 2;
        float xPos = Pos + 5;
        float yPos = Pos + 5;
        float xSpace = x - (11 * 5);
        float tileX = xSpace / 10;
        float inc = tileX + (x - xSpace) / 11;
        for (int i = 0; i < squares.length; i++) {

            if (i % 10 == 0 && i != 0) {
                yPos = yPos + inc;
                xPos = Pos + 5;
            }
            squares[i] = new Square(tileX, tileX);
            items[i] = new Square(tileX, tileX);
            items[i].rectangle.setFillColor(Color.WHITE);

            // squares[i].rectangle.setTexture(tex);

            // set to image of icon when finished
            squares[i].rectangle.setFillColor(Color.WHITE);
            squares[i].rectangle.setTexture(uiPanel2);
            squares[i].rectangle.setPosition(xPos, yPos);
            items[i].rectangle.setPosition(xPos, yPos);
            items[i].rectangle.setTexture(inven.getInv().get(i).getTexture()); // change to function that takes from
                                                                               // list of items
            xPos = xPos + inc;
            if (i < 60) { // may need to change this parameter if we implement scrolling
                // detectTile(squares[i], inven, i);
                detectTilePressed(squares[i], inven, i, uiPanel1, uiPanel2);
                // detectArmour(squares[i], inven, i,arm);
                window.draw(squares[i].rectangle);
                window.draw(items[i].rectangle);
            }

        }
    }


    /**
     * Detects current Tile being interacted with
     * @param s Square instance to be checked
     * @param inven Current Inv
     * @param i Index
     * @param uiPanel1 UIPanel texture 1
     * @param uiPanel2 UIPanel texture 2
     */
    public void detectTilePressed(Square s, Inv inven, int i, Texture uiPanel1, Texture uiPanel2) {
        // LinkedList<logic.items.Items> inv = inven.getInv();
        mousePosition = mouse.getPosition(window);
        Float xMin = s.rectangle.getPosition().x;
        Float xMax = xMin + s.rectangle.getSize().x;
        Float yMin = s.rectangle.getPosition().y;
        Float yMax = yMin + s.rectangle.getSize().y;
        if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax
                && Mouse.isButtonPressed(Mouse.Button.RIGHT)) {
            squares[i].rectangle.setTexture(uiPanel1);
            invOpt.setVariable(i);
            invOpt.setHigh();
            // swap(-1, i, inven); //put -1 in for the first
            invOpt.setPos(xMax, yMax);
        } else {

            squares[i].rectangle.setTexture(uiPanel2);

        }
    }


    /**
     * Swaps items in inventory
     * @param a First item to be swapped
     * @param b Second item to be swapped
     * @param inven Current Inv
     */
    public void swap(int a, int b, Inv inven)throws IOException { // a is location of first, b location of second
        try {
            Thread.sleep(100); // debounce
        } catch (InterruptedException e) {
            System.out.println("thread 2 interrupted");
        }
        while (a < 0) {
//            System.out.println("test");
            for (int i = 0; i < squares.length; i++) {
                if (detectTile2(squares[i], inven, i) == true) {
                    a = i;
//                    System.out.println(a);
                }
            }
        }
        if (a > b) {
            int c = b;
            b = a;
            a = c;
        }

        inven.getInv().add(a, inven.getInv().get(b));
        inven.getInv().add(b + 1, inven.getInv().get(a + 1));
        inven.getInv().remove(a + 1);
        inven.getInv().remove(b + 1);
        //inven.save();
        //inven.load();
        try {
            Thread.sleep(100); // debounce
        } catch (InterruptedException e) {
            System.out.println("thread 2 interrupted");
        }

    }

    /**
     * Swaps armour/weapons.
     * @param a index of item to be swapped
     * @param inven Current Inv
     * @param arm Instance of Armour to be added
     */
    public void swap2(int a, Inv inven, ArmourList arm) { // swapping armour/swords from worn to not worn

        // need a way of detecting a instead
        try {
            Thread.sleep(100); // debounce
        } catch (InterruptedException e) {
            System.out.println("thread 2 interrupted");
        }

        // arm.getInv().add(0,inven.getInv().get(a)); //update this part so that it
        // removes from inv list and adds the item wor
        // arm.getInv().remove(6);
        // 0= 1= 2= 3= 4= 5= 6=
        if (inven.getInv().get(a) instanceof Sword ||inven.getInv().get(a) instanceof BowItem) {

            swapArmour(0, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Shields) {

            swapArmour(5, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Helmet) {

            swapArmour(1, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Chest) {

            swapArmour(2, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Legs) {

            swapArmour(3, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Boots) {

            swapArmour(4, a, inven, arm);
        }
        if (inven.getInv().get(a) instanceof Wearables) {

        } else {
            System.out.println("cant be equipped");
        }
        PlayerEntity.getPlayer().updateItemEquip();

        try {
            Thread.sleep(100); // debounce
        } catch (InterruptedException e) {
            System.out.println("thread 2 interrupted");
        }

    }


    /**
     * Swaps armour
     * @param location Index of first location to be swapped
     * @param secondLocation Index of second location to be swapped
     * @param inven Current Inv
     * @param arm Current ArmourList
     */
    public void swapArmour(int location, int secondLocation, Inv inven, ArmourList arm) {
        arm.getInv().add(location, inven.getInv().get(secondLocation)); // adds the tile to the armour array list
        inven.getInv().add(secondLocation, arm.getInv().get(location + 1)); // adds the tile to the inventory linked
                                                                            // list
        arm.getInv().remove(location + 1); // removes tile now in inventory
        inven.getInv().remove(secondLocation + 1); // removes the old tile now in armour list
    }


    /**
     * Alter method to detect tiles
     * @param s Square instance to be checked
     * @param inven Current Inv
     * @param i Index
     * @return True if tile detected
     */
    public boolean detectTile2(Square s, Inv inven, int i) {
        LinkedList<Items> inv = inven.getInv();
        mousePosition = mouse.getPosition(window);
        Float xMin = s.rectangle.getPosition().x;
        Float xMax = xMin + s.rectangle.getSize().x;
        Float yMin = s.rectangle.getPosition().y;
        Float yMax = yMin + s.rectangle.getSize().y;
        if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax
                && Mouse.isButtonPressed(Mouse.Button.LEFT)) {
            invOpt.setHigh();
            invOpt.setPos(xMax, yMax);
            return true;
        }
        return false;
    }

}
