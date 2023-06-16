package logic.entities;

import gui.GameScreen;
import logic.items.Inv;
import logic.level.Challenge;

import org.jsfml.graphics.*;

import gui.GUI;

import org.jsfml.system.Clock;
import java.util.concurrent.ThreadLocalRandom;

import java.io.IOException;

public class EnemyCluster {

  Enemy enemy;
  int number;
  float x;
  float y;
  int randomNum2;
  int randomNum;
  RenderWindow window;
  Enemy enemyArray[];
  int hitFrequency;
  private Clock clock = new Clock();
  private int count = 0;
  boolean canfire = false;
  String bootImage;

  /**
   * 
   * @param enemy  Instance of Enemy class
   * @param number Number of that Enemy to be created.
   * @param x      xPosition of Enemy
   * @param y      yPosition of Enemy
   */
  public EnemyCluster(RenderWindow window, Enemy enemy, int number, float x, float y, Player player, GUI gui, int hitFrequency, boolean canfire)
      throws IOException {
    this.enemy = enemy;
    this.number = number;
    this.x = (float) (x * GameScreen.getInitialZoom());
    this.y = (float) (y * GameScreen.getInitialZoom());
    this.canfire = canfire;
    this.window = window;
    Enemy enemyArrayTemp[] = new Enemy[number];
    enemyArray = enemyArrayTemp;
    int min = -10;
    int max = 10;
    randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    randomNum2 = ThreadLocalRandom.current().nextInt(min, max + 1);
    this.hitFrequency = hitFrequency;
    init(player, gui);


  }

  /**
   * draws a circle of players around classes coordinates.
   */
  public void draw(Player player, Inv inv,Challenge challenge)throws IOException {

    for (int i = 0; i < number; i++) {
      enemyArray[i].draw();
      enemyArray[i].tileCollision();
       enemyArray[i].move(randomNum, randomNum2, player, inv,enemyArray[i],this,challenge,inv);
      enemyArray[i].draw2(player,challenge,inv);
      //enemyArray[i].drawPt2();
      //enemyArray[i].move(player,enemyArray[i],this);


     
    }

    if(clock.getElapsedTime().asMilliseconds() > 100)
      count = 0;
    if(count != 0)
      return;
    for (int i = 0; i < number; i++) {

      PlayerEntity.getPlayer().attack(0,enemyArray[i]);
      PlayerEntity.getPlayer().checkArrows(enemyArray[i].getArrows());
      enemyArray[i].checkArrows(PlayerEntity.getPlayer().getArrows());
      if(enemyArray[i].getAlive())
      {
        enemyArray[i].fireArrow(PlayerEntity.getPlayer());
      }


    }
    clock.restart();
    count++;

  }

  /**
   * sets the initial coordinates of the player
   */
  public void setCoordinates() {
    double radius = enemy.getWidth()/4 + (enemy.getHeight() * 2)/4;
    double angleCalc = 360 / number;
    for (int i = 0; i < number; i++) {
      double angle = angleCalc * i;
      double xVec = radius * Math.sin(Math.toRadians(angle));
      double yVec = radius * Math.cos(Math.toRadians(angle));
      enemyArray[i].setXVec((int) xVec);
      enemyArray[i].setYVec((int) yVec);
      
      enemyArray[i].setXPosition((int) x + (int) xVec);
      enemyArray[i].setYPosition((int) y + (int) yVec);
      enemyArray[i].setSpawn(enemyArray[i].getXPosition(), enemyArray[i].getYPosition());
    }
  }

  /**
   * initialises the copies of the enemy
   */
  public void init(Player player, GUI gui) throws IOException {

    for (int i = 0; i < number; i++) {
      enemyArray[i] = new Enemy(window,enemy.getXPosition(), enemy.getYPosition(), enemy.getWidth(), enemy.getHeight(),
          5, enemy.getBootImage(), gui, enemy.getRespawnTime(),enemy.getItem1(), hitFrequency,canfire,enemy.getDamage(),enemy.getChalID());


    }
    setCoordinates();
  }

}