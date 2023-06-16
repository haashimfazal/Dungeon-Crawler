package logic.entities;

import gui.GameScreen;
import logic.Skills.Trading;
import logic.items.Inv;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import gui.GUI;
import gui.menu.NpcTrade;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * NOTE: Quests should be referred to as challenges. Didn't want to change them to prevent conflicts.
 */
public class NPC extends Character { // IA: removed drawable interface
    private Texture preQuestText = new Texture();
    private Texture postQuestText = new Texture();
    private RectangleShape shapeForText;
    private boolean playerTalking = false;
    private boolean playerTrading = false;
    private Trading trade[];
    private NpcTrade menu;
    ArrayList<Integer> ids = new ArrayList<Integer>();
    
    /**
     * @param spawnWindow   Render window the Enemy class will be spawned in.
     * @param xPosition     X coordinate spawn position
     * @param bootImage     Boot image of NPC, will be the look of the NPC
     * @param yPosition     Y coordinate spawn position
     * @param preQuestText  Text of NPC prior to challenge completion.
     * @param postQuestText Text of NPC after challenge completion
     */
    public NPC(RenderWindow spawnWindow, String bootImage, int xPosition, int yPosition, String preQuestText, String postQuestText, Trading trade[]) throws IOException {
        super(spawnWindow, (int)(xPosition * GameScreen.getInitialZoom()), (int)(yPosition * GameScreen.getInitialZoom()), (float)(25*GameScreen.getInitialZoom()), (float)(50*GameScreen.getInitialZoom()), 0, bootImage);
        shapeForText = new RectangleShape(new Vector2f(spawnWindow.getSize().x, spawnWindow.getSize().y / 2));
        xPosition = (int) (xPosition * GameScreen.getInitialZoom());
        yPosition = (int) (yPosition * GameScreen.getInitialZoom());

        try {
            // Will be changed once all text boxes are produced.
            this.preQuestText.loadFromFile(Paths.get("Images/NPC Dialogue/" + preQuestText + ".png"));
            // Will be changed once all text boxes are produced.
            this.postQuestText.loadFromFile(Paths.get("Images/NPC Dialogue/" + postQuestText + "_POST.png"));
            shapeForText.setTexture(this.preQuestText);
        } catch (IOException e) {
            System.out.println("Error in finding file for image.");
        }
        
        int temp[] = new int[trade.length * 2];
        int j = 0;
        for (int i = 0; i < trade.length * 2; i += 2) {

            temp[i] = trade[j].getID1();
            temp[i + 1] = trade[j].getID2();
            j++;
        }
        Inv inv=new Inv(spawnWindow);
        menu = new NpcTrade(spawnWindow, trade.length, temp,inv,trade[0].getCost(),trade[0].getReturn());

        shapeForText.setPosition(0, spawnWindow.getSize().y - spawnWindow.getSize().y / 2);
        body.setPosition(xPosition, yPosition);
        this.trade = trade;
    }


    /**
     * Will only run once, is triggerd when user completes the challenge of the NPC.
     */
    public void questCompleted() {
        shapeForText.setTexture(this.postQuestText);
    }

    @Override
    public void draw() {

    }

    /**
     * Draws the instance onto currentRenderWindow.
     */

    public void draw(Player player, GUI x) throws IOException {
        talk(player);
        trade(player, x);


        spawnWindow.draw(body);
        if (playerTalking) {
            spawnWindow.draw(shapeForText);
        }


    }

    /**
     * Doesn't need implementing as I think the NPC will have a static location.
     *
     * @param dx Change in xPosition
     * @param dy Change in yPosition
     */
    @Override
    void move(double dx, double dy) {

    }

    /**
     * Doesn't need implementing as I think the NPC will be unkillable. Could be up to change however.
     *
     * @param health Change in xPosition
     */
    @Override
    void decreaseHealth(float health) {

    }

    /**
     * Doesn't need implementing as I think the NPC won't ever attack player.
     *
     * @param damage
     * @param enemy
     */
    @Override
    void attack(float damage, Character enemy) {

    }

    /**
     * Checks status of NPC, dictates what will be draw in next iteration.
     */
    void checkStatus() {

    }

    /**
     * Triggers NPCs text, if the player wishes so.
     *
     * @param player Iteration of player.
     */
    public void talk(Character player) {

        if (this.collide(player) == true) {

            if (Keyboard.isKeyPressed(Keyboard.Key.T)) {
                //  System.out.println("t pressed");
                playerTalking = true;

            } else
                playerTalking = false;
        } else {
            playerTalking = false;
        }
    }

    /**
     * Triggers NPCs trade, if the player wishes so.
     *
     * @param player Iteration of player.
     */
    public void trade(Character player, GUI gui) throws IOException {

        if (this.collide(player) == true) {
            
            if (Keyboard.isKeyPressed(Keyboard.Key.E)) {
                //  System.out.println("t pressed");
                playerTrading = true;
            }
            if (Keyboard.isKeyPressed(Keyboard.Key.X)) {
                //  System.out.println("t pressed");
                playerTrading = false;
            }
        } else {
            playerTrading = false;
        }

        if (playerTrading) {
            if (menu.getCheck()) {
                trade[menu.getInID()].trade(gui.getInven());
            }
             menu.draw(gui.getInven());
        }
    }

    public void updateDialogue()
    {
        shapeForText.setTexture(this.postQuestText);
    }


}
