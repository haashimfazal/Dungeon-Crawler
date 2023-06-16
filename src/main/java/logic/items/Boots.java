package logic.items;

import logic.items.Armour;
import org.jsfml.graphics.*;

public class Boots extends Armour {

  /**
   * Constructor to create a Boots
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Boots
   * @param id Unique ID of the Boots
   * @param damage Damage stat of Boots
   * @param prot Protection stat of Boots
   * @param archery Archery stat of Boots.
   * @param defence Defence stat of Boots
   */
  public Boots(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);
  }

}
