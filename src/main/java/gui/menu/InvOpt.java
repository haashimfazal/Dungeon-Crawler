package gui.menu;

import gui.ArmourList;
import logic.items.Inv;
import logic.items.Items;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.*;
import org.jsfml.window.Mouse;

public class InvOpt extends ClickMenu {
    // LinkedList<logic.items.Items> inventory;
    int swapVariableArmour = 12;
    Texture uiPanel1;
    Texture uiPanel2;
    Texture blank=new Texture();
    /**
     *
     * Constructor for InvOpt
     * @param win RenderWindow ClickMenu instance will be rendered in
     * @param options Options in ClickMenu instance
     * @param f Front ClickMenu will use.
     * @param a First Texture
     * @param b Second Texture
     */
    public InvOpt(RenderWindow win, String[] options, Font f,Texture a, Texture b) throws IOException{
        super(win, options, f);
        uiPanel1=a;
        uiPanel2=b;
        blank.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/BLANK_ICON.png")); // change to map when
    }


    /**
     * Draws InvOpt onto current RenderWindow instance
     * @param inv
     * @param i2
     * @param inven
     * @param arm
     */
    public void draw(Inventory inv, int i2, Inv inven, ArmourList arm) throws IOException{

        mousePosition = mouse.getPosition(window);
        if (high == 1) {

            for (int i = 0; i < numOptions; i++) {
                detectPanel(opt.get(i), inv, i, inven, arm);
                opt.get(i).draw();
            }
        }
        cursor.setPosition(mousePosition.x, mousePosition.y);

        window.draw(cursor);
    }


    /**
     * Detects the current Panel being hoovered over by user.
     * @param o The OptionPanel being checked
     * @param inv The current Inventory
     * @param i The index being checked.
     * @param inven Current Inv
     * @param arm Armour list being checked.
     */
    public void detectPanel(OptionPanel o, Inventory inv, int i, Inv inven, ArmourList arm) throws IOException{
        if (high == 1) {
            Float xMin = o.rectangle.getPosition().x;
            Float xMax = xMin + xDim;
            Float yMin = o.rectangle.getPosition().y;
            Float yMax = yMin + yDim;

            if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax) { // if
                o.rectangle.setFillColor(Color.WHITE);
                o.rectangle.setTexture(uiPanel2);
                id = o.id;
                // System.out.println(id);
                if (Mouse.isButtonPressed(Mouse.Button.LEFT)) {
                    closeCode(inv, i, inven, arm); // bit you want to happen here
                    setLow();
                }
            } else {
                o.rectangle.setFillColor(Color.WHITE);
                o.rectangle.setTexture(uiPanel1);
            }
        } else {
            // when low
        }
    }


    /**
     * Closes code inventories.
     * @param inv The current Inventory.
     * @param i The index
     * @param inven The current Inv
     * @param arm The current ArmourList
     */
    public void closeCode(Inventory inv, int i, Inv inven, ArmourList arm)throws IOException{

        // put in an if for each option
        if (id == 0) { // equip

            inv.swap2(swapVariableArmour, inven, arm);

        }
        if (id == 1) { // drop
            Items temp=new Items(window, blank, 0);
            inven.getInv().set(swapVariableArmour,temp);
        }
        if (id == 2) { // swap
            inv.swap(-1, swapVariableArmour, inven);
        }
        if (id == 3) { // close
            // nothing
        }
    }


    /**
     * Sets the swapVariableArmour
     * @param b
     */
    public void setVariable(int b) {
        swapVariableArmour = b;
    }

}
