package gui.menu;

import gui.ArmourList;
import logic.items.Inv;
import logic.items.Items;
import org.jsfml.graphics.*;
import org.jsfml.window.Mouse;

public class ArmOpt extends ClickMenu {
    // LinkedList<logic.items.Items> inventory;
    int swapVariableArmour = 12;
    Texture uiPanel1;
    Texture uiPanel2;
    public ArmOpt(RenderWindow win, String[] options, Font f,Texture a,Texture b) {
        super(win, options, f);
        // inventory=l;
        uiPanel1=a;
        uiPanel2=b;
    }

    public void draw(Inv inven, ArmourList arm, Texture blank) {

        mousePosition = mouse.getPosition(window);
        if (high == 1) {

            for (int i = 0; i < numOptions; i++) {
                detectPanel(opt.get(i), inven, arm,blank);
                opt.get(i).draw();
            }
        }
        cursor.setPosition(mousePosition.x, mousePosition.y);

        window.draw(cursor);
    }

    public void detectPanel(OptionPanel o, Inv inven, ArmourList arm, Texture blank) {
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
                    closeCode(inven, arm,blank); // bit you want to happen here
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

    public void closeCode(Inv inven, ArmourList arm, Texture blank) {

        // put in an if for each option
        if (id == 0) { // unequip
            //System.out.println("hellllllllllooooooooooo");
            swapArmour(inven,arm,swapVariableArmour,blank);
            // arm.addItem(inven.getInv().get(swapVariableArmour));
            // arm.getInv().remove(swapVariableArmour + 1);
            // inven.addItem(arm.getInv().get(swapVariableArmour));
            // inven.removeItem(arm.getInv().get(swapVariableArmour));

        }

        if (id == 1) { // close
            // nothing
        }
    }

    public void setVariable(int b) {
        swapVariableArmour = b;
    }

    public void swapArmour(Inv inven, ArmourList arm, int i, Texture blank) {
        Items item = new Items(window, blank, 0); // new game load starter inv (atm its empty but might want wooden tools?)

        arm.getInv().add(i,item);
        inven.getInv().addFirst(arm.getInv().get(i+1));
        arm.getInv().remove(i+1);
        inven.removeFree();
        
        
        
    }


}
