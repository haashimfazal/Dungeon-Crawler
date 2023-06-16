package logic.items;

import logic.items.Weapons;
import org.jsfml.graphics.*;

public class Axe extends Tools {

  /**
   * Constructor to create a wearable
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Axe
   * @param id Unique ID of the Axe
   * @param damage Damage stat of Axe
   * @param prot Protection stat of Axe
   * @param archery Archery stat of Axe.
   * @param defence Defence stat of Axe
   */
  public Axe(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);

  }

}
