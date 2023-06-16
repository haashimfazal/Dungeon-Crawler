package logic.items;

import logic.items.Armour;
import org.jsfml.graphics.*;

public class Chest extends Armour {

  /**
   * Constructor to create a Chest
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Chest
   * @param id Unique ID of the Chest
   * @param damage Damage stat of Chest
   * @param prot Protection stat of Chest
   * @param archery Archery stat of Chest.
   * @param defence Defence stat of Chest
   */
  public Chest(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);
  }

}
