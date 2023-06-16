package gui.menu;

import gui.ArmourList;
import logic.Stats;
import logic.items.Inv;
import org.jsfml.window.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Pause extends MiniMenu {

    RectangleShape backRec;
    RectangleShape r1 = new RectangleShape(new Vector2f(60, 200)); // 1 =high when selected
    RectangleShape r2 = new RectangleShape(new Vector2f(60, 200));
    RectangleShape s1 = new RectangleShape(new Vector2f(60, 200));
    RectangleShape s2 = new RectangleShape(new Vector2f(60, 200));
    RectangleShape o1 = new RectangleShape(new Vector2f(60, 200));
    RectangleShape o2 = new RectangleShape(new Vector2f(60, 200));
    Square squares[] = new Square[6];
    Text opt[] = new Text[3];
    float x = 550;
    float y = 330;
    float Pos = (640 - x) / 2;
    Font font;
    int selectVal = 0;
    Clock clock = new Clock();
    Texture a;
    Texture b;

    /**
     *
     * @param win RenderWindow MiniMenu instance will be rendered on
     * @param f   Font to be used.
     * @param a   Texture for part of Pause visualisation
     * @param b   Texture for part of Pause visualisation
     */
    public Pause(RenderWindow win, Font font, Texture a, Texture b) {
        super(win, font);
        this.a = a;
        this.b = b;
        backRec = new RectangleShape(new Vector2f(x, y));
        // r2.setFillColor(Color.RED);
        // s1.setFillColor(Color.RED);
        // o1.setFillColor(Color.RED);
        opt[0] = new Text("resume", font, 30);
        opt[1] = new Text("save and quit", font, 30);
        opt[2] = new Text("options", font, 30);

        backRec.setPosition(Pos, Pos);

        // pause.setTexture(t);
    }

    public void draw(Bar b, Inv inven, ArmourList arm, Stats stat) {

        if(high == 1) { // put bits in here if you want it to work when opened
                
                window.draw(backRec);
                // add while loop if game needs to be paused
                allignRect();

                drawColour(selectVal);
                drawText();
                // while (clock.getElapsedTime().asMilliseconds() < 200) {
                // debounce
                // }

                // can change to mouse instead if need be
                if (Keyboard.isKeyPressed(Keyboard.Key.DOWN)) { // selectVal determines which panel is selected
                    if (selectVal < squares.length / 2) {
                        selectVal = selectVal + 2;
                        clock.restart();
                    }

                }
                if (Keyboard.isKeyPressed(Keyboard.Key.UP)) { // selectVal determines which panel is selected
                    if (selectVal > 0) {
                        selectVal = selectVal - 2;
                        clock.restart();
                    }
                }
                if (Keyboard.isKeyPressed(Keyboard.Key.RETURN) && selectVal == 0) {
                    // options
                    setLow();
                }
                if (Keyboard.isKeyPressed(Keyboard.Key.RETURN) && selectVal == 2) {
                    inven.save();
                    arm.save();
                    stat.save();
                    setLow();
                }
                if (Keyboard.isKeyPressed(Keyboard.Key.RETURN) && selectVal == 4) {
                    setLow();
                }
                if (Keyboard.isKeyPressed(Keyboard.Key.X)) { // close when condition is met
                    setLow();
                    b.openMenu(16);
                    
                }
            
        }
    }

    public void allignRect() {
        float ySize = y / 7;
        float xSize = x - 100;
        float inc = ySize;
        float yPos = Pos + inc;
        float xPos = Pos + (x - xSize) / 2;
        float offset = 10;
        for (int i = 0; i < squares.length; i = i + 2) {

            squares[i] = new Square(xSize, ySize);
            squares[i + 1] = new Square(xSize - offset, ySize - offset);
            // squares[i].rectangle.setFillColor(Color.YELLOW); //colour when selected
            // (border)
            // squares[i+1].rectangle.setFillColor(Color.BLACK); //colour of inside
            squares[i].rectangle.setPosition(xPos, yPos);
            squares[i + 1].rectangle.setPosition(xPos + offset / 2, yPos + offset / 2);
            squares[i + 1].rectangle.setTexture(a);
            yPos = yPos + inc * 2;
        }
    }

    public void drawText() {

        int ySize = 47;
        float xSize = x - 100;
        float inc = ySize;
        float yPos = Pos + inc;
        float xPos = Pos + (x - xSize) / 2;
        float offset = 10;

        for (int i = 0; i < 3; i++) {
            opt[i].setColor(Color.BLACK);
            opt[i].setPosition(xPos + offset * 2, yPos);
            window.draw(opt[i]);
            yPos = yPos + inc * 2;
        }
    }

    public void drawColour(int a) {
        for (int i = 0; i < squares.length; i = i + 2) {
            squares[i].rectangle.setTexture(this.a);
        }
        squares[a].rectangle.setTexture(b);
        for (int i = 0; i < squares.length; i++) {
            window.draw(squares[i].rectangle);
        }
    }
}
