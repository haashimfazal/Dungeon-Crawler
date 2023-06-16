package logic.items;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

import gui.menu.Bar;
import logic.entities.Player;
import resources.SoundManager;

import java.io.IOException;
import org.jsfml.window.Keyboard;
/**
 * Class representing food items.
 */
public class Food extends Items {
    private float health;
    private Items item;
    private Texture itemImg = new Texture();
    private int damage = 0;
    private int prot = 0;
    private int archery = 0;
    private int defence = 0;
    private Clock clock = new Clock();
    private int eaten = 0;
    private int time = 0;
    private int selected;

    // gui.animation.AnimationGroup playerAnimation=new gui.animation.AnimationGroup(window, 2, "Images/player/1/Fighting/"); //need to change

    /**
     * Food constructor.
     *
     * @param health  value
     * @param win     render window
     * @param id      of food
     * @param itemImg texture of food item
     * @throws IOException
     */
    public Food(float health, RenderWindow win, int id, Texture itemImg) throws IOException {
        super(win, itemImg, id);
        this.health = health;
        item = new Items(win, itemImg, id);
    }

    /**
     * Food constructor.
     *
     * @param health  value
     * @param win     render window
     * @param t       texture of a food item
     * @param id      of food item
     * @param damage  value
     * @param prot
     * @param archery
     * @param defence
     * @param time
     * @throws IOException
     */
    public Food(float health, RenderWindow win, int id, Texture t, int damage, int prot, int archery, int defence, int time) throws IOException {
        super(win, t, id);
        this.health = health;
        item = new Items(win, t, id);
        this.damage = damage;
        this.prot = prot;
        this.archery = archery;
        this.defence = defence;
        this.time = time;


    }

public boolean isHeld(Inv inv){
    if(inv.getInv().get(selected)==this){
        return true;
    }else{
        return false;
    }
}
 public void eat(Inv inv, Player player,Bar bar){
    selected = bar.selected;
    //System.out.println(inv.getInv().get(selected));
    
   if (Keyboard.isKeyPressed(Keyboard.Key.SPACE)&&eaten==0 && isHeld(inv)){
        SoundManager.INSTANCE.playSound("eat");
       eaten=1;
   }
   if(eaten==0){
       clock.restart(); //for enchants;

   }
   if(eaten==1){
       player.increaseHealth(health);
       inv.removeFree(getID());
       eaten=2;
   }
   float damageLevel=player.getStats().getAttack().getSkill();
   float protLevel=player.getStats().getProt().getSkill();
   float archeryLevel=player.getStats().getArchery().getSkill();
   float defenceLevel=player.getStats().getDefence().getSkill();

   if(eaten==2){
       
       player.getStats().getAttack().setSkill((int)damageLevel+damage);
       player.getStats().getProt().setSkill((int)damageLevel+prot);
       player.getStats().getArchery().setSkill((int)damageLevel+archery);
       player.getStats().getDefence().setSkill((int)damageLevel+defence);
       eaten=3;
   }

    damageLevel=player.getStats().getAttack().getSkill()-damage;
    protLevel=player.getStats().getProt().getSkill()-prot;
    archeryLevel=player.getStats().getArchery().getSkill()-archery;
    defenceLevel=player.getStats().getDefence().getSkill()-defence;
    if(eaten==3){
        
        if(clock.getElapsedTime().asMilliseconds()>=time){
            player.getStats().getAttack().setSkill((int)damageLevel);
            player.getStats().getProt().setSkill((int)protLevel);
            player.getStats().getArchery().setSkill((int)archeryLevel);
            player.getStats().getDefence().setSkill((int)defenceLevel);
            eaten=4;

          //delete the object
       }
   }
 }


}
