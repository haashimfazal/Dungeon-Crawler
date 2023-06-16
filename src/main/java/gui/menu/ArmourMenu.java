package gui.menu;

import java.io.IOException;
import java.util.LinkedList;

import gui.ArmourList;
import logic.entities.Player;
import logic.items.Inv;
import logic.items.Items;
import org.jsfml.window.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.Mouse;

public class ArmourMenu extends MiniMenu {
    Mouse mouse;
    Vector2i mousePosition;
    Square squares[] = new Square[6];
    Square items[] = new Square[6];
    Text bonus[] = new Text[8];

    RectangleShape backRec;
    float x = 700;
    float y = 400;
    float Pos;
    int tSize = 40;
    ArmOpt armOpt;
    Texture blank;
    Texture uiPanel1;
    Texture uiPanel2;

    /**
     * Constructor for ArmourMenu
     * @param win RenderWindow MiniMenu instance will be rendered on
     * @param font Font to be used.
     * @param blank Texture for item ArmourSlot
     * @param uiPanel1 Texture for UIPanel1
     * @param uiPanel2 Texture for UIPanel2
     */
    public ArmourMenu(RenderWindow win, Font font, Texture blank, Texture uiPanel1, Texture uiPanel2) {
        super(win, font);
        this.uiPanel1 = uiPanel1;
        this.uiPanel2 = uiPanel2;
        String[] str = new String[2];
        str[0] = "unequip";
        str[1] = "close";
        armOpt = new ArmOpt(win, str, f,uiPanel1,uiPanel2);
        backRec = new RectangleShape(new Vector2f(x, y));
        this.blank = blank;
        float step = (y - (9 * 6));
        int size = Math.round(step) / 7;
        bonus[0] = new Text("hit bonus:", font, tSize);
        bonus[1] = new Text("defence bonus:", font, tSize);
        bonus[2] = new Text("archery bonus", font, tSize);
        bonus[3] = new Text("health bonus", font, tSize);
        bonus[4] = new Text("hit base", font, tSize);
        bonus[5] = new Text("defence base", font, tSize);
        bonus[6] = new Text("archery base", font, tSize);
        bonus[7] = new Text("health base", font, tSize);

        // x=win.getSize().x*0.8f;
        // y=win.getSize().y*0.8f;
        // Pos = ((win.getSize().x - x) / 2);
        
    }


    /**
     * Draws ArmourMenu instance onto current RenderWindow
     * @param b Bar used for reference so Armour Menu is drawn on the correct location.
     * @param a ArmourList, contains the current items of Armour in Inventory.
     * @param inven Current Inventory of User playing.
     */
    public void draw(Bar b, ArmourList a, Inv inven,Player player,Texture ui) throws IOException{

        backRec.setTexture(ui);
        
        bonus[0].setString("hit bonus:".concat(String.valueOf(a.getDamage())));
        bonus[1].setString("defence bonus:".concat(String.valueOf(a.getDefence())));
        bonus[2].setString("archery bonus:".concat(String.valueOf(a.getArchery())));
        bonus[3].setString("health bonus:".concat(String.valueOf(a.getProt())));
        bonus[4].setString("hit base:".concat(String.valueOf(player.getStats().getAttack().getSkill())));
        bonus[5].setString("defence base:".concat(String.valueOf(player.getStats().getDefence().getSkill())));
        bonus[6].setString("archery base:".concat(String.valueOf(player.getStats().getArchery().getSkill())));
        bonus[7].setString("health base:".concat(String.valueOf(player.getStats().getProt().getSkill())));

        if (high == 1) { // put bits in here if you want it to work when opened


            float xMid = window.getSize().x / 2;
            float xSpace = x - (11 * 5);
            float tileX = xSpace / 10;
            float inc = tileX + (x - xSpace) / 11;
            float relMid = xMid - tileX / 2;
            float yPos = Pos;

            for (int i = 0; i < 6; i++) {
                squares[i] = new Square(tileX, tileX);
                squares[i].rectangle.setTexture(uiPanel1);
                items[i] = new Square(tileX, tileX);
                squares[i].rectangle.setPosition(relMid, yPos);
                items[i].rectangle.setPosition(relMid, yPos);
                items[i].rectangle.setFillColor(Color.WHITE);
                Items temp=inven.getItemById(a.getInv().get(i).getID());
                items[i].rectangle.setTexture(temp.getTexture());
                yPos = yPos + inc;

            }
            yPos = yPos - (inc * 4);
            backRec.setPosition(relMid-(x/2), yPos-inc-inc/2);
            window.draw(backRec);
            squares[0].rectangle.setPosition(relMid - inc, yPos); // move arms
            squares[5].rectangle.setPosition(relMid + inc, yPos);
            items[0].rectangle.setPosition(relMid - inc, yPos); // move arms
            items[5].rectangle.setPosition(relMid + inc, yPos);
            //yPos = Pos + inc - 5 - 4 * tSize;
            yPos=squares[1].rectangle.getPosition().y;
            float xPos = relMid-(x/2*0.8f);
            for (int i = 0; i < 8; i++) {

                bonus[i].setPosition(xPos, yPos);
                bonus[i].setColor(Color.BLACK);
                yPos = yPos + inc;
                window.draw(bonus[i]);
                if (i == 3) {
                    xPos = relMid+inc+((x/2)-(x/2*0.8f));
                    yPos=squares[1].rectangle.getPosition().y;
                }
            }

            for (int i = 0; i < 6; i++) {
                detectTilePressed(squares[i], inven, i);
                window.draw(squares[i].rectangle);
                window.draw(items[i].rectangle);
                armOpt.draw(inven, a, blank);
            }

            addTiles();

            if (Keyboard.isKeyPressed(Keyboard.Key.X)) { // close when condition is met
                setLow();
                b.openMenu(16);
            }
        } else { // stiff in here will only work when its closed

        }
    }


    /**
     * Detects the tile which is currenlty being interacted with in the menu
     * @param s Tile which is being hoovered over
     * @param inven Current inventory of User playing
     * @param i Index
     */
    public void detectTilePressed(Square s, Inv inven, int i) {
        LinkedList<Items> inv = inven.getInv();
        mousePosition = mouse.getPosition(window);
        Float xMin = s.rectangle.getPosition().x;
        Float xMax = xMin + s.rectangle.getSize().x;
        Float yMin = s.rectangle.getPosition().y;
        Float yMax = yMin + s.rectangle.getSize().y;
        // if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y >
        // yMin && mousePosition.y < yMax
        // && Mouse.isButtonPressed(Mouse.Button.RIGHT)) {
        // armOpt.setVariable(i);
        // armOpt.setHigh();
        // //swap(-1, i, inven); //put -1 in for the first
        // armOpt.setPos(xMax, yMax);

        // }
        if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax
                && Mouse.isButtonPressed(Mouse.Button.RIGHT)) {
            s.rectangle.setFillColor(Color.BLUE);
            armOpt.setVariable(i);
            armOpt.setHigh();
            // swap(-1, i, inven); //put -1 in for the first
            armOpt.setPos(xMax, yMax);

        }
    }


    /**
     * Adds Tiles to Armour Menu, syncs to what the player currently has equipped.
     */
    public void addTiles() { // need to change these tiles to icons that change whats equipped

        //bonus[1].setColor(Color.BLUE);
        //window.draw(bonus[1]);

    }
}
