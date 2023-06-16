package logic.entities;

import java.io.IOException;
import java.nio.file.Paths;

import gui.GameScreen;
import gui.animation.AnimationGroup;
import logic.GameLogic;
import logic.entities.Player.ItemEquip;
import logic.items.FloorItem;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.*;
import gui.menu.HealthBar;

import java.util.ArrayList;
import java.util.Random;

import gui.GUI;
//import logic.items.logic.items.FloorItem;
import logic.items.Inv;
import logic.items.Items;
import logic.level.Challenge;
import resources.SoundManager;

public class Enemy extends Character {
    private int check = 0;
    private int check2 = 0;
    private int counter = 0;
    private int counter2 = 0;
    private boolean engaged = false;
    private FloorItem drop1;
    private int item1 = 0;
    private int item2 = 0;
    private int item3 = 0;
    private boolean item1Dropped = false;
    private Clock clock = new Clock();
    private int respawnTime;
    private ArrayList<FloorItem> droppedItems = new ArrayList<FloorItem>();
    private int itemCount = 0;
    private boolean inRange = false;
    private int xVector;
    private int yVector;
    protected int hitFrequency = 5;
    protected ArrayList<Arrow> arrows = new ArrayList<Arrow>();
    private Inv inv;
    private boolean canFire = false;
    private Text healthText;
    Font font = new Font();
    AnimationGroup enemyAnimation;
    private int chalID;
    private float damage = 0;

    /**
     * @param spawnWindow Render window the Enemy class will be spawned in.
     * @param xPosition   X coordinate spawn position
     * @param yPosition   Y coordinate spawn position
     * @param width       Width of RectangleShape
     * @param height      Health of RectangleShape
     * @param health      Health of Enemy of RectangleShape
     * @param BootImage   Initial image of Enemy
     */
    public Enemy(RenderWindow spawnWindow, int xPosition, int yPosition, float width, float height, float health,
                 String BootImage, GUI gui, int respawnTime, int hitFrequency, boolean canfire, float damage, int chalID) throws IOException {
        super(spawnWindow, xPosition, yPosition, width, height, health, BootImage);

        this.inv = inv;
        float percentage = health / maxHealth * 100;
        font.loadFromFile(Paths.get("Fonts/bilboregular.ttf"));
        healthText = new Text(Float.toString(percentage), font, 20);
        // drop1=new logic.items.FloorItem(spawnWindow, player, food,xPosition,yPosition);
        this.respawnTime = respawnTime;
        this.hitFrequency = hitFrequency;
        this.canFire = canfire;
        this.enemyAnimation = new AnimationGroup(spawnWindow, 5, "Images/player/1/Fighting/"); // need to change
        this.chalID = chalID;
    }


    public Enemy(RenderWindow spawnWindow, int xPosition, int yPosition, float width, float height, float health,
                 String BootImage, GUI gui, int respawnTime, int one, int hitFrequency, boolean canfire, float damage, int chalID) throws IOException {
        super(spawnWindow, xPosition, yPosition, width, height, health, BootImage);
        float percentage = health / maxHealth * 100;
        font.loadFromFile(Paths.get("Fonts/bilboregular.ttf"));
        healthText = new Text(Float.toString(percentage), font, 20);
        item1 = one;

        this.inv = inv;
        // drop1=new logic.items.FloorItem(spawnWindow, player, food,xPosition,yPosition);
        this.respawnTime = respawnTime;
        this.hitFrequency = hitFrequency;
        this.canFire = canfire;
        this.enemyAnimation = new AnimationGroup(spawnWindow, 5, "Images/player/1/Fighting/"); // need to change
        this.chalID = chalID;
        this.damage = damage;
    }

    public boolean arrowCollide(Character character) {


        float x1min = this.getXPosition();
        float x1max = this.getXPosition() + this.getWidth();
        float y1min = this.getYPosition();
        float y1max = this.getYPosition() + this.getHeight();

        float x2min = character.getXPosition() - character.getWidth() * 3;
        float x2max = character.getXPosition() + character.getWidth() * 3;
        float y2min = character.getYPosition() - character.getHeight() * 3;
        ;
        float y2max = character.getYPosition() + character.getHeight() * 3;

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


    public void draw() {
        body.setPosition(xPosition, yPosition);
        healthText.setPosition(xPosition, yPosition + 10);
        float percentage = health / maxHealth * 100;
        healthText.setString(Float.toString(percentage));
        //if(engaged){

        //}

        //body.setTexture(characterImage);
        body.setSize(new Vector2f(width, height));
        if (alive) {
            spawnWindow.draw(body);
            check2 = 0;
            if (PlayerEntity.getPlayer().collide(this))
                spawnWindow.draw(healthText);
            // System.out.println(alive);
        } else {

        }
        renderArrows();
    }


    private void renderArrows() {
        if(PlayerEntity.getPlayer().isAlive()) {
            for (Arrow arrow : arrows) {


                arrow.draw();

            }
            for (int i = 0; i < arrows.size(); i++) {
                if (arrows.get(i).boundaryCollision() || arrows.get(i).tileCollision()) {
                    //                System.out.println(arrows.get(i).boundaryCollision());
                    arrows.remove(i);
                }

            }
        }
    }

    /**
     * Checks status of Enemy, will dictate wheter it should attack for example.
     */
    public void checkStatus(Player player) {
        this.checkArrows(player.getArrows());
    }

    /**
     * Movement implementation, acts differently depending on if engaged with
     * player.
     *
     * @param dx Change in xPosition
     * @param dy Change in yPosition
     */
    public void move(double dx, double dy) {

        // drop1.draw(player, inv);
        if (!engaged) {
            if (counter <= 5) {
                counter++;
                xPosition += dx;
                yPosition += dy;

            } else {
                if (counter2 <= 5) {
                    counter2++;
                    xPosition -= dx;
                    yPosition -= dy;
                } else {
                    counter = 0;
                    counter2 = 0;
                }
            }
        }

    }

    public void drawPt2(Challenge challenge) throws IOException {

    }

    public int getChalID() {
        return chalID;
    }


    // public void move4(logic.entity.Player player,logic.entity.Enemy enemy,logic.entity.EnemyCluster ec) {
    //     //xI = xPosition;
    //     //yI = yPosition;
    //     float xP = player.getXPosition();
    //     float yP = player.getYPosition();
    //     float xVec = xP - xPosition;
    //     float yVec = yP - yPosition;
    //     double hy = Math.sqrt(xVec * xVec + yVec * yVec);
    //     float normX = xVec / (float) hy;
    //     float normY = yVec / (float) hy;
    //     // System.out.println(hy);
    //     if (hy>30 && hy <= 100&&inRange==false) {
    //         move3(player,enemy,ec);
    //     }else{
    //         move2(player,enemy,ec);
    //     }
    // }
    public void move3(Player player, Enemy enemy, EnemyCluster ec) {
        //xI = xPosition;
        //yI = yPosition;
        float xP = player.getXPosition();
        float yP = player.getYPosition();
        float xVec = xP - xPosition;
        float yVec = yP - yPosition;
        double hy = Math.sqrt(xVec * xVec + yVec * yVec);
        float normX = xVec / (float) hy;
        float normY = yVec / (float) hy;
        // System.out.println(hy);
        if (hy >= 30 && hy <= 100) {
            //float weight = 30 / (float) hy;
            float stepX = normX * 6;
            float stepY = normY * 6;
            setXPosition((int) xPosition + (int) stepX);
            setYPosition((int) yPosition + (int) stepY);
        } else {
            inRange = true;
        }
    }

    public void move2(Player player, Enemy enemy, EnemyCluster ec) {
        float xP = player.getXPosition() + xVector; //yVector is the offset
        float yP = player.getYPosition() + yVector;
        float xVec = xP - xPosition;
        float yVec = yP - yPosition;
        double hy = Math.sqrt(xVec * xVec + yVec * yVec);
        float normX = xVec / (float) hy;
        float normY = yVec / (float) hy;
        // System.out.println(hy);
        if (hy > 6 && hy <= 100) {
            float stepX = normX * 6;
            float stepY = normY * 6;
            setXPosition((int) xPosition + (int) stepX);
            setYPosition((int) yPosition + (int) stepY);
        }
    }

    /**
     * draws dropped items
     *
     * @param player player for item to be drawn to
     */
    public void draw2(Player player, Challenge challenge, Inv inven) throws IOException {

        if (health <= 0) {

            killed(player, challenge, inven);
        }
        for (int i = 0; i < droppedItems.size(); i++) {
            droppedItems.get(i).draw(player, inven);
           
            

            //System.out.println(droppedItems);
        }
    }

    /**
     * Movement implementation, acts differently depending on if engaged with
     * player.
     *
     * @param dx Change in xPosition
     * @param dy Change in yPosition
     */

    public void move(double dx, double dy, Player player, Inv inv, Enemy enemy, EnemyCluster ec, Challenge challenge, Inv inven) throws IOException {
        // if (Keyboard.isKeyPressed(Keyboard.Key.NUM5)) {
        //     decreaseHealth(10f, player,challenge,inven);
        // }
        float xP = player.getXPosition();
        float yP = player.getYPosition();
        float xVec = xP - xPosition;
        float yVec = yP - yPosition;
        double hy = Math.sqrt(xVec * xVec + yVec * yVec);
        float normX = xVec / (float) hy;
        float normY = yVec / (float) hy;
        if (hy > 30 && hy <= 100 && inRange == false) {
            move3(player, enemy, ec);
        } else {
            move2(player, enemy, ec);
        }
        if (alive) {
        } else {
            if (clock.getElapsedTime().asMilliseconds() > respawnTime) {
                //xPosition=xSpawn;
                yPosition = xSpawn;
                xPosition = ySpawn;
                health = maxHealth;
                alive = true;
                check = 0;
            }

        }


        // if (!engaged) {
        //     if (counter <= 5) {
        //         counter++;
        //         xPosition += dx;
        //         yPosition += dy;

        //     } else {
        //         if (counter2 <= 5) {
        //             counter2++;
        //             xPosition -= dx;
        //             yPosition -= dy;

        //         } else {
        //             counter = 0;
        //             counter2 = 0;
        //         }
        //     }
        // }

    }

    /**
     * Decreases health of enemy.
     *
     * @param decrease Change in health.
     */
    public void decreaseHealth(float decrease, Player player, Challenge challenge, Inv inven) throws IOException {

        if (health >= 0) {
            health -= decrease;
            if (health <= 0) {
                killed(player, challenge, inven);
            }
        }

    }

    /**
     * Decreases health of enemy.
     *
     * @param decrease Change in health.
     */
    public void decreaseHealth(float decrease) {
        if (health >= 0) {
            health -= decrease;
            if (health <= 0) {
                killed();
            }
        }
    }

    public void fireArrow(Character player) {
        if (!canFire)
            return;

        Random rand = new Random();
        if (hitFrequency == 0) {
            hitFrequency = 5;
        }
        if (rand.nextInt(hitFrequency * 40) == 1) {
            Arrow temp = new Arrow(spawnWindow, this, player, this.damage / 2);
            if (arrows.size() < 10)
                arrows.add(temp);
            else
                arrows.remove(0);

        }
    }

    /**
     * Returns respawn time
     */
    public int getRespawnTime() {
        return respawnTime;
    }

    public void setRespawnTime(int newRespawnTime) {
        this.respawnTime = newRespawnTime;
    }

    public void setHealth(float newHealth) {
        this.health = newHealth;
    }

    public float getHealth() {
        return this.health;
    }

    public void setHitFrequency(int newFrequency) {
        this.hitFrequency = newFrequency;
    }

    public int getHitFrequency() {
        return hitFrequency;
    }

    /**
     * Will decrease health of another character instance.
     *
     * @param damage Amount of damage inflicted on Character instance
     * @param enemy  Character instance to lose health
     */
    public void attack(float damage, Character enemy) {
       // Random rand = new Random();
       // if (hitFrequency == 0) {
        //    hitFrequency = 5;
        //}
        //if (rand.nextInt(hitFrequency * 40) == 1) {
            //enemy.decreaseHealth(damage);

       // }
       //if(enemy instanceof Enemy){
                enemy.decreaseHealth(damage);

            
       //}
        

    }
    public Items getDrop(Inv inven)throws IOException{
        int min=0;
        int max=1000; //inc to decrease odds
        int random = (int)(Math.random() * (max - min + 1) + min); 
        
        Items temp=inven.getItemById(0);
        if(random>50&&random<=54){
            temp=inven.getItemById(10+item1);
        }
        if(random>54&&random<=58){
            temp=inven.getItemById(20+item1);
        }
        if(random>58&&random<=62){
            temp=inven.getItemById(30+item1);
        }
        if(random>62&&random<=66){
            temp=inven.getItemById(40+item1);
        }
        if(random>66&&random<=70){
            temp=inven.getItemById(50+item1);
        }
        if(random>70&&random<=74){
            temp=inven.getItemById(60+item1);
        }
        if(random>74&&random<78){
            temp=inven.getItemById(70+item1);
        }
        if(random>78&&random<=82){
            temp=inven.getItemById(80+item1);
        }
        if(random>82&&random<=86){
            temp=inven.getItemById(90+item1);
        }
        if(random>86&&random<=91){
            temp=inven.getItemById(100+item1);
        }
        if(random>91&&random<95){
            temp=inven.getItemById(110+item1);
        }
        if(random>95&&random<100){
            temp=inven.getItemById(120+item1);
        }
        return temp;
    }
    /**
     * Called when enemy has died. Therefore, will no longer be drawn.
     */
    private void killed(Player player, Challenge challenge, Inv inven) throws IOException {
        SoundManager.INSTANCE.playSound("enemyDeath");

        Items drop1=getDrop(inven);
        Items drop2=getDrop(inven);
        Items drop3=getDrop(inven);

        if (check == 0) {
            clock.restart();
            
                //FloorItem temp = new FloorItem(spawnWindow, inven.getItemById(item1),getXPosition(),getYPosition());
                FloorItem temp1 = new FloorItem(spawnWindow, drop1, getXPosition(), getYPosition());
                droppedItems.add(temp1);
            
            
                //FloorItem temp = FloorItem(spawnWindow, inven.getItemById(item2),getXPosition(),getYPosition());
                FloorItem temp2 = new FloorItem(spawnWindow, drop2, getXPosition(), getYPosition());
                droppedItems.add(temp2);
                //droppedItems.add(temp2);
            
            
                //FloorItem temp = FloorItem(spawnWindow, inven.getItemById(item3),getXPosition(),getYPosition());
                FloorItem temp3 = new FloorItem(spawnWindow, drop3, getXPosition(), getYPosition());
                droppedItems.add(temp3);
                // droppedItems.add(temp3);
            

            check = 1;

        }
        if(check2==0){
            challenge.incCount(chalID);
            challenge.incCount(chalID + 10);
            if(player.isSword()){
                player.getStats().getAttack().incXP(1);
            }else{
                player.getStats().getArchery().incXP(1);
            }
            
            check2=1;
        }

        spawnItems();

    }

    /**
     * @return item1
     */
    public int getItem1() {
        return item1;
    }

    /**
     * @return item2
     */
    public int getItem2() {
        return item2;
    }

    /**
     * @return item3
     */
    public int getItem3() {
        return item3;
    }

    /**
     * Called when enemy has died. Therefore, will no longer be drawn.
     */
    private void killed() {

        spawnItems();
        clock.restart();
        alive = false;

    }

    /**
     * Spawns items for Player Instance in event logic.entity.Enemy instance dies.
     */
    private void spawnItems() {
        for (int i = itemCount; i < droppedItems.size(); i++) {
            droppedItems.get(i).setXPosition(xPosition);
            droppedItems.get(i).setYPosition(yPosition);
            droppedItems.get(i).setDown(1);
        }
        itemCount++;
    }

    /**
     * Setter method Change the x position to given integer
     */

    public void setXVec(int a) {
        xVector = a;
    }

    /**
     * Setter method Change the y position to given integer
     */
    public void setYVec(int a) {
        yVector = a;
    }

    /**
     * Checks if enemy has been hit by arrows.
     */
    public void checkArrows(ArrayList<Arrow> arrows) {
        int i = -1;
        int x = 0;
        for (Arrow arrow : arrows) {

            if (arrow.enemyCollide(this)) {
                this.decreaseHealth(arrow.getDamage());
                i = x;
            }
            x++;


        }
        if (i != -1)
            arrows.remove(i);
    }


    /**
     * Returns array of arrows aimed at the player
     *
     * @return Array of arrows aimed at the player.
     */
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }


    /**
     * Acessor Method
     *
     * @return The damage of the enemy
     */
    public float getDamage() {
        return damage;
    }


    /**
     * Checks if enemy is collding with wall
     *
     * @return True if arrow is collding with wall.
     */
    public boolean tileCollision() {

        float x1min = this.xPosition;
        float x1max = this.xPosition + this.width/3;
        float y1min = this.yPosition;
        float y1max = this.yPosition + this.height/3;
      
        for (int x = 0; x < GameLogic.getCurrentPlace().getSizeX(); x++) {
            for (int y = 0; y < GameLogic.getCurrentPlace().getSizeY(); y++) {

                if (!GameLogic.getCurrentPlace().getTileAt(x, y).getType().equals("wall")) {
                    continue;
                }



                float x2min = GameLogic.getCurrentPlace().getTileAt(x, y).getPosX() * GameLogic.getCurrentPlace().getActualTileSize();
                float x2max = GameLogic.getCurrentPlace().getTileAt(x, y).getPosX() * GameLogic.getCurrentPlace().getActualTileSize() + GameLogic.getCurrentPlace().getActualTileSize();
                float y2min = GameLogic.getCurrentPlace().getTileAt(x, y).getPosY() * GameLogic.getCurrentPlace().getActualTileSize();
                float y2max = GameLogic.getCurrentPlace().getTileAt(x, y).getPosY() * GameLogic.getCurrentPlace().getActualTileSize() + GameLogic.getCurrentPlace().getActualTileSize();
                /*
                RectangleShape shape1 = (new RectangleShape(new Vector2f(x2max-x2min,y2max-y2min)));
                shape1.setFillColor(Color.BLUE);
                shape1.setPosition(x2min,y2min);

                spawnWindow.draw(shape1);*/


                if (y1max >= y2min && y1max <= y2max) { // detects if corners overlay


                    if (x1max >= x2min && x1max <= x2max) {

                        this.yPosition = yPosition+(int)(y2max-y1max);
                        this.xPosition = xPosition+(int)(x2max-x1max);
                        return true;
                    }
                    if (x1min >= x2min && x1min <= x2max) {

                        this.yPosition = yPosition+(int)(y2max-y1max);
                        this.xPosition = xPosition-(int)(x2max-x1min);
                        return true;
                    }
                }
                if (y1min >= y2min && y1min <= y2max) { // detects if corners overlasy


                    if (x1max >= x2min && x1max <= x2max) {

                        this.yPosition = yPosition+(int)(y2max-y1min);
                        this.xPosition = xPosition+(int)(x2max-x1max);
                        return true;
                    }
                    if (x1min >= x2min && x1min <= x2max) {

                        this.yPosition = yPosition+(int)(y2max-y1min);
                        this.xPosition = xPosition-(int)(x2max-x1min);
                        return true;
                    }
                }


            }
        }

        return false;

    }


}
