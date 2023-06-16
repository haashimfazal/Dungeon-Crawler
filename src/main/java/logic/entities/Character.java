package logic.entities;

import gui.GameScreen;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

import java.io.IOException;
import java.nio.file.Paths;

abstract class Character { // IA: removed drawable interface
    protected RenderWindow spawnWindow;
    private Texture characterImage = new Texture();
    RectangleShape body;
    protected int xPosition;
    protected int yPosition;
    protected int xSpawn;
    protected int ySpawn;
    protected float width;
    protected float height;
    protected float health;
    protected float maxHealth;
    protected boolean alive = true;
    private int direction = 0;
    private String bootimage;

    /**
     * @param spawnWindow Render window the character class will be spawned in.
     * @param xPosition   X coordinate spawn position
     * @param yPosition   Y coordinate spawn position
     * @param width       Width of RectangleShape
     * @param height      Health of RectangleShape
     * @param health      Health of character of RectangleShape
     * @param bootImage   Initial image of character
     */
    public Character(RenderWindow spawnWindow, int xPosition, int yPosition, float width, float height, float health,
                     String bootImage) {
        this.spawnWindow = spawnWindow;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xSpawn = xPosition;
        this.ySpawn = yPosition;
        this.width = width;
        this.height = height;
        this.health = health / 2;
        this.maxHealth = health;
        this.bootimage = bootImage;
        body = new RectangleShape(new Vector2f(width, height));
        try {
            characterImage.loadFromFile(Paths.get(bootImage));
            body.setTexture(characterImage);
        } catch (IOException e) {
            // System.out.println("Error in finding file for image.");
        }
    }

    /**
     * Method use to draw the current status of the character object on screen.
     */
    public void draw() {
        body.setPosition(xPosition, yPosition);
        //body.setTexture(characterImage);
        body.setSize(new Vector2f(20, 20));
        if (alive) {
            spawnWindow.draw(body);
            // System.out.println(alive);
        } else {

        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int a) {
        direction = a;
    }

    /**
     * Abstract, forces movement to be implemented.
     *
     * @param dx Change in xPosition
     * @param dy Change in yPosition
     */
    abstract void move(double dx, double dy);

    /**
     * Abstract, forces decrease of health to be implemented.
     *
     * @param health
     */
    abstract void decreaseHealth(float health);

    /**
     * Attack method, use to damage another iteration of Character or its
     * subclasses.
     *
     * @param damage Amount of damage inflicted.
     * @param enemy  Character instance to be damaged.
     */
    abstract void attack(float damage, Character enemy);

    /**
     * Accessor method
     *
     * @return Current xPosition of the character instance.
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * Accessor method
     *
     * @return Current yPosition of the character instance.
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Setter method Change the x position to given integer
     */

    public void setXPosition(int a) {
        xPosition = a;
    }

    /**
     * Setter method Change the y position to given integer
     */
    public void setYPosition(int a) {
        yPosition = a;
    }

    /**
     * Accessor method
     *
     * @return Current character texture of the character instance.
     */
    public Texture getCharTexture() {
        return characterImage;
    }

    /**
     * Accessor method
     *
     * @return Current width of the character instance.
     */
    public float getWidth() {
        return width;
    }

    /**
     * Accessor method
     *
     * @return Current height of the character instance.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Checks if this character instance is currently colliding with another
     * Character instance.
     *
     * @param character The instance of Character being compared.
     * @return True if two instances are colliding, else false.
     */
    public boolean collide(Character character) {

        float x1min = this.getXPosition();
        float x1max = this.getXPosition() + this.getWidth();
        float y1min = this.getYPosition();
        float y1max = this.getYPosition() + this.getHeight();

        float x2min = character.getXPosition();
        float x2max = character.getXPosition() + character.getWidth();
        float y2min = character.getYPosition();
        float y2max = character.getYPosition() + character.getHeight();

        if (y1max >= y2min && y1max <= y2max || y1min >= y2min && y1min <= y2max) { // detects if corners overlay
            if (x1max >= x2min && x1max <= x2max) {
                return true;
            }
            if (x1min >= x2min && x1min <= x2max) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a collision with boundary.
     *
     * @return boolean variable whether there is collision with a boundary or not
     */
    public boolean boundaryCollision() {

        if (GameScreen.getWindow().getSize().x <= xPosition + width) {
            xPosition -= 1;
            return true;
        } else if (0 >= this.getXPosition()) {
            this.xPosition += 1;
        } else if (0 >= xPosition) {
            xPosition += 1;
            return true;
        }
        if (GameScreen.getWindow().getSize().y <= yPosition + height) {
            yPosition -= 1;
            return true;
        } else if (0 >= yPosition) {
            yPosition += 1;
            return true;
        }
        return false;
    }

    public void respawn() {
        if (health < 0) {
            alive = false;
        } else {
            alive = true;
        }
    }


    /**
     * Sets spawn location
     *
     * @param x x Location on RenderWindow
     * @param y y Location on RenderWindow
     */
    public void setSpawn(int x, int y) {
        xSpawn = x;
        ySpawn = y;
    }


    public Vector2f getPositionVector() {
        return body.getPosition();
    }


    /**
     * Accessor method
     *
     * @return The Rectangle Shape of the Character.
     */
    public RectangleShape getBody() {
        return body;
    }

    /**
     * Accessor method
     *
     * @return The health of character as percentage.
     */
    public float getHealthPer() {
        return health / maxHealth * 100;
    }

    public String getBootImage()
    {
        return bootimage;
    }

    public boolean getAlive()
    {
        return alive;
    }

}
