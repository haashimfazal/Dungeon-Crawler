package logic.items;

import org.jsfml.graphics.*;

public class Tools extends Wearables {

  /**
   * Constructor to create a wearable
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Tools
   * @param id Unique ID of the Tools
   * @param damage Damage stat of Tools
   * @param prot Protection stat of Tools
   * @param archery Archery stat of Tools.
   * @param defence Defence stat of Tools
   */
  public Tools(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
    super(win, t, id, damage, prot, archery, defence);

  }

  /**
   * Accessor method
   * @return Damage instance variable.
   */
  public int getDamage() {
    return damage;
  }

}
