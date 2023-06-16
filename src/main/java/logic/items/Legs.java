package logic.items;

import logic.items.Armour;
import org.jsfml.graphics.*;

public class Legs extends Armour {

  /**
   * Constructor to create a Legs
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Legs
   * @param id Unique ID of the Legs
   * @param damage Damage stat of Legs
   * @param prot Protection stat of Legs
   * @param archery Archery stat of Legs.
   * @param defence Defence stat of Legs
   */
  public Legs(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);
  }

}
