package logic.entities;

import gui.GameScreen;
import logic.GameLogic;
import logic.items.Bow;
import logic.level.Tier;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import resources.Levels;
import resources.SoundManager;

import java.io.IOException;
import java.nio.file.Paths;
// IA: TODO: class should be in the items package
public class Arrow {
    private RenderWindow spawnWindow;
    RectangleShape arrow;
    private float xPosition;
    private float yPosition;
    private float dx;
    private float dy;
    private Texture arrowTexture = new Texture();
    private Mouse mouse;
    private Vector2f changeInPosition;
    private int width = 15;
    private int height = 15;
    private float damage;
    private Clock clock = new Clock();
    private int time = 600;

    public Arrow(RenderWindow spawnWindow, float damage, float dx, float dy, Character bowPerson) {
        SoundManager.INSTANCE.playSound("arrow");
        this.xPosition = bowPerson.getXPosition() + bowPerson.getWidth() / 2;
        this.yPosition = bowPerson.getYPosition() + bowPerson.getHeight() / 2;
        this.changeInPosition = new Vector2f(dx, dy);
        this.dx = dx;
        this.dy = dy;
        this.spawnWindow = spawnWindow;
        this.arrow = new RectangleShape(new Vector2f(10, 10));
        findAngle(mouse.getPosition(spawnWindow).x, mouse.getPosition(spawnWindow).y);
        this.damage = damage;

        try {
            // Will be changed once all text boxes are produced.
            this.arrowTexture.loadFromFile(Paths.get("Images/G10 - fighting/arrow.png"));
            // Will be changed once all text boxes are produced.
            arrow.setTexture(this.arrowTexture);
        } catch (IOException e) {
            System.out.println("Error in finding file for image.");
        }

    }

    public Arrow(RenderWindow spawnWindow, Character enemy, Character player, float damage) {
        SoundManager.INSTANCE.playSound("arrow");
        this.spawnWindow = spawnWindow;
        this.xPosition = enemy.getXPosition() + enemy.getWidth() / 2;
        this.yPosition = enemy.getYPosition() + enemy.getHeight() / 2;
        this.changeInPosition = new Vector2f((((player.getWidth() / 2 + player.getPositionVector().x - (enemy.getPositionVector().x - enemy.getWidth() / 2))) / 100), (((player.getHeight() / 2 + player.getPositionVector().y) - (enemy.getHeight() / 2 + enemy.getPositionVector().y))) / 100);
        this.damage = damage;
        this.arrow = new RectangleShape(new Vector2f(15, 15));
        findAngle(player.getXPosition(), player.getYPosition());

        try {
            // Will be changed once all text boxes are produced.
            this.arrowTexture.loadFromFile(Paths.get("Images/G10 - fighting/arrow.png"));
            // Will be changed once all text boxes are produced.
            arrow.setTexture(this.arrowTexture);
        } catch (IOException e) {
            System.out.println("Error in finding file for image.");
        }
    }

    /**
     * Constructor for Arrow Class
     *
     * @param spawnWindow RenderWinow that the instance of Arrow will be rendered in
     * @param bowPerson   Instance of player class that is bonded to the bow.
     * @param bow         Instance of Bow, will determine direction and velocity of the arrow.
     */
    public Arrow(RenderWindow spawnWindow, Character bowPerson, Bow bow, float damage) { // IA: TODO: problem that logic.entity.Character is used as a parameter. Can't put it in logic.items package
        SoundManager.INSTANCE.playSound("arrow");
        this.spawnWindow = spawnWindow;
        this.xPosition = bowPerson.getXPosition() + bowPerson.getWidth() / 2;
        this.yPosition = bowPerson.getYPosition() + bowPerson.getHeight() / 2;
        this.changeInPosition = new Vector2f(((mouse.getPosition(spawnWindow).x-(bowPerson.getPositionVector().x-bowPerson.getWidth() / 2))/10),((mouse.getPosition(spawnWindow).y-(bowPerson.getHeight() / 2+bowPerson.getPositionVector().y)))/10);
        this.damage = damage;
        this.arrow = new RectangleShape(new Vector2f(15, 15));
        findAngle(mouse.getPosition(spawnWindow).x,mouse.getPosition(spawnWindow).y);
        try {
            // Will be changed once all text boxes are produced.
            this.arrowTexture.loadFromFile(Paths.get("Images/G10 - fighting/arrow.png"));
            // Will be changed once all text boxes are produced.
            arrow.setTexture(this.arrowTexture);
        } catch (IOException e) {
            System.out.println("Error in finding file for image.");
        }
    }

    /**
     * Rotates texture of Arrow
     *
     * @param mouseX Mouse's x Position
     * @param mouseY Mouse's y Position
     */
    private void findAngle(int mouseX, int mouseY) {
        //y
        float oppsite = (this.yPosition - mouseY);
        //x
        float adjacent = (this.xPosition - mouseX);
        float hypotenuse = (float) (Math.sqrt(Math.pow(oppsite, 2) + Math.pow(adjacent, 2)));

        if (oppsite > 0 && adjacent > 0) {
            float angle = (float) Math.toDegrees((Math.acos(adjacent / hypotenuse)));
            arrow.rotate((float) (270 + angle));

            return;
        } else if (oppsite < 0 && adjacent < 0) {
            float angle = (float) Math.toDegrees((Math.asin(oppsite / hypotenuse)));
            arrow.rotate((float) (90 - angle));

            return;
        } else if (oppsite > 0 && adjacent < 0) {
            float angle = (float) Math.toDegrees((Math.asin(oppsite / hypotenuse)));
            arrow.rotate((float) (angle));

            return;
        } else if (oppsite < 0 && adjacent > 0) {
            float angle = (float) Math.toDegrees((Math.acos(adjacent / hypotenuse)));
            arrow.rotate((float) (180 + angle));

            return;
        }


    }

    /**
     * Renders as instance of an arrow.
     */
    public void draw() {
        arrow.setPosition(xPosition, yPosition);
        arrow.setFillColor(Color.YELLOW);
        spawnWindow.draw(arrow);
        updatePosition();
    }

    /**
     * Updates the position of arrow to emulate movement.
     */
    private void updatePosition() {
        xPosition += changeInPosition.x;
        yPosition += changeInPosition.y;
    }


    /**
     * Checks if an instance of Enemy collides with this instance of an arrow.
     *
     * @param character
     * @return
     */
    public boolean enemyCollide(Character character) {

        float topRightX1 = xPosition + width;
        float topRightY1 = yPosition + height;
        float bottomLeftX1 = xPosition;
        float bottomLeftY1 = yPosition;

        float topRightX2 = character.getXPosition() + character.getWidth();
        float topRightY2 = character.getYPosition() + character.getHeight();
        float bottomLeftX2 = character.getXPosition();
        float bottomLeftY2 = character.getYPosition();


        if (topRightY1 < bottomLeftY2
                || bottomLeftY1 > topRightY2) {

            return false;
        }
        if (topRightX1 < bottomLeftX2
                || bottomLeftX1 > topRightX2) {

            return false;
        }

        return true;
    }


    /**
     * Accessor method
     *
     * @return Damage the arrow will inflict.
     */
    public float getDamage() {
        return damage;
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
        } else if (0 >= xPosition) {
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


    /**
     * Checks if arrow is collding with wall
     * @return True if arrow is collding with wall.
     */
    public boolean tileCollision()
    {

        for(int x = 0; x<GameLogic.getCurrentPlace().getSizeX(); x++)
        {
            for(int y = 0; y<GameLogic.getCurrentPlace().getSizeY(); y++)
            {

                if(!GameLogic.getCurrentPlace().getTileAt(x,y).getType().equals("wall"))
                {
                    continue;
                }
                float x1min = this.xPosition;
                float x1max = this.xPosition + this.width;
                float y1min = this.yPosition;
                float y1max = this.yPosition + this.height;


                float x2min = GameLogic.getCurrentPlace().getTileAt(x,y).getPosX()*GameLogic.getCurrentPlace().getActualTileSize();
                float x2max = GameLogic.getCurrentPlace().getTileAt(x,y).getPosX()*GameLogic.getCurrentPlace().getActualTileSize()+GameLogic.getCurrentPlace().getActualTileSize();
                float y2min = GameLogic.getCurrentPlace().getTileAt(x,y).getPosY()*GameLogic.getCurrentPlace().getActualTileSize();
                float y2max = GameLogic.getCurrentPlace().getTileAt(x,y).getPosY()*GameLogic.getCurrentPlace().getActualTileSize()+GameLogic.getCurrentPlace().getActualTileSize();
                /*RectangleShape shape1 = (new RectangleShape(new Vector2f(x2max-x2min,y2max-y2min)));
                shape1.setFillColor(Color.BLUE);
                shape1.setPosition(x2min,y2min);
                RectangleShape shape2 = (new RectangleShape(new Vector2f(x1max-x1min,y1max-y1min)));
                shape2.setFillColor(Color.RED);
                shape2.setPosition(xPosition,yPosition);
                spawnWindow.draw(shape1);
                spawnWindow.draw(shape2);*/
                if (y1max >= y2min && y1max <= y2max || y1min >= y2min && y1min <= y2max) { // detects if corners overlay

                    if (x1max >= x2min && x1max <= x2max) {
                        return true;
                    }
                    if (x1min >= x2min && x1min <= x2max) {
                        return true;
                    }
                }

            }
        }

        return false;


        /*
        boolean yTrue = true;
        for (int i = (int)yPosition; i <= yPosition + height; i++) {

            double value = Tier.getTileSize() * GameScreen.getZoom();
            int x = (int) (dx / value);
            int y = (int) (i / value);

            Tile tile = GameLogic.getCurrentLevel().getTileAt(x, y);



            if (xPosition > 0 && tile != null) {
                if (!checkTiles(tile.getType())) yTrue = false;
            } else {
                yTrue = false;
            }
        }
        boolean xTrue = true;
        for (int i = (int)xPosition; i <= xPosition + width; i++) {

            double value = (Tier.getTileSize() * GameScreen.getZoom());
            int x = (int) (i / value);
            int y = (int) (dy / (value));

            Tile tile = GameLogic.getCurrentLevel().getTileAt(x, y);

            if (yPosition > 0 && tile != null) {
                if (!checkTiles(tile.getType())) xTrue = false;
            } else {
                xTrue = false;
            }
        }
        System.out.println(xTrue && yTrue);
        return xTrue || yTrue;*/


    }

    private boolean checkTiles(String tileType) {

        switch (tileType) {
            case "door":
                if (clock.getElapsedTime().asMilliseconds() > time) {
                    int tileSize = Tier.getActualTileSize();

                    // To the next level
                    if (xPosition > tileSize * 2 && GameLogic.getCurrentLevelIndex() + 1 < Levels.nrOfLevels()) { // Door is on the right of the screen
                        GameLogic.setToNextLevel();
                        xPosition = tileSize + tileSize / 4;

                        // To the previous level
                    } else if (xPosition < tileSize * 2 && GameLogic.getCurrentLevelIndex() - 1 >= 0) {
                        GameLogic.setToPrevLevel();
                        xPosition = (int) (GameLogic.getCurrentPlaceSizeX() * tileSize - tileSize - width);

                    }
                    clock.restart();
                }
                return false;
            case "floors":
                return true;
            default:
                return false;
        }
    }





}
