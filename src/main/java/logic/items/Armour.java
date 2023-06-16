package logic.items;

import org.jsfml.graphics.*;

public class Armour extends Wearables {

  // Window win;
  // int protection;

  /**
   * Constructor to create a Armour
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Armour
   * @param id Unique ID of the Armour
   * @param damage Damage stat of Armour
   * @param prot Protection stat of Armour
   * @param archery Archery stat of Armour.
   * @param defence Defence stat of Armour
   */
  public Armour(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);
    // this.protection=protection;
  }

  public int getProt() {
    return prot;
  }
}
