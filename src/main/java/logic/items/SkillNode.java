package logic.items;

import gui.GameScreen;
import logic.level.Challenge;
import logic.entities.Player;
import logic.items.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import gui.menu.Bar;
import java.io.IOException;
import java.nio.file.Paths;

public class SkillNode {

    Texture t;
    Clock clock = new Clock();
    RenderWindow window;
    RectangleShape rec;
    int active = 0;
    int strength;
    int time = 300;
    Items item;
    Texture itemImg = new Texture();
    Texture nodeImg = new Texture();
    int check;
    float x;
    float y;
    float xSize = 50;
    float ySize = 50;
    int respawnTime;
    int isUp = 1;
    int xp = 5;
    int selected;
    int id = 15;
    Color color=Color.WHITE;
    int itemid=0;
    int minID;

    /**
     * Constructor for creation of an instance of SkillNode variable.
     *
     * @param win         RenderWindow the SkillNode instance will be rendered in.
     * @param x           X position of SkillNode
     * @param y           Y position of SkillNode
     * @param respawnTime Amount of time it will be until SkillNode respawns
     * @param strength    Strength of SkillNode
     * @throws IOException
     */
    // gui.animation.AnimationGroup playerAnimation=new gui.animation.AnimationGroup(window, 2, "Images/player/1/Fighting/"); //need to change
    public SkillNode(RenderWindow win, float x, float y, int respawnTime, int strength,int id,String s,int itemid,int minID) throws IOException {
        nodeImg.loadFromFile(Paths.get(s));
        window = win;
        this.x = x;
        this.y = y;
        itemImg.loadFromFile(Paths.get("Images/G6 - eating/Heart.png"));
        item = new Items(window, itemImg, 3);
        xSize = (float) (45 * GameScreen.getZoom());
        ySize = (float) (45 * GameScreen.getZoom());
        rec = new RectangleShape(new Vector2f(xSize, ySize));
        rec.setPosition(x, y);
        this.respawnTime = respawnTime;
        this.strength = strength;
        this.id=id;
        this.itemid=itemid;
        this.minID=minID;
    }
    public SkillNode(RenderWindow win, float x, float y, int respawnTime, int strength,int id,String s,Color color,int itemid,int minID) throws IOException {
        nodeImg.loadFromFile(Paths.get(s));
        window = win;
        this.x = x;
        this.y = y;
        itemImg.loadFromFile(Paths.get("Images/G6 - eating/Heart.png"));
        item = new Items(window, itemImg, 3);
        xSize = (float) (45 * GameScreen.getZoom());
        ySize = (float) (45 * GameScreen.getZoom());
        rec = new RectangleShape(new Vector2f(xSize, ySize));
        rec.setPosition(x, y);
        this.respawnTime = respawnTime;
        this.strength = strength;
        this.id=id;
        this.color=color;
        this.itemid=itemid;
        this.minID=minID;
    }

    /**
     * Draws the SkillNode instance into the Render Window
     *
     * @param bar       Bar SkillNode will be present on
     * @param inv       Inventory instance
     * @param player    Player Instance
     * @param challenge Challenge
     */
    public void draw(Bar bar, Inv inv, Player player, Challenge challenge) throws IOException{
        rec.setTexture(nodeImg);
        //rec.setFillColor(color);
        selected = bar.selected;
        if (Keyboard.isKeyPressed(Keyboard.Key.SPACE) && active == 0 && isTouchingPlayer(player) == true && isUp == 1 ) { 
            if (checkTool(inv) == true) {
                check = strength;
                clock.restart();
                active = 1;
            }

        }
        if (active == 1) {

            if (clock.getElapsedTime().asMilliseconds() > time && check > 0 && isTouchingPlayer(player) == true&& inv.amountFree()>0) {

                check--;
                challenge.incCount(id);
                playSound();
                inv.addByID(itemid);
                giveXP(player);
                clock.restart();
            }
            if (check == 0) { //resource depleted
                rec.setFillColor(Color.TRANSPARENT);
                isUp = 0;
                active = 0;
            }
        }
        if (clock.getElapsedTime().asMilliseconds() > (time * strength + respawnTime)) {
            rec.setFillColor(color);
            isUp = 1;
        }
        if(isTouchingPlayer(player) == false||inv.amountFree()<=0){
            active=0;
        }

        window.draw(rec);
    }
        public void playSound(){
            
        }
    /**
     * Gives xP to player instance.
     *
     * @param player Instance of player which will receive xP.
     */
    public void giveXP(Player player) {

    }

    /**
     * Checks if SkillNode is touching player.
     *
     * @param player Instance of player
     * @return True if SkillNode is touching player, false if not.
     */
    public boolean isTouchingPlayer(Player player) {
        float nodeMinX = x;
        float nodeMaxX = x + xSize;
        float nodeMinY = y;
        float nodeMaxY = y + ySize;
        float playerMinX = player.getXPosition();
        float playerMaxX = player.getXPosition() + player.getWidth();
        float playerMinY = player.getYPosition();
        float playerMaxY = player.getYPosition() + player.getHeight();

        if (checkCoords(playerMinX, playerMinY, nodeMinX, nodeMinY, playerMaxX, playerMaxY, nodeMaxX, nodeMaxY) == true) {
            return true;
        }
        if (checkCoords(nodeMinX, nodeMinY, playerMinX, playerMinY, nodeMaxX, nodeMaxY, playerMaxX, playerMaxY) == true) {
            return true;
        }

        return false;
    }

    /**
     * Checks if tool is equipped
     *
     * @param inv Instance of Inventory.
     * @return If tool is present in Inventory.s
     */
    public boolean checkTool(Inv inv) {

        return true;
    }

    /**
     * Checks if one node is colliding with another
     *
     * @param x1min Minimum of first node's x.
     * @param y1min Minimum of first node's y.
     * @param x2min Minimum of second node's x.
     * @param y2min Minimum of second node's uy.
     * @param x1max Maximum of first node's x.
     * @param y1max Maximum of first node's y.
     * @param x2max Maximum of second node's x.
     * @param y2max Maximum of second node's y.
     * @return True if two nodes are colliding, false if not.
     */
    public boolean checkCoords(float x1min, float y1min, float x2min, float y2min, float x1max, float y1max, float x2max, float y2max) {
        if (y1max >= y2min && y1max <= y2max || y1min >= y2min && y1min <= y2max) { //detects if corners overlay
            if (x1max >= x2min && x1max <= x2max) {
                return true;
            }
            if (x1min >= x2min && x1min <= x2max) {
                return true;
            }
        }
        return false;
    }

    public void setStrength(int a) {
        strength = a;
    }
}
