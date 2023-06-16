package gui.menu;

import org.jsfml.window.*;
import org.jsfml.graphics.*;

import org.jsfml.system.*;
import org.jsfml.window.Mouse;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import logic.items.Inv;
import logic.items.*;

public class NpcTrade {
    private RectangleShape back;
    private RectangleShape tiles[];
    private RenderWindow window;
    Text details;
    LinkedList<Items> inventory = new LinkedList<Items>();
    Mouse mouse;
    Vector2i mousePosition;
    int ids[];
    Texture blank = new Texture(); // load icons
    Texture bowt = new Texture(); // load icons
    Texture pickaxet = new Texture(); // load icons
    Texture axet = new Texture(); // load icons
    Texture foodt = new Texture(); // load icons
    Texture swordt = new Texture(); // load icons
    Texture coalt = new Texture(); // load icons
    Texture logt = new Texture(); // load icons
    Texture ui = new Texture(); // load icons
    int numberOfItems;
    boolean check=false;
    int idOut;
    int idIn;
    Clock clock=new Clock();
    int count=0;
    Font font=new Font();
    /**
     * Constructor for Map Class
     * 
     * @param win  RenderWindow for Map
     * @param font Font used in map.
     */
    public NpcTrade(RenderWindow window, int numberOfItems,int ids[],Inv inv,int one,int two)throws IOException {
        font.loadFromFile(Paths.get("Fonts/bilboregular.ttf"));
        
        swordt.loadFromFile(Paths.get("Images/G10 - fighting/sword.png")); // change to map when map is made
        bowt.loadFromFile(Paths.get("Images/G10 - fighting/archery (1).png")); // change to map when map is made
        pickaxet.loadFromFile(Paths.get("Images/G7 - mining/pickaxe (1).png")); // change to map when map is made
        axet.loadFromFile(Paths.get("Images/G10 - fighting/axe.png")); // change to map when map is made
        blank.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/BLANK_ICON.png")); // change to map when
        coalt.loadFromFile(Paths.get("Images/G7 - mining/coal.png"));
        logt.loadFromFile(Paths.get("Images/G8 - woodcutting/wood.png"));
        //ui.loadFromFile(Paths.get("Images/G1 - GUI/generic-rpg-pack_v0.4_(alpha-release)_vacaroxa/rpg-pack/UI/generic-rpg-ui-inventario02.png"));
        ui.loadFromFile(Paths.get("Images/G1 - GUI/generic-rpg-pack_v0.4_(alpha-release)_vacaroxa/rpg-pack/UI/generic-rpg-ui-inventario01.png"));
        this.numberOfItems=numberOfItems;
        this.window = window;
        RectangleShape temp[] = new RectangleShape[numberOfItems * 2];
        tiles = temp;
        this.ids=ids;
        float x = 595 + 30 / 6;
        float y = 45 + 30 / 6;
        for (int i = 0; i < numberOfItems*2; i++) {
            tiles[i] = new RectangleShape(new Vector2f(49.5f, 49.5f));
            tiles[i].setFillColor(Color.WHITE);
            displayItems(tiles[i],ids[i],inv);
            tiles[i].setPosition(x, y);
            x = x + 5 + 49.5f;
            if ((i + 1) % 2 == 0 && i != 0) {
                y = y + 5 + 49.5f;
                x = x - (49.5f * 2 + 2 * 5);
            }
        }

        float xSize = 49.5f * 2f + 5f * 3f;
        float ySize = 49.5f * (float) numberOfItems + 3 * ((float) numberOfItems + 2);
        back = new RectangleShape(new Vector2f(xSize, ySize+49.5f));
        back.setPosition(595, 45);
        //back.setTexture(ui);
        String deal=Integer.toString(one)+" -> "+Integer.toString(two);
        details=new Text(deal, font, 48);
        details.setColor(Color.BLACK);
        details.setPosition(back.getPosition().x+5,back.getPosition().y+back.getSize().y-49.5f);
    }

    /**
     * Renders map onto current RenderWindow
     * 
     * @param b Bar.
     */
    public void draw(Inv inv) throws IOException{
        //
window.draw(back);
        for (int i = 0; i < numberOfItems*2; i++) {
            
            if ((i + 1) % 2 == 0 && i != 0) {
                detectTilePressed(tiles[i],i);
            }
            displayItems(tiles[i], ids[i], inv);
            
            window.draw(tiles[i]);
        }
        window.draw(details);
    }

    /**
     * Detects current Tile being interacted with
     * 
     * @param s        Square instance to be checked
     * @param inven    Current Inv
     * @param i        Index
     * @param uiPanel1 UIPanel texture 1
     * @param uiPanel2 UIPanel texture 2
     */
    public void detectTilePressed(RectangleShape s,int id) {
        // LinkedList<logic.items.Items> inv = inven.getInv();
        debounce();
        mousePosition = mouse.getPosition(window);
        Float xMin = s.getPosition().x;
        Float xMax = xMin + s.getSize().x;
        Float yMin = s.getPosition().y;
        Float yMax = yMin + s.getSize().y;
        if (mousePosition.x > xMin && mousePosition.x < xMax && mousePosition.y > yMin && mousePosition.y < yMax
                && Mouse.isButtonPressed(Mouse.Button.LEFT)) {
            s.setFillColor(Color.BLUE);
                    idIn=id;
                    check=true;
                    clock.restart();
        } else {
            s.setFillColor(Color.WHITE);
            //check=false;
        }
        
    }
    public boolean getCheck(){
        return check;
    }
    public void debounce(){
        if(clock.getElapsedTime().asMilliseconds()<150){
                check=true;
        }else{
            check=false;
            
        }
        
    }
    
    public int getInID(){
       // System.out.println((idIn+1)/2-1);
        return (idIn+1)/2-1;
    }

    public void displayItems(RectangleShape r,int i, Inv inv)throws IOException{
        Items temp=inv.getItemById(i);
        r.setTexture(temp.getTexture());
    }
}
