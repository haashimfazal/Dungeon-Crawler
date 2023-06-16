package logic.items;

import java.util.LinkedList;
import org.jsfml.window.*;
import org.jsfml.window.event.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Wearables extends Items {

  // Window win;
  int damage;
  int prot;
  int archery;
  int defence;

  /**
   * Constructor to create a wearable
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Wearables
   * @param id Unique ID of the Wearables
   * @param damage Damage stat of Wearables
   * @param prot Protection stat of Wearables
   * @param archery Archery stat of Wearables.
   * @param defence Defence stat of Wearables
   */
  public Wearables(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id);
    this.damage = damage;
    this.prot = prot;
    this.archery = archery;
    this.defence = defence;

  }


  /**
   * Accessor method
   * @return Damage instance variable.
   */
  public int getDamage() {
    return damage;
  }


  /**
   * Accessor method
   * @return prot instance variable.
   */
  public int getProt() {
    return prot;
  }


  /**
   * Accessor method
   * @return archery instance variable.
   */
  public int getArchery() {
    return archery;
  }


  /**
   * Accessor method
   * @return defence instance variable.
   */
  public int getDefence() {
    return defence;
  }

}
