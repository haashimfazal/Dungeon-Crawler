package logic.level;

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.Keyboard;
//import org.w3c.dom.Text;

import java.io.IOException;
import java.nio.file.Paths;

import gui.GUI;
import gui.menu.Bar;
import gui.menu.Inventory;
import logic.items.Axe;
import logic.items.BowItem;
import logic.items.Inv;
import logic.items.Pickaxe;
import logic.items.Sword;
import logic.items.Weapons;

public class Challenge {

    RectangleShape rec = new RectangleShape(new Vector2f(400, 60));
    RectangleShape rec2 = new RectangleShape(new Vector2f(400, 10));
    RectangleShape rec3 = new RectangleShape(new Vector2f(400, 10));
    RenderWindow window;
    int selected;
    Clock timer = new Clock();
    Clock newChallenge = new Clock();
    int count;
    int maxCount;
    int id = 0;
    int isChallenge = 0;
    Text text = new Text();
    Font font = new Font();

    /**
     * Constructor to create Challenge
     *
     * @param window RenderWindow of the instance of challenge will be rendered in
     * @throws IOException
     */
    public Challenge(RenderWindow window) throws IOException {
        this.window = window;
        Texture uiPanel=new Texture();
        uiPanel.loadFromFile(Paths.get("Images/G1 - GUI/generic-rpg-pack_v0.4_(alpha-release)_vacaroxa/rpg-pack/UI/generic-rpg-ui-inventario02.png"));
        rec.setPosition(window.getSize().x-400,window.getSize().y-60);
        rec2.setPosition(window.getSize().x-400,window.getSize().y-60);
        rec3.setPosition(window.getSize().x-400,window.getSize().y-60);
        
        rec.setTexture(uiPanel);
        font.loadFromFile(Paths.get("Fonts/bilboregular.ttf"));
        text = new Text(" ", font, 40);
        text.setPosition(window.getSize().x-350,window.getSize().y-60);
        text.setColor(Color.WHITE);
        rec2.setFillColor(Color.BLACK);
        rec3.setFillColor(Color.RED);
        //text=new Text(" ", font, 40);
        //newChallenge.restart();
    }


    /**
     * Draws instance onto current RenderWindow
     *
     * @param bar Which the Challenge will be drawn on
     * @param inv Which the inventory will be drawn on.
     */
    public void draw(Bar bar, Inv inv)throws IOException {


        selected = bar.selected;
        if (newChallenge.getElapsedTime().asSeconds() > 3) { //5 minutes
            if (isChallenge == 0) {
                startChallenge(inv);
            } else {
                newChallenge.restart();
            }
        }
        if (isChallenge == 1) {
            getDimensions();
            checkChallenge(inv);
            window.draw(rec);
            window.draw(rec2);
            window.draw(rec3);
            window.draw(text);

        }
    }

    /**
     * Sets the dimensions of Challenge instance
     */
    public void getDimensions() {
        float percentage = (float) count / (float) maxCount * 100;
        float size = 400 / 100 * percentage; //converts the progress to a percentage and represents the progress as a bar
        // System.out.println(size);
        rec3.setSize(new Vector2f(size, 10));
    }


    /**
     * Starts specified challenge.
     */
    public void startChallenge(Inv inv) {
        maxCount = 10;
        count = 0;
        timer.restart();
        if(inv.getInv().isEmpty()){
            
            return;
        }
        if (inv.getInv().get(selected) instanceof Sword) { //set id to known thing and challenge text
            int min=0;
            int max=9;
            
            id = (int)(Math.random() * (max - min + 1) + min); 
            if(id==0){
                text.setString("get some kills in level 1");
            }
            if(id==1){
                text.setString("get some kills in level 2");
            }
            if(id==2){
                text.setString("get some kills in level 3");
            }
            if(id==3){
                text.setString("get some kills in level 4");
            }
            if(id==4){
                text.setString("get some kills in level 5");
            }
            if(id==5){
                text.setString("get some kills in level 6");
            }
            if(id==6){
                text.setString("get some kills in level 7");
            }
            if(id==7){
                text.setString("get some kills in level 8");
            }
            if(id==8){
                text.setString("get some kills in level 9");
            }
            if(id==9){
                text.setString("get some kills in level 10");
            }

            isChallenge = 1;
            return;
        }
        if (inv.getInv().get(selected) instanceof BowItem) { //set id to known thing and challenge text
            int min=10;
            int max=19;
            
            id = (int)(Math.random() * (max - min + 1) + min); 
            if(id==10){
                text.setString("get some kills in level 1");
            }
            if(id==11){
                text.setString("get some kills in level 2");
            }
            if(id==12){
                text.setString("get some kills in level 3");
            }
            if(id==13){
                text.setString("get some kills in level 4");
            }
            if(id==14){
                text.setString("get some kills in level 5");
            }
            if(id==15){
                text.setString("get some kills in level 6");
            }
            if(id==16){
                text.setString("get some kills in level 7");
            }
            if(id==17){
                text.setString("get some kills in level 8");
            }
            if(id==18){
                text.setString("get some kills in level 9");
            }
            if(id==19){
                text.setString("get some kills in level 10");
            }
            isChallenge = 1;
            return;
        }
        if (inv.getInv().get(selected) instanceof Axe) { //set id to known thing and challenge text
            int min=20;
            int max=29;
            
            id = (int)(Math.random() * (max - min + 1) + min); 
            if(id==20){
                text.setString("chop some trees in level 1");
            }
            if(id==21){
                text.setString("chop some trees in level 2");
            }
            if(id==22){
                text.setString("chop some trees in level 3");
            }
            if(id==23){
                text.setString("chop some trees in level 4");
            }
            if(id==24){
                text.setString("chop some trees in level 5");
            }
            if(id==25){
                text.setString("chop some trees in level 6");
            }
            if(id==26){
                text.setString("chop some trees in level 7");
            }
            if(id==27){
                text.setString("chop some trees in level 8");
            }
            if(id==28){
                text.setString("chop some trees in level 9");
            }
            if(id==29){
                text.setString("chop some trees in level 10");
            }
            isChallenge = 1;
            return;
        }
        if (inv.getInv().get(selected) instanceof Pickaxe) { //set id to known thing and challenge text
            int min=30;
            int max=39;
            
            id = (int)(Math.random() * (max - min + 1) + min); 
            if(id==30){
                text.setString("get some ore in level 1");
            }
            if(id==31){
                text.setString("get some ore in level 2");
            }
            if(id==32){
                text.setString("get some ore in level 3");
            }
            if(id==33){
                text.setString("get some ore in level 4");
            }
            if(id==34){
                text.setString("get some ore in level 5");
            }
            if(id==35){
                text.setString("get some ore in level 6");
            }
            if(id==36){
                text.setString("get some ore in level 7");
            }
            if(id==37){
                text.setString("get some ore in level 8");
            }
            if(id==38){
                text.setString("get some ore in level 9");
            }
            if(id==39){
                text.setString("get some ore in level 10");
            }
            isChallenge = 1;
            return;
        }
        text.setString("");
    }

    /**
     * When action is completed in game this is called.
     *
     * @param challengeID Of certain action i.e Killing a monster
     */
    public void incCount(int challengeID) {  //everything calls this when action completed (i.e monster defeated/ore collected)
       
        if (challengeID == id) {
            count++;
        }
    }

    /**
     * Checks if the Challenge is still running.
     */
    public void checkChallenge(Inv inv)throws IOException {
        if (count >= maxCount) {
            int min=0;
            int max=100;
            int random = (int)(Math.random() * (max - min + 1) + min); 
            int base;
            int sub=id%10;
            sub=sub+1;
            if(id-(id%10)==0){ //kill
                if(random>28){
                    giveAward(random,sub,inv,120);
                }else{
                    giveAward(random,sub,inv,10);
                }
            }
            if(id-(id%10)==10){//kill
                if(random>28){
                    giveAward(random,sub,inv,120);
                }else{
                    giveAward(random,sub,inv,30);
                }
            }
            if(id-(id%10)==20){//axe
                giveAward(random,sub,inv,40);
            }
            if(id-(id%10)==30){// pick
                giveAward(random,sub,inv,20);
            }





            
            isChallenge = 0;
            newChallenge.restart();
            return;

        }
        
        
    if (timer.getElapsedTime().asSeconds() < 30) {//30 seconds
            
        } else {
            // System.out.println("challenge failed");
//            System.out.println("challenge failed");
            newChallenge.restart();
            isChallenge = 0;
        }
    }

    public void giveAward(int random,int sub,Inv inv,int toolID)throws IOException{
        int awardID;
        if(random>0&&random<=20){
            //give food
            awardID=70+sub;
            inv.addByID(awardID);
        }
        if(random>20&&random<=52){
            awardID=toolID+sub;
            inv.addByID(awardID);
        }
        if(random>52&&random<=64){
            //give helmet
            awardID=80+sub;
            inv.addByID(awardID);
        }
        if(random>64&&random<=78){
            //give chest
            awardID=90+sub;
            inv.addByID(awardID);
        }
        if(random>78&&random<=90){
            //give legs
            awardID=100+sub+1;
            inv.addByID(awardID);
        }
        if(random>90&&random<=100){
            //give boots
            awardID=110+sub;
            inv.addByID(awardID);
        }
    }


}
