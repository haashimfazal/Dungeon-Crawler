package gui.animation;

import java.util.LinkedList;
import org.jsfml.window.*;
import org.jsfml.window.event.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Animation {
  // Window win;
  // int protection;
  RenderWindow window;
  Texture[] textures;
  RectangleShape recs[];
  RectangleShape rec;
  int count = 0;
  int timer = 100;

  Clock clock = new Clock();

  Float x;
  Float y;
  Color c;
  // public gui.animation.Animation(RenderWindow win,Texture[] t,Float x,Float y) {
  // this.x=x;
  // this.y=y;
  // window=win;
  //
  // RectangleShape rectangles[]=new RectangleShape[t.length];
  // rec=new RectangleShape(new Vector2f(x,y));
  // recs=rectangles;
  // setTex();
  // // this.protection=protection;
  // }

  public int getCount(){
    return count;
  }
  /**
   * Constructor for animation
   * @param win RenderWindow instance that Animation will be rendered in.
   */
  public Animation(RenderWindow win) {

    window = win;
    c = Color.WHITE;
  }

  /**
   * Draws the animatio on specified window
   * @param r The RectangleShape instance which dictates the location of the Texture
   * @param t The textures which are used to for the animation.
   * @param c The colour of the texture.
   */
  public void draw(RectangleShape r, Texture[] t, Color c,int len) {
    int size = len;
    textures = t;
    r.setFillColor(c);
    if (clock.getElapsedTime().asMilliseconds() < (count + 1) * timer
        && clock.getElapsedTime().asMilliseconds() > (count) * timer) { // get timings right
      //System.out.println("test");
      if(count>=t.length){
        count=0;
      }
      r.setTexture(t[count]);
      //window.draw(r);
    } else {
      count++;
      if (count == size) {
        count = 0;
        clock.restart();
      }
    }
  }

  /**
   * Alternate drawing method for Animation instance.
   * @param r The RectangleShape instance which dictates the location of the Texture
   * @param t The textures which are used to for the animation.
   */
  public void draw(RectangleShape r) {
    int size = textures.length;

    r.setFillColor(c);
    if (clock.getElapsedTime().asMilliseconds() < (count + 1) * timer
        && clock.getElapsedTime().asMilliseconds() > (count) * timer) { // get timings right
      //System.out.println("test");
      r.setTexture(textures[count]);
      //window.draw(r);
    } else {
      count++;
      if (count == size) {
        count = 0;
        clock.restart();
      }
    }
  }


  /**
   * Alternate drawing method for Animation instance.
   * @param r The RectangleShape instance which dictates the location of the Texture
   */
  public void draw(RectangleShape r, Texture[] t,int len) {
    int size = len;
    textures = t;
    r.setFillColor(c);
    if (clock.getElapsedTime().asMilliseconds() < (count + 1) * timer
        && clock.getElapsedTime().asMilliseconds() > (count) * timer) { // get timings right
      //System.out.println("test");
      r.setTexture(t[count]);
      //window.draw(r);
    } else {
      count++;
      if (count == size) {
        count = 0;
        clock.restart();
      }
    }
  }


  /**
   * Modifier method, used to alter the texture used.
   * @param t The new array of textures used.
   */
  public void setTexture(Texture[] t) {
    textures = t;
  }


  /**
   * Modifier method. Sets the colour of the animation
   * @param c Sets the colour of the texture.
   */
  public void setColor(Color c) {
    this.c = c;
  }

}
