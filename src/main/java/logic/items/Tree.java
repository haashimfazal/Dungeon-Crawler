package logic.items;

import gui.GameScreen;
import org.jsfml.graphics.*;

import logic.entities.Player;
import resources.SoundManager;

import java.io.IOException;
import java.nio.file.Paths;

public class Tree extends SkillNode{

  /**
   * Constructor for creation of an instance of logic.items.SkillNode variable.
   * @param win RenderWindow the logic.items.Tree instance will be rendered in.
   * @param x X position of logic.items.Tree
   * @param y Y postion of logic.items.Tree
   * @param respawnTime Amount of time it will be until logic.items.SkillNode respawns
   * @param strength Strength of logic.items.Tree
   * @throws IOException
   */
 // gui.animation.AnimationGroup playerAnimation=new gui.animation.AnimationGroup(window, 2, "Images/player/1/Fighting/"); //need to change
  public Tree(RenderWindow win,float x, float y,int respawnTime,int strength,int id,String s,int itemid,int minID) throws IOException {
    super(win,(float)(x * GameScreen.getInitialZoom()),(float)(y * GameScreen.getInitialZoom()),respawnTime,strength,id,s,itemid,minID);
    //t=tex;
    
    
   // heart.loadFromFile(Paths.get("Images/G6 - eating/Heart.png"));
    
    itemImg.loadFromFile(Paths.get("Images/G8 - woodcutting/wood.png"));

    item=new Items(window, itemImg, 6);
    rec.setTexture(nodeImg);
    //this.id=id;
  }
  public boolean checkTool(Inv inv){
    if(inv.getInv().get(selected) instanceof Axe && inv.getInv().get(selected).getID()>=minID ){
      return true;
    }else{
      return false;
    }
  }


  public void playSound(){
    SoundManager.INSTANCE.playSound("axe");
  }
  // IA: TODO: add to the logic.entity.Player.java ?
  public void giveXP(Player player){
    player.getStats().getWoodCutting().incXP(xp);

    //}
  }


}