package gui.animation;

import org.jsfml.graphics.*;

import java.io.IOException;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.*;

public class AnimationGroup {
    RenderWindow window;
    String fileName;
    int size;
    Texture[] ani;
    Texture[] aniH;
    Texture[] aniC;
    Texture[] aniL;
    Texture[] aniB;
    
    Animation playerAni = new Animation(window);
    Animation helmetAni = new Animation(window);                              
    Animation chestAni = new Animation(window);
    Animation legAni = new Animation(window);
    Animation bootAni = new Animation(window);
    Color a=Color.WHITE;
    Color h=Color.WHITE;
    Color c=Color.WHITE;
    Color l=Color.WHITE;
    Color b=Color.WHITE;
    int direction=1;

    

    /**
     * Constructor for a group of Animations
     * @param win RenderWindow instance of AnimationGroup will be rendered in
     * @param size Number of textures.
     * @param address Location of Animations in file system.
     * @throws IOException
     */
    public AnimationGroup(RenderWindow win,int size,String address)throws IOException {
        window=win;
        this.size=size;
        this.fileName=address;
        ani = new Texture[size];
        aniH = new Texture[size];
        aniC = new Texture[size];
        aniL = new Texture[size];
        aniB = new Texture[size];
        changeAnimation(address,size);
       

        
    }

    /**
     * Renderers the AnimationGroup onto RenderWindow
     */
    public void draw(RectangleShape rec,RectangleShape rec1,RectangleShape rec2,RectangleShape rec3,RectangleShape rec4)  throws IOException {
            

        playerAni.draw(rec, ani,a,size);
        helmetAni.draw(rec1,aniH,h,size);
        chestAni.draw(rec2,aniC,c,size);
        legAni.draw(rec3,aniL,l,size);
        bootAni.draw(rec4,aniB,b,size);
        window.draw(rec);
        window.draw(rec1);
        window.draw(rec2);
        window.draw(rec3);
        window.draw(rec4);
        }
    
    
        /**
     * Renderers the AnimationGroup onto RenderWindow
     */
    public void draw(RectangleShape rec)throws IOException {
        playerAni.draw(rec, ani,a,size);
        window.draw(rec);
        }




    public int getDirection(){
        return direction;
    }
    public int getSize(){
        return size;
    }
    public Animation getAni(){
        return playerAni;
    }



    /**
     * Updates group of animatons
     * @param fileName Name of file of textures for animation
     * @param size Number of textures.
     */
    public void changeAnimation(String fileName,int size)throws IOException{
        this.fileName=fileName;
        this.size=size;
        FileLoader fl=new FileLoader(window);
        Texture[] ani2 = new Texture[size];
        Texture[] aniH2 = new Texture[size];
        Texture[] aniC2 = new Texture[size];
        Texture[] aniL2 = new Texture[size];
        Texture[] aniB2 = new Texture[size];
        ani2=fl.LoadTextureArray(fileName.concat("0"),size);
        aniH2=fl.LoadTextureArray(fileName.concat("1"),size);
        aniC2=fl.LoadTextureArray(fileName.concat("2"),size);
        aniL2=fl.LoadTextureArray(fileName.concat("3"),size);
        aniB2=fl.LoadTextureArray(fileName.concat("4"),size);
        ani = ani2;
        aniH = aniH2;
        aniC = aniC2;
        aniL = aniL2;
        aniB = aniB2;
    }

    public void changeAnimationEnemy(String fileName,int size)throws IOException{
        this.fileName=fileName;
        this.size=size;
        FileLoader fl=new FileLoader(window);
        Texture[] ani2 = new Texture[size];
        ani2=fl.LoadTextureArray(fileName.concat("0"),size);
        ani = ani2;
    }


    /**
     * Updates helmet colour.
     * @param c New Colour
     */
    public void changeHelmetColour(Color c){
        h=c;
    }

    /**
     * Updates Chest colour.
     * @param c New Colour
     */
    public void changeChestColour(Color c){
        c=c;
    }

    /**
     * Updates Leg colour.
     * @param c New Colour
     */
    public void changeLegColour(Color c){
        l=c;
    }

    /**
     * Updates Boot colour.
     * @param c New Colour
     */
    public void changeBootColour(Color c){
        b=c;
    }
    

}
