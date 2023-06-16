 package logic.entities;

 import gui.GUI;
 import gui.GameScreen;
 import logic.GameLogic;
 import org.jsfml.graphics.RenderWindow;

 import java.io.IOException;
 import java.util.Random;

 public class Boss extends Enemy{

     public Boss(RenderWindow spawnWindow, int xPosition, int yPosition, float width, float height, float health, String BootImage, GUI gui, int respawnTime, int one, int two, int three, int hitFrequency, boolean canfire, float damage,int ChalID) throws IOException {
         super(spawnWindow, (int)(xPosition * GameScreen.getInitialZoom()), (int)(yPosition * GameScreen.getInitialZoom()), (float)(width* GameScreen.getInitialZoom()), (float)(height* GameScreen.getInitialZoom()), health, BootImage, gui, respawnTime, one, hitFrequency, canfire, damage,ChalID);
     }

     public boolean checkStatus()
     {

         this.draw();
         if(alive)
         {
             PlayerEntity.getPlayer().attack(PlayerEntity.getPlayer().getAttack(),this);

             this.superAttack(PlayerEntity.getPlayer());
             checkArrows(PlayerEntity.getPlayer().getArrows());
             PlayerEntity.getPlayer().checkArrows(this.getArrows());
         }


          return true;
     }


     public void superAttack(Character player)
     {
        Random rand = new Random();
        if (rand.nextInt(hitFrequency*40) != 1) {
            return;

        }
         double centreOfRotationAngle = 45;
         for (int i = 0; i < 8; i++) {
             double centrerads = Math.toRadians(0);

             double rads = Math.toRadians(centreOfRotationAngle);

             fireHeavy(Math.sin(rads), Math.cos(rads));
            centreOfRotationAngle += 45;

       }
    }

    /**
      * Creates an instance of the arrow class.
    */
     public void fireHeavy(double dx, double dy) {
         Arrow firedArrow = new Arrow(spawnWindow, 1, (float) dx, (float) dy, this);
         if (arrows.size() >= 20) {
             arrows.remove(0);
         }
         arrows.add(firedArrow);
     }

     public void attack(float damage, Character enemy) {
         Random rand = new Random();
         if (hitFrequency == 0) {
             hitFrequency = 5;
         }
         if (rand.nextInt(hitFrequency) == 1) {
             enemy.decreaseHealth(this.getDamage() );

         }


     }

 }
