package logic.items;

import logic.items.Armour;
import org.jsfml.graphics.*;

public class Helmet extends Armour {

  /**
   * Constructor to create a Helmet
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Helmet
   * @param id Unique ID of the Helmet
   * @param damage Damage stat of Helmet
   * @param prot Protection stat of Helmet
   * @param archery Archery stat of Helmet.
   * @param defence Defence stat of Helmet
   */
  public Helmet(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);
  }

}
