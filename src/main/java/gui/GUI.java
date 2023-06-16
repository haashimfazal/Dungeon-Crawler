package gui;

import gui.menu.*;
import logic.items.Inv;

import java.io.IOException;
import java.nio.file.Paths;

import logic.entities.Player;
import logic.items.*;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;


public class GUI {

    RenderWindow window;
    Bar bar;
    HealthBar hp;
    Map mMap;
    LevelMenu level;
    Inventory inv;
    ArmourMenu arm;
    Pause pause;
    Texture t = new Texture();
    private Inv inven;
    ArmourList armList;
    Texture uiPanel1 = new Texture();
    Texture uiPanel2 = new Texture();
    Texture blank = new Texture(); // load icons
    Texture bow = new Texture(); // load icons
    Texture pickaxe = new Texture(); // load icons
    Texture axe = new Texture(); // load icons
    Texture food = new Texture(); // load icons
    Texture sword = new Texture(); // load icons
    Font font = new Font();
    Texture heart = new Texture();
    Map currMap;
    Texture currTexture;


    /**
     * Constructor for GUI
     *
     * @param win RenderWindow GUI will be rendered in
     * @throws IOException
     */
    public GUI(RenderWindow win) throws IOException {

        window = win;

        new Maps(win, font);

        heart.loadFromFile(Paths.get("Images/G6 - eating/Heart.png"));
        font.loadFromFile(Paths.get("Fonts/bilboregular.ttf"));
        sword.loadFromFile(Paths.get("Images/G10 - fighting/sword.png")); // change to map when map is made
        bow.loadFromFile(Paths.get("Images/G10 - fighting/archery (1).png")); // change to map when map is made
        pickaxe.loadFromFile(Paths.get("Images/G7 - mining/pickaxe (1).png")); // change to map when map is made
        axe.loadFromFile(Paths.get("Images/G10 - fighting/axe.png")); // change to map when map is made
        blank.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/BLANK_ICON.png")); // change to map when
        // map // is made
        uiPanel1.loadFromFile(Paths.get(
                "Images/G1 - GUI/generic-rpg-pack_v0.4_(alpha-release)_vacaroxa/rpg-pack/UI/generic-rpg-ui-inventario01.png"));
        uiPanel2.loadFromFile(Paths.get(
                "Images/G1 - GUI/generic-rpg-pack_v0.4_(alpha-release)_vacaroxa/rpg-pack/UI/generic-rpg-ui-inventario02.png"));
        t.loadFromFile(Paths.get("Images/player/1/Individual Sprites/adventurer-run-05.png"));

        inven = new Inv(window, blank, sword, bow, pickaxe, axe, food);
        armList = new ArmourList(window, blank, sword);
        bar = new Bar(sword, inven, uiPanel1, uiPanel2);
        hp = new HealthBar(window);

        currMap = Maps.getCurrentMap();
        currTexture = Maps.getCurrentMapTexture();
        mMap = new Map(window, currTexture, font);

        level = new LevelMenu(window, font,uiPanel2);
        inv = new Inventory(window, font, uiPanel1, uiPanel2);
        arm = new ArmourMenu(window, font, blank, uiPanel1, uiPanel2);
        pause = new Pause(window, font, uiPanel1, uiPanel2);
    }


    /**
     * Renders GUI items.
     *
     * @param player
     */
    public void draw(Player player) throws IOException{
        bar.draw(currMap, inv, level, arm, pause, inven, armList, uiPanel1);
        hp.heartDraw(heart);
        hp.draw(font);
        arm.draw(bar, armList, inven,player,uiPanel2);
        inv.draw(bar, inven, armList, uiPanel1, uiPanel2, player);
        level.draw(bar, player);
        pause.draw(bar, inven, armList,player.getStats());
        currMap.draw();
    }

    public Inv getInven() {
        return inven;
    }

    public Bar getBar() {
        return bar;
    }

    public ArmourList getArmList() {
        return armList;
    }

    public HealthBar getHealthBar() {
        return hp;
    }

    public int isHolding(Bar bar, Inv inv) {
        if (inv.getInv().get(bar.selected - 1) instanceof Armour) {
            return 1;
        }
        if (inv.getInv().get(bar.selected - 1) instanceof Axe) {
            return 2;
        }
        if (inv.getInv().get(bar.selected - 1) instanceof BowItem) {
            return 3;
        }
        if (inv.getInv().get(bar.selected - 1) instanceof Food) {
            return 4;
        }
        if (inv.getInv().get(bar.selected - 1) instanceof Pickaxe) {
            return 5;
        }
        if (inv.getInv().get(bar.selected - 1) instanceof Sword) {
            return 6;
        }
        return 0;
    }

    public Object objectHeld(Bar bar, Inv inv) {
        return inv.getInv().get(bar.selected - 1);

    }
}
