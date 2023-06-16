package gui.menu;

import gui.GameScreen;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class HealthBar {

    public RenderWindow window;
    Sprite sprites[] = new Sprite[10];
    public RectangleShape rectangle;
    Square squares[] = new Square[11];
    private float health = 100; // just for testing the heart function
    RectangleShape hp;
    float x = 20;
    float y = 410;
    float heartsEndXPos;

    /**
     * Constructor for HeatlhBar
     *
     * @param win RenderWindow instance of HealthBar will be rendered in
     */
    public HealthBar(RenderWindow win) {
        window = win;
        rectangle = new RectangleShape(); // commands to line to the bar
    }


    /**
     * Sets the value of health.
     *
     * @param health value
     */
    public void setHealth(float health) {
        this.health = health;
    }

    /**
     * Bar that goes over hearts to show a percentage of hearts.
     *
     * @param font Font used in health bar
     */
    public void draw(Font font) {

        int barHeight = GameScreen.getInitialActualTileSize();

        double zoom = GameScreen.getInitialZoom();

        hp = new RectangleShape();
        int sizeBetweenHearts = (int) (22 * zoom);
        int x = (GameScreen.getWindow().getSize().x - (squares.length + 1) * sizeBetweenHearts);
        float hpWidth = (float) ((heartsEndXPos - x) / 100 * (100 - health));
        x = (int) (x + ((heartsEndXPos - x) / 100 * health) + zoom * 5); // zoom * 5 is a guessed value

        hp.setPosition(x, 0);
        hp.setSize(new Vector2f(hpWidth, barHeight));
        hp.setFillColor(Color.WHITE);

        int calc = Math.round(health);
        String num2 = Integer.toString(calc);
        Text hpVal = new Text(num2, font, (int) (zoom * 25));

        hpVal.setColor(Color.BLACK);
        hpVal.setPosition(window.getSize().x - hpVal.getGlobalBounds().width - 10, (float) (-2.5 * zoom));

        window.draw(hp);
        window.draw(hpVal);
    }

    /**
     * Draws 10 hearts to represent players health
     *
     * @param tex Texture used to heart.
     */
    public void heartDraw(Texture tex) {

        int barHeight = GameScreen.getInitialActualTileSize();

        float heartSize = (float) (barHeight * 0.9);
        int sizeBetweenHearts = (int) (22 * GameScreen.getInitialZoom());
        int x = GameScreen.getWindow().getSize().x - (squares.length + 1) * sizeBetweenHearts;

        rectangle.setPosition(x, 0);
        rectangle.setSize(new Vector2f((float) ((squares.length + 1) * sizeBetweenHearts), barHeight));

        window.draw(rectangle);

        for (int i = 0; i < squares.length - 1; i++) {
            squares[i] = new Square(heartSize, heartSize);
            squares[i].rectangle.setTexture(tex);
            // squares[i].rectangle.setFillColor(Color.BLUE);
            squares[i].rectangle.setPosition(x, 0);

            window.draw(squares[i].rectangle);
            x = x + sizeBetweenHearts;
        }
        heartsEndXPos = x;
    }

}