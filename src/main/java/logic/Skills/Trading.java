package logic.Skills;

import logic.items.Axe;
import logic.items.Inv;
import logic.items.Items;
import org.jsfml.graphics.*;
import java.util.ArrayList;
import org.jsfml.system.*;
import gui.GUI;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import java.io.IOException;
import java.nio.file.Paths;

public class Trading {
    int cost;
    Items buyItem;
    Items sellItem;
    int id1;
    int id2;
    int amount;
    Clock clock=new Clock();
    int count=0;

    public Trading(int cost,int id1,int amount,int id2)
    {
        this.cost=cost;
        this.id1=id1;
        this.id2=id2;
        this.amount=amount;
    }

    public void trade(Inv inventory1)throws IOException{ //take player inv and npc inv
        if(clock.getElapsedTime().asMilliseconds()>250){
            count=0;
        }
        if(count==0){

        
        if(inventory1.countItems(id1)>=cost && inventory1.amountFree()>=amount-cost){   //if they can afford && have enough space
            //trade can be done

            //remove payment
            for(int i=0;i<cost;i++){
                inventory1.removeFree(id1);
            }
           //add items
            for(int i=0;i<amount;i++){
                inventory1.addByID(id2);
            }
            
            inventory1.save();
            inventory1.getInv().clear();
            inventory1.load();
            clock.restart();
            count++;
            //clock.restart();
        }
        //System.out.println("called");
    }
    }
    public void trade(Inv inventory1,int cost,int id1,int amount,int id2)throws IOException{ //take player inv and npc inv
        if(clock.getElapsedTime().asMilliseconds()>250){
            count=0;
        }
        if(count==0){
        if(inventory1.countItems(id1)>=cost && inventory1.amountFree()>=amount-cost){   //if they can afford && have enough space
            //trade can be done

            //remove payment
            for(int i=0;i<cost;i++){
                inventory1.removeFree(id1);
            }
             //add items
             for(int i=0;i<amount;i++){
                inventory1.addByID(id2);
            }
            
            inventory1.save();
            inventory1.getInv().clear();
            inventory1.load();
            clock.restart();
            count++;

        }
    }
        //System.out.println("called");
    }

    public int getID1(){
        return id1;
    }
    public int getID2(){
        return id2;
    }

    public int getCost(){
        return cost;
    }
    public int getReturn(){
        return amount;
    }
 
 

}