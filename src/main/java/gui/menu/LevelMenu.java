package gui.menu;

import org.jsfml.window.*;

import logic.entities.Player;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class LevelMenu extends MiniMenu {

    Square squares[] = new Square[6];
    Text skillNames[] = new Text[6];
    Text skillLevels[] = new Text[6];
    Text skillProgress[] = new Text[6];
    RectangleShape backRec;
    Text percent;
    Text level;
    float x = 700;
    float y = 400;

    /**
     * Constructor for LevelMenu class
     * @param win RenderWindow MiniMenu instance will be rendered on
     * @param font Font to be used.
     */
    public LevelMenu(RenderWindow win, Font font,Texture ui) {
        super(win, font);


        
       // x=win.getSize().x*0.8f;
        //y=win.getSize().y*0.8f;
        backRec = new RectangleShape(new Vector2f(x, y));
        float Pos = (win.getSize().x- x) / 2;
        skillNames[0] = new Text("melee", font, 50);
        skillNames[1] = new Text("defence", font, 50);
        skillNames[2] = new Text("archery", font, 50);
        skillNames[3] = new Text("health", font, 50);
        skillNames[4] = new Text("woodcutting", font, 50);
        skillNames[5] = new Text("mining", font, 50);
        skillLevels[0] = new Text("0", font, 50);
        skillLevels[1] = new Text("0", font, 50);
        skillLevels[2] = new Text("0", font, 50);
        skillLevels[3] = new Text("0", font, 50);
        skillLevels[4] = new Text("0", font, 50);
        skillLevels[5] = new Text("0", font, 50);
        skillProgress[0] = new Text("0", font, 50);
        skillProgress[1] = new Text("0", font, 50);
        skillProgress[2] = new Text("0", font, 50);
        skillProgress[3] = new Text("0", font, 50);
        skillProgress[4] = new Text("0", font, 50);
        skillProgress[5] = new Text("0", font, 50);
        percent = new Text("percent", font, 40);
        level = new Text("level", font, 40);
        backRec.setTexture(ui);
        backRec.setPosition(win.getSize().x/2-x/2, win.getSize().y/2-y/2-20);
    }


    /**
     * Draws visual representation of LevelMenu onto current RenderWindow
     * @param b
     */
    public void draw(Bar b,Player player) {

        if (high == 1) { // put bits in here if you want it to work when opened

            window.draw(backRec);
            window.draw(skillNames[0]);
            skillLevels[0].setString(Integer.toString(player.getAttack()));
            skillLevels[1].setString(Integer.toString(player.getDefence()));
            skillLevels[2].setString(Integer.toString(player.getArchery()));
            skillLevels[3].setString(Integer.toString(player.getHealthMax()));
            skillLevels[4].setString(Integer.toString(player.getWoodcutting()));
            skillLevels[5].setString(Integer.toString(player.getMining()));
            skillProgress[0].setString(Integer.toString(player.getStats().getAttack().getPercentage()));
            skillProgress[1].setString(Integer.toString(player.getStats().getDefence().getPercentage()));
            skillProgress[2].setString(Integer.toString(player.getStats().getArchery().getPercentage()));
            skillProgress[3].setString(Float.toString(player.getHealthPer()));
            skillProgress[4].setString(Integer.toString(player.getStats().getWoodCutting().getPercentage()));
            skillProgress[5].setString(Integer.toString(player.getStats().getMining().getPercentage()));
            addTiles();

            if (Keyboard.isKeyPressed(Keyboard.Key.X)) { // close when condition is met
                setLow();
                b.openMenu(16);
            }
        } else { // stiff in here will only work when its closed

        }
    }


    /**
     * Adds tiles to LevelMenu
     */
    public void addTiles() { // need to change these tiles to icons that change whats equipped

        float Pos = ((window.getSize().x/2)-(x/2));

        float xMid = window.getSize().x / 2;


        float xSpace = (x*0.75f) - (11 * 5);
        float tileX = xSpace / 10;
        float inc = tileX + ((x*0.75f) - xSpace) / 11;
        float xPos = xMid-(x/2)+inc+inc;
        float yPos = ((window.getSize().y/2)-(y/2)) +inc;
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(tileX, tileX);
            squares[i].rectangle.setFillColor(Color.BLUE); // set to image of icon when finished
            squares[i].rectangle.setPosition(xPos, yPos);
            addText(skillNames[i],skillLevels[i],skillProgress[i], xPos, yPos, inc);
            yPos = yPos + inc;
            window.draw(squares[i].rectangle);
        }
        
        percent.setPosition(skillProgress[0].getPosition().x,skillProgress[0].getPosition().y-inc);
        window.draw(percent);
        level.setPosition(skillLevels[0].getPosition().x,skillLevels[0].getPosition().y-inc);
        window.draw(level);

        
    }


    /**
     * Adds text to level menu, is drawn on current RenderWindow
     * @param t The text
     * @param x xPosition of text
     * @param y yPosition of text.
     * @param inc offset for y position.
     */
    public void addText(Text t1,Text t2,Text t3, float x, float y, float inc) { // need to change these tiles to icons that change whats
                                                               // equipped
        t1.setPosition(x + inc, y);
        t2.setPosition(x + 500, y);
        t3.setPosition(x + 260, y);

        t1.setColor(Color.BLACK);
        t2.setColor(Color.BLACK);
        t3.setColor(Color.BLACK);
        y = y + inc;
        window.draw(t1);
        window.draw(t2);
        window.draw(t3);
    }

}
