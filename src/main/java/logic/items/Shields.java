package logic.items;

import logic.items.Armour;
import org.jsfml.graphics.*;

public class Shields extends Armour {

  // Window win;

  /**
   * Constructor to create a Shields
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Shields
   * @param id Unique ID of the Shields
   * @param damage Damage stat of Shields
   * @param prot Protection stat of Shields
   * @param archery Archery stat of Shields.
   * @param defence Defence stat of Shields
   */
  public Shields(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);

  }

}
