package logic.items;

import org.jsfml.graphics.*;

public class Weapons extends Wearables {

  /**
   * Constructor to create a wearable
   * @param win Instance of RenderWindow class will be rendered in
   * @param t Texture of Weapons
   * @param id Unique ID of the Weapons
   * @param damage Damage stat of Weapons
   * @param prot Protection stat of Weapons
   * @param archery Archery stat of Weapons.
   * @param defence Defence stat of Weapons
   */
  public Weapons(RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence) {
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
