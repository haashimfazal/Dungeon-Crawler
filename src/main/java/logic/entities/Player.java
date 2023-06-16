package logic.entities;

import gui.ArmourList;
import gui.GameScreen;

import gui.menu.MainMenu;
import gui.menu.RespawnMenu;
import logic.items.Bow;
import logic.GameLogic;
import logic.SaveGame;
import logic.Stats;
import logic.items.*;
import logic.level.Tier;
import logic.level.Tile;
import gui.animation.*;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import resources.Levels;
import resources.Rooms;
import resources.SoundManager;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Arrow> arrows = new ArrayList<Arrow>();
    private Bow bow;
    private int count;
    protected boolean alive = true;
    private int woodcutting;
    private int mining;
    private int attack;
    private int defence;
    private int archery;
    private int prot;
    private int slowSpeed; // IA: TODO: depends on size of a window
    private int fastSpeed;
    private CircleShape hitBox = new CircleShape(50);
    private boolean shieldUp = false;
    private ItemEquip itemEquip = ItemEquip.BOW;
    RectangleShape rec0 = new RectangleShape(new Vector2f(width, height));
    RectangleShape rec1 = new RectangleShape(new Vector2f(width, height));
    RectangleShape rec2 = new RectangleShape(new Vector2f(width, height));
    RectangleShape rec3 = new RectangleShape(new Vector2f(width, height));
    RectangleShape rec4 = new RectangleShape(new Vector2f(width, height));
    RectangleShape shieldRec = new RectangleShape(new Vector2f(30f, 30f));
    Stats stats = new Stats();
    private int damage = 10;
    private Clock clock = new Clock();
    private int time = 600;
    private ArmourList armour;
    private AnimationGroup playerAnimation;
    private boolean isPlayerAlive = true;
    private boolean playerRespawned = false;
    private boolean deathSoundPlayed = false;
    private RespawnMenu resMenu;

//    private int prevTileSize;

    /**
     * Two weapon types of the player.
     */
    enum ItemEquip {
        BOW, SWORD
    }

    /**
     * @param spawnWindow Render window the character class will be spawned in.
     * @param xPosition   X coordinate spawn position
     * @param yPosition   Y coordinate spawn position
     * @param health      Health of character of RectangleShape
     * @param attack      Initial attack skill of Player instance
     * @param mining      Initial mining skill of Player instance
     * @param defence     Initial defence skill of Player instance
     * @param archery     Initial archery skill of Player instance
     * @param woodcutting Initial woodcutting skill of Player instance
     * @param bootImage   Initial image of character
     */
    public Player(RenderWindow spawnWindow, int xPosition, int yPosition, float health,
                  int attack, int mining, int defence, int archery, int woodcutting, String bootImage, ArmourList armour) throws IOException {
        super(spawnWindow, xPosition, yPosition, (float) (35 * GameScreen.getZoom()), (float) (35 * GameScreen.getZoom() * 0.8), health, bootImage); // IA: TODO: if the dimensions are the same for the enemy and logic.entity.NPC, add width/height to the character class
        this.archery = archery;
        this.attack = attack;
        this.woodcutting = woodcutting;
        this.defence = defence;
        this.bow = new Bow(spawnWindow);
        this.slowSpeed = (int) (GameScreen.getZoom() * 6);
        this.fastSpeed = (int) (GameScreen.getZoom() * 9);
        this.armour = armour;
        this.playerAnimation = new AnimationGroup(spawnWindow, 5, "Images/player/1/Fighting/"); // need to change
    }



    /**
     * Draws instance of player onto current renderWindow instance.
     */
    @Override
    public void draw() {

        stats.loop(this);
        hitBox.setPosition(xPosition - hitBox.getRadius() / 2, yPosition - hitBox.getRadius() / 2);
        hitBox.setFillColor(Color.BLUE);

        body.setPosition(xPosition, yPosition);
        rec0.setPosition(xPosition, yPosition);
        rec1.setPosition(xPosition, yPosition);
        rec2.setPosition(xPosition, yPosition);
        rec3.setPosition(xPosition, yPosition);
        rec4.setPosition(xPosition, yPosition);

        shieldRec.setPosition(xPosition + width - 30f, yPosition + height / 2 - 30f / 2);
        shieldRec.setFillColor(Color.RED);


        if (alive) {
            //spawnWindow.draw(body);
        }
        renderArrows();
    }

    public void setHealth(float newHealth) {
        this.health = newHealth;
    }

    public void drawPt2() throws IOException {

        if (Keyboard.isKeyPressed(Keyboard.Key.A)  && Keyboard.isKeyPressed(Keyboard.Key.D) == false) {

            if (Keyboard.isKeyPressed(Keyboard.Key.C)) {
                playerAnimation.changeAnimation("Images/player/1/animations/run/", 6);
            } else {
                playerAnimation.changeAnimation("Images/player/1/animations/walk/", 6);
            }

        }
        if (Keyboard.isKeyPressed(Keyboard.Key.D) && Keyboard.isKeyPressed(Keyboard.Key.A) == false) {

            if (Keyboard.isKeyPressed(Keyboard.Key.C)) {
                playerAnimation.changeAnimation("Images/player/1/animations/run/", 6);
            } else {
                playerAnimation.changeAnimation("Images/player/1/animations/walk/", 6);
            }

        }
    
    if (Keyboard.isKeyPressed(Keyboard.Key.W)||Keyboard.isKeyPressed(Keyboard.Key.S)) {

        if (Keyboard.isKeyPressed(Keyboard.Key.C)) {
            playerAnimation.changeAnimation("Images/player/1/animations/run/", 6);
        } else {
            playerAnimation.changeAnimation("Images/player/1/animations/walk/", 6);
        }

    }


        if (Keyboard.isKeyPressed(Keyboard.Key.W) == false && Keyboard.isKeyPressed(Keyboard.Key.A) == false && Keyboard.isKeyPressed(Keyboard.Key.S) == false && Keyboard.isKeyPressed(Keyboard.Key.D) == false) {
            playerAnimation.changeAnimation("Images/player/1/animations/idle/", 3);
        }

        if (Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
            if (armour.getInv().get(0) instanceof logic.items.Sword) {
                playerAnimation.changeAnimation("Images/player/1/animations/Fighting/", 5);
            }
            if (armour.getInv().get(0) instanceof logic.items.BowItem) {
                playerAnimation.changeAnimation("Images/player/1/animations/bow/", 9);
            }

        }
        if(health<=0){
            isPlayerAlive = false;

            if(playerAnimation.getAni().getCount()==playerAnimation.getSize()-1){
                // health=maxHealth;
            }
            resMenu = new RespawnMenu(GameScreen.getWindow()); // brings up the respawn menu
            resMenu.draw();
        }

        playerAnimation.draw(rec0, rec1, rec2, rec3, rec4);



    }

    /**
     * @return Player max health.
     */
    public int getHealthMax() {
        return (int) maxHealth;
    }

    /**
     * @return Current stats of the player.
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Renders current arrows fired by player.
     */
    private void renderArrows() {

        for (Arrow arrow : arrows) {

            arrow.draw();

        }
        for (int i = 0; i < arrows.size(); i++) {
            if (arrows.get(i).boundaryCollision() || arrows.get(i).tileCollision())
                arrows.remove(i);
        }

    }

    /**
     * Checks the current status of instance of player.
     */
    public void playerChecks() {
        shieldUp();
        move(0, 0);
    }

    /**
     * Checks if user wishes for instance of player to currently have their shield up.
     */
    public void shieldUp() {
        if (Keyboard.isKeyPressed(Keyboard.Key.LSHIFT)) {

            shieldUp = true;
        } else {

            shieldUp = false;
        }
    }


    // TODO: no need for dx, dy parameters

    /**
     * Allows User to manipulate the movement of instance of Player.
     */
    public void move(double dx, double dy) {
        if(isPlayerAlive) {
            int realMove;

            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }


            if (keyIsPressed("W")) {
                realMove = setSpeed();
                if (canMoveY(yPosition - realMove)) {
                    alterYPosition(-realMove);
                }
                // TODO: set player's facing direction
            }
            if (keyIsPressed("S")) {
                realMove = setSpeed();
                if (canMoveY((int) (realMove + yPosition + height))) {
                    alterYPosition(realMove);
                }
            }
            if (keyIsPressed("D")) {
                realMove = setSpeed();
                if (canMoveX((int) ((int) realMove + xPosition + width))) {
                    alterXPosition(realMove);
                }
            }
            if (keyIsPressed("A")) {
                realMove = setSpeed();
                if (canMoveX(-realMove + xPosition)) {
                    alterXPosition(-realMove);
                }
            }
        }
    }


    /**
     * Player can save the game using the F5 key
     */
    public void saveGame() {
        SaveGame newSave = new SaveGame();
        if (keyIsPressed("F5")) {
            newSave.saveToFile();
        }
    }

    /**
     * Player can press escape to go the main menu
      */
    private void goToMainMenu() {
        if(keyIsPressed("ESCAPE")) {
            MainMenu m = new MainMenu(GameScreen.getWindow());
        }
    }

    /**
     * If the player is not alive, it checks whether the player opts to respawn
      */
    public void respawn() {
        if(!isPlayerAlive) {
            resMenu.respawnPlayer();
            this.playerRespawned = true;
        }
    }

    /**
     * Sets the speed the player is able to run at.
     *
     * @return The current speed of the instance of the player.
     */
    private int setSpeed() {
        return keyIsPressed("C") ? fastSpeed : slowSpeed;
    }


    /**
     * Checks is the key is pressed
     *
     * @param key
     * @return if the key is pressed
     */
    private boolean keyIsPressed(String key) {
        return Keyboard.isKeyPressed(Keyboard.Key.valueOf(key));
    }

    /**
     * Checks the tile in front of the player (Y) and determines if it can move or not.
     *
     * @param dy y movement
     * @return boolean value if a player can move to the desired position or not
     */
    private boolean canMoveY(int dy) {

        for (int i = (int) (xPosition + width * 0.4); i <= xPosition + width * 0.4; i++) {

            double value = (Tier.getTileSize() * GameScreen.getZoom());
            int x = (int) (i / value);
            int y = (int) (dy / (value));

            Tile tile = GameLogic.getCurrentPlace().getTileAt(x, y);

            if (yPosition > 0 && tile != null) {
                if (!checkTiles(tile.getType())) return false;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks the tile in front of the player (X) and determines if it can move or not.
     *
     * @param dx x movement
     * @return boolean value if a player can move to the desired position or not
     */
    private boolean canMoveX(int dx) {

        for (int i = (int) (yPosition + height * 0.4); i <= yPosition + height * 0.4; i++) {

            double value = Tier.getTileSize() * GameScreen.getZoom();
            int x = (int) (dx / value);
            int y = (int) (i / value);

            Tile tile = GameLogic.getCurrentPlace().getTileAt(x, y);

//            System.out.println(tile.getType());

            if (xPosition > 0 && tile != null) {
                if (!checkTiles(tile.getType())) return false;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Checks if Player is in the area of a certain type of tile.
     *
     * @param tileType String parameter of the type of tile the Player could be on.
     * @return True Tile type being checked is "floor", otherwise returns false.
     */
    private boolean checkTiles(String tileType) {
        int tileSize = GameLogic.getCurrentPlace().getActualTileSize();

        switch (tileType) {
            case "door":
                if (clock.getElapsedTime().asMilliseconds() > time) {

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
            case "stairs_up":
                setToRoom(1);
                return false;
            case "stairs_down":
            case "ladder_down":
            case "rope_down":
                changeToLevelPlayerPos();
                GameLogic.setPlayLevel(true);
                GameScreen.calculateZoom();
                return false;
            case "ladder_up":
                setToRoom(2);
                return false;
            case "rope_up":
                setToRoom(0);
                return false;
            default:
                return false;
        }
    }

    /**
     * Sets current place to the appropriate room.
     *
     * @param i index of a room withing the current level
     */
    private void setToRoom(int i) {
        int prevTileSize = GameLogic.getCurrentPlace().getActualTileSize();
        GameLogic.setPlayLevel(false);
        GameLogic.setCurrentPlace(Rooms.getRoomOfLevel(i));
        GameScreen.calculateZoom();
        changeToRoomPlayerPos(prevTileSize);
    }

    /**
     * Changes player position when it enters the room.
     *
     * @param prevTileSize tile size of the previous room
     */
    private void changeToRoomPlayerPos(int prevTileSize) {

        int tileSize = GameLogic.getCurrentPlace().getActualTileSize();

        // At the top
        if (yPosition < prevTileSize * 2 && xPosition < GameLogic.getCurrentPlaceSizeX() * prevTileSize - prevTileSize * 2 && xPosition > prevTileSize * 2) {
//            System.out.println("top");
            yPosition = (int) (tileSize * GameLogic.getCurrentPlaceSizeY() - tileSize - height);
            xPosition = (int) (xPosition * (GameScreen.getZoom() / GameScreen.getInitialZoom()));
        }
        // At the bottom
        else if (yPosition > GameLogic.getCurrentPlaceSizeY() * prevTileSize - prevTileSize * 2 && xPosition < GameLogic.getCurrentPlaceSizeX() * prevTileSize - prevTileSize * 2 && xPosition > prevTileSize * 2) {
//            System.out.println("bottom");
            yPosition = (int) (tileSize);
            xPosition = (int) (xPosition * (GameScreen.getZoom() / GameScreen.getInitialZoom()));
        }
        // On the right
        else if (xPosition > GameLogic.getCurrentPlaceSizeX() * prevTileSize - prevTileSize * 2 && yPosition < GameLogic.getCurrentPlaceSizeY() * prevTileSize - prevTileSize * 2 && yPosition > prevTileSize * 2) {
//            System.out.println("right");
            xPosition = (int) (tileSize  + width);
            yPosition = (int) (yPosition * (GameScreen.getZoom() / GameScreen.getInitialZoom()));
        }
        // On the left
        else {
//            System.out.println("left");
            xPosition = (int) (GameLogic.getCurrentPlaceSizeX() * tileSize - tileSize - width);
            yPosition = (int) (yPosition * (GameScreen.getZoom() / GameScreen.getInitialZoom()));
        }
    }

    /**
     * Changes player position when it enters the level.
     */
    private void changeToLevelPlayerPos() {

        int prevTileSize = GameScreen.getInitialActualTileSize();
        int tileSize = GameLogic.getCurrentPlace().getActualTileSize();

        // At the top
        if (yPosition < tileSize * 2 && xPosition < GameLogic.getCurrentPlaceSizeX() * tileSize - tileSize * 2 && xPosition > tileSize * 2) {
//            System.out.println("top");
            yPosition = (int) (prevTileSize * GameScreen.getLevelYTiles() - prevTileSize * 1.5 - height);
            xPosition = (int) (xPosition * (GameScreen.getInitialZoom() / GameScreen.getZoom()));
        }
        // At the bottom
        else if (yPosition > GameLogic.getCurrentPlaceSizeY() * tileSize - tileSize * 2 && xPosition < GameLogic.getCurrentPlaceSizeX() * tileSize - tileSize * 1.5 && xPosition > tileSize * 2) {
//            System.out.println("bottom");
            yPosition = (int) (prevTileSize);
            xPosition = (int) (xPosition * (GameScreen.getInitialZoom() / GameScreen.getZoom()));
        }
        // On the right
        else if (xPosition > GameLogic.getCurrentPlaceSizeX() * tileSize - tileSize * 2 && yPosition < GameLogic.getCurrentPlaceSizeY() * tileSize - tileSize * 2 && yPosition > tileSize * 2) {
//            System.out.println("right");
            xPosition = (int) (prevTileSize);
            yPosition = (int) (yPosition * (GameScreen.getInitialZoom() / GameScreen.getZoom()));
        }
        // On the left
        else {
//            System.out.println("left");
            xPosition = (int) (GameScreen.getLevelXTiles() * prevTileSize - prevTileSize);
            yPosition = (int) (yPosition * (GameScreen.getInitialZoom() / GameScreen.getZoom()));
        }
    }


    /**
     * Checks the current status of the player instance.
     */
    public void checkStatus() {
        this.saveGame();
        this.move(9, 9);
        this.draw();
        this.shieldUp();
        this.boundaryCollision();
        this.goToMainMenu();

        if(playerRespawned) {
            resMenu.drawGrave();
        }

    }

    /**
     * Decreases health instance variable.
     *
     * @param health Amount of player the instance of player is about to lose.
     */
    public void decreaseHealth(float health) {

        if(isPlayerAlive) {
            SoundManager.INSTANCE.playSound("ouch");
        }

        if (shieldUp) {
            // Decrease health less
            this.health -= health*0.33*1.2*(defence/75);
        } else {
            // Decrease health normally,
            this.health -= health*0.33*1;
        }
    }

    /**
     * Increases health instance variable.
     *
     * @param health Amount of player the instance of player is about to gain.
     */
    public void increaseHealth(float health) {
        this.health += health;
    }

    /**
     * Accessor method, returns whether the player is alive
     * @return alive status
     */

    public boolean isAlive() { return isPlayerAlive; }


    /**
     * Accessor method, returns woodcutting instance variable.
     *
     * @return woodcutting instance variable
     */
    public int getWoodcutting() {
        return woodcutting;
    }

    /**
     * Accessor method, returns mining instance variable.
     *
     * @return mining instance variable
     */
    public int getMining() {
        return mining;
    }


    /**
     * Accessor method, returns attack instance variable.
     *
     * @return attack instance variable
     */
    public int getAttack() {
        return attack;
    }


    /**
     * Accessor method, returns defence instance variable.
     *
     * @return defence instance variable
     */
    public int getDefence() {
        return defence;
    }


    /**
     * Accessor method, returns archery instance variable.
     *
     * @return archery instance variable
     */
    public int getArchery() {
        return archery;
    }

    public float getHealth() { return this.health; }


    /**
     * Accessor method, returns prot instance variable.
     *
     * @return prot instance variable
     */
    public int getProt() {
        return prot;
    }


    /**
     * Setter method, sets the value of the woodcutting instance variable.s
     *
     * @param a New value of the woodcutting instance variable
     */
    public void setWoodcutting(int a) {
        woodcutting = a;
    }


    /**
     * Setter method, sets the value of the mining instance variable.s
     *
     * @param a New value of the mining instance variable
     */
    public void setMining(int a) {
        mining = a;
    }


    /**
     * Setter method, sets the value of the attack instance variable.s
     *
     * @param a New value of the attack instance variable
     */
    public void setAttack(int a) {
        attack = a;
    }


    /**
     * Setter method, sets the value of the defence instance variable.s
     *
     * @param a New value of the defence instance variable
     */
    public void setDefence(int a) {
        defence = a;
    }


    /**
     * Setter method, sets the value of the archery instance variable.s
     *
     * @param a New value of the archery instance variable
     */
    public void setArchery(int a) {
        archery = a;
    }


    /**
     * Setter method, sets the value of the prot instance variable.s
     *
     * @param a New value of the prot instance variable
     */
    public void setProt(int a) {
        prot = a;
    }

    /**
     * Setter method, sets whether or not the player is alive.
     * @param b new value of the isPlayerAlive variable
     */
    public void setPlayerAlive(boolean b) {
        this.isPlayerAlive = b;
    }


    /**
     * Increases attack instance variable.
     *
     * @param att Amount attack variable will be increased.
     */
    public void increaseAttackSkill(int att) {
        attack += att;
    }


    /**
     * Increases mining instance variable.
     *
     * @param min Amount mining variable will be increased.
     */
    public void increaseMiningSkill(int min) {
        mining += min;
    }


    /**
     * Increases woodcutting instance variable.
     *
     * @param wc Amount woodcutting variable will be increased.
     */
    public void increaseWoodCuttingSkill(int wc) {
        woodcutting += wc;
    }


    /**
     * Increases defence instance variable.
     *
     * @param df Amount defence variable will be increased.
     */
    public void increaseDefenceSkill(int df) {
        defence += df;
    }


    /**
     * Increases archery instance variable.
     *
     * @param ar Amount archery variable will be increased.
     */
    public void increaseArchery(int ar) {
        archery += ar;
    }


    /**
     * Alters the xPosition instance variable.
     *
     * @param dx Amount xPosition variable will be altered by.
     */
    public void alterXPosition(double dx) {
        xPosition += dx;
    }

    public ArrayList<Arrow> getArrows() {
        return arrows;
    }


    /**
     * Alters the yPosition instance variable.
     *
     * @param dy Amount yPosition variable will be altered by.
     */
    public void alterYPosition(double dy) {
        yPosition += dy;
    }

    /**
     * Allows the User to attack via Sword or bow, depending on the current Enum value used.
     */
    public void attack(float damage, Character enemy) {
     
        boolean playerAndEnemyClose = hitBoxDetected(enemy.getBody());

        boolean heavyAttack = Keyboard.isKeyPressed(Keyboard.Key.RSHIFT);


        if (Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {

            if (itemEquip == ItemEquip.BOW) {
                bow.draw();
                if (heavyAttack)
                {
                    heavyBowAttack();
                }
                else
                    fire();
            } else if (playerAndEnemyClose) {
                if (itemEquip == itemEquip.SWORD) {
                    if(damage == 0)
                    {
                        damage = (float) 0.5;

                    }
                    SoundManager.INSTANCE.playSound("sword");

                    if (heavyAttack)
                    {
                        float statDamageBonusSword = 1+stats.getAttack().getSkill()/10;
                        enemy.attack(damage*statDamageBonusSword, enemy);
                    }
                        //enemy.decreaseHealth(this.damage * attack * 2);

                    else
                    {
                        float statDamageBonusSword = 1+stats.getAttack().getSkill()/10;
                        //enemy.decreaseHealth(this.damage * attack);
                        enemy.attack(damage*statDamageBonusSword, enemy);

                    }

                }

            }
            if (itemEquip != ItemEquip.BOW)
                arrows.clear();
        }
        if (playerAndEnemyClose) {
            if(enemy.getAlive())
                
                enemy.attack(1, this);
                this.getStats().getDefence().incXP(1);
        }


    }

    /**
     * Checks if Player has been hit by arrows.
     */
    public void checkArrows(ArrayList<Arrow> arrows) {
        int i = -1;
        int x = 0;
        for (Arrow arrow : arrows) {

            if (arrow.enemyCollide(this)) {
                this.decreaseHealth(arrow.getDamage());
                i = x;
                break;
            }
            x++;


        }
        if(i != -1)
            arrows.remove(i);
    }


    /**
     * Carries out a heavy bow attack, spiral effect of bullets.
     */
    private void heavyBowAttack() {
        double centreOfRotationAngle = 45;
        for (int i = 0; i < 8; i++) {
            double centrerads = Math.toRadians(0);

            double rads = Math.toRadians(centreOfRotationAngle);

            fireHeavy(Math.sin(rads), Math.cos(rads));
            centreOfRotationAngle += 45;

        }


    }


    /**
     * Creates an instance of the arrow class.
     */
    public void fireHeavy(double dx, double dy) {
        float statDamageBonusBow = 1+stats.getArchery().getSkill()/10;
        if(damage == 0)
            damage = 1;
        Arrow firedArrow = new Arrow(spawnWindow, damage*statDamageBonusBow, (float) dx, (float) dy, this);
        if (arrows.size() >= 20) {
            arrows.remove(0);
        }
        arrows.add(firedArrow);
    }

    public void updateItemEquip() {
        if (armour.getInv().get(0) instanceof logic.items.BowItem) {
            equipBow();

            damage = ((BowItem)armour.getInv().get(0)).getDamage();
        } else {
            equipSword();
            damage = ((Sword)armour.getInv().get(0)).getDamage();
        }
        int totalDefence = 0;

        for(int i = 1; i<5; i++) {
            if(armour.getInv().get(i) instanceof Armour) {
                totalDefence += ((Armour) armour.getInv().get(i)).getDefence();
            }
        }


        defence = totalDefence;



    }


    /**
     * Creates an instance of the arrow class.
     */
    public void fire() {
        float statDamageBonusBow = 1+stats.getArchery().getSkill()/10;
        Arrow firedArrow = new Arrow(spawnWindow, this, bow, damage*statDamageBonusBow);
        if (arrows.size() >= 10) {
            arrows.remove(0);
        }
        arrows.add(firedArrow);
    }


    /**
     * Checks if player is close enough to enemy for a sword attack
     *
     * @param rect The enemy space
     * @return True if player is in hitbox.
     */
    public boolean hitBoxDetected(RectangleShape rect) {
        boolean left = rect.getPosition().x + rect.getSize().x > hitBox.getPosition().x - hitBox.getRadius();
        boolean right = rect.getPosition().x < hitBox.getPosition().x + hitBox.getRadius();
        boolean top = rect.getPosition().y < hitBox.getPosition().y + hitBox.getRadius();
        boolean bottom = rect.getPosition().y + rect.getSize().y > hitBox.getPosition().y - hitBox.getRadius();
        return left && right && bottom && top;

    }


    /**
     * Equips a sword, changes method of attack
     */
    public void equipSword() {
        itemEquip = ItemEquip.SWORD;
    }


    /**
     * Equips a bow, changes method of attack.
     */
    public void equipBow() {
        itemEquip = ItemEquip.BOW;
    }

    public boolean isSword(){
        if(itemEquip == ItemEquip.SWORD){
            return true;
        }
        return false;
    }


}
