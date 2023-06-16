package logic.items;

import java.util.LinkedList;
import java.util.ArrayList;

//import logic.items.Items;
import org.jsfml.graphics.*;

import gui.menu.Bar;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import logic.entities.Player;

public class Inv {
    LinkedList<Items> inventory = new LinkedList<Items>();
    LinkedList<Food> foods = new LinkedList<Food>();
    RectangleShape square = new RectangleShape();
    RenderWindow window;
    File ids;
    ArrayList<Integer> invText = new ArrayList<Integer>();
    Texture blank = new Texture();
    Texture swordt0 = new Texture();

    Texture swordt1 = new Texture();
    Texture swordt2 = new Texture();
    Texture swordt3 = new Texture();
    Texture swordt4 = new Texture();
    Texture swordt5 = new Texture();
    Texture swordt6 = new Texture();
    Texture swordt7 = new Texture();
    Texture swordt8 = new Texture();
    Texture swordt9 = new Texture();

    Texture bowt0 = new Texture();
    Texture bowt1 = new Texture();
    Texture bowt2 = new Texture();
    Texture bowt3 = new Texture();
    Texture bowt4 = new Texture();
    Texture bowt5 = new Texture();
    Texture bowt6 = new Texture();
    Texture bowt7 = new Texture();
    Texture bowt8 = new Texture();
    Texture bowt9 = new Texture();

    Texture pickaxet0 = new Texture();
    Texture pickaxet1 = new Texture();
    Texture pickaxet2 = new Texture();
    Texture pickaxet3 = new Texture();
    Texture pickaxet4 = new Texture();
    Texture pickaxet5 = new Texture();
    Texture pickaxet6 = new Texture();
    Texture pickaxet7 = new Texture();
    Texture pickaxet8 = new Texture();
    Texture pickaxet9 = new Texture();

    Texture axet0 = new Texture();
    Texture axet1 = new Texture();
    Texture axet2 = new Texture();
    Texture axet3 = new Texture();
    Texture axet4 = new Texture();
    Texture axet5 = new Texture();
    Texture axet6 = new Texture();
    Texture axet7 = new Texture();
    Texture axet8 = new Texture();
    Texture axet9 = new Texture();

    Texture coalt0 = new Texture();
    Texture coalt1 = new Texture();
    Texture coalt2 = new Texture();
    Texture coalt3 = new Texture();
    Texture coalt4 = new Texture();
    Texture coalt5 = new Texture();
    Texture coalt6 = new Texture();
    Texture coalt7 = new Texture();
    Texture coalt8 = new Texture();
    Texture coalt9 = new Texture();

    Texture logt0 = new Texture();
    Texture logt1 = new Texture();
    Texture logt2 = new Texture();
    Texture logt3 = new Texture();
    Texture logt4 = new Texture();
    Texture logt5 = new Texture();
    Texture logt6 = new Texture();
    Texture logt7 = new Texture();
    Texture logt8 = new Texture();
    Texture logt9 = new Texture();

    Texture foodt0 = new Texture();
    Texture foodt1 = new Texture();
    Texture foodt2 = new Texture();
    Texture foodt3 = new Texture();
    Texture foodt4 = new Texture();
    Texture foodt5 = new Texture();
    Texture foodt6 = new Texture();
    Texture foodt7 = new Texture();
    Texture foodt8 = new Texture();
    Texture foodt9 = new Texture();

    Texture helmetst0 = new Texture();
    Texture helmetst1 = new Texture();
    Texture helmetst2 = new Texture();
    Texture helmetst3 = new Texture();
    Texture helmetst4 = new Texture();
    Texture helmetst5 = new Texture();
    Texture helmetst6 = new Texture();
    Texture helmetst7 = new Texture();
    Texture helmetst8 = new Texture();
    Texture helmetst9 = new Texture();

    Texture chestst0 = new Texture();
    Texture chestst1 = new Texture();
    Texture chestst2 = new Texture();
    Texture chestst3 = new Texture();
    Texture chestst4 = new Texture();
    Texture chestst5 = new Texture();
    Texture chestst6 = new Texture();
    Texture chestst7 = new Texture();
    Texture chestst8 = new Texture();
    Texture chestst9 = new Texture();

    Texture legst0 = new Texture();
    Texture legst1 = new Texture();
    Texture legst2 = new Texture();
    Texture legst3 = new Texture();
    Texture legst4 = new Texture();
    Texture legst5 = new Texture();
    Texture legst6 = new Texture();
    Texture legst7 = new Texture();
    Texture legst8 = new Texture();
    Texture legst9 = new Texture();

    Texture bootst0 = new Texture();
    Texture bootst1 = new Texture();
    Texture bootst2 = new Texture();
    Texture bootst3 = new Texture();
    Texture bootst4 = new Texture();
    Texture bootst5 = new Texture();
    Texture bootst6 = new Texture();
    Texture bootst7 = new Texture();
    Texture bootst8 = new Texture();
    Texture bootst9 = new Texture();

    Texture shieldst0 = new Texture();
    Texture shieldst1 = new Texture();
    Texture shieldst2 = new Texture();
    Texture shieldst3 = new Texture();
    Texture shieldst4 = new Texture();
    Texture shieldst5 = new Texture();
    Texture shieldst6 = new Texture();
    Texture shieldst7 = new Texture();
    Texture shieldst8 = new Texture();
    Texture shieldst9 = new Texture();

    int amountFree = 70;


    /**
     * Constructor to create Inventory
     *
     * @param win      RenderWindow instance of Inv will be rendered in.
     * @param blank    Texture for free inventory slot
     * @param sword    Texture for sword item
     * @param bowt     Texture for bow item
     * @param pickaxet Texture for Pickaxe item
     * @param axet     Texture for axe item
     * @param foodt    Texture for food item.
     * @throws IOException
     */
    public Inv(RenderWindow win, Texture blank, Texture sword, Texture bowt, Texture pickaxet, Texture axet, Texture foodt) throws IOException {
        window = win;
        this.blank = blank;

        ids = new File("Text files/inventoryID");

        this.swordt0.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (1).png"));
        this.swordt1.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (2).png"));
        this.swordt2.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (3).png"));
        this.swordt3.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (6).png"));
        this.swordt4.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (10).png"));
        this.swordt5.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (11).png"));
        this.swordt6.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (14).png"));
        this.swordt7.loadFromFile(Paths.get("Images/G10 - fighting/swords/S2 (1).png"));
        this.swordt8.loadFromFile(Paths.get("Images/G10 - fighting/swords/S3 (2).png"));
        this.swordt9.loadFromFile(Paths.get("Images/G10 - fighting/swords/S8 (2).png"));

        this.pickaxet0.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/0.png"));
        this.pickaxet1.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g3119.png"));
        this.pickaxet2.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g4788.png"));
        this.pickaxet3.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g5177.png"));
        this.pickaxet4.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g6716.png"));
        this.pickaxet5.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g8384.png"));
        this.pickaxet6.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g10063.png"));
        this.pickaxet7.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g10144.png"));
        this.pickaxet8.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g11157.png"));
        this.pickaxet9.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/pickaxe (1).png"));

        this.bowt0.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black1.png"));
        this.bowt1.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black2.png"));
        this.bowt2.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black3.png"));
        this.bowt3.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black4.png"));
        this.bowt4.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black5.png"));
        this.bowt5.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black6.png"));
        this.bowt6.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black7.png"));
        this.bowt7.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black8.png"));
        this.bowt8.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black9.png"));
        this.bowt9.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black10.png"));


        this.axet0.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/axe (1) (copy).png"));
        this.axet1.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g7538.png"));
        this.axet2.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8477.png"));
        this.axet3.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8545.png"));
        this.axet4.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8616.png"));
        this.axet5.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8708.png"));
        this.axet6.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8765.png"));
        this.axet7.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8818.png"));
        this.axet8.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8989.png"));
        this.axet9.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g9432.png"));

        this.coalt0.loadFromFile(Paths.get("Images/G7 - mining/ores/bg_01.png"));
        this.coalt1.loadFromFile(Paths.get("Images/G7 - mining/ores/dg_28.png"));
        this.coalt2.loadFromFile(Paths.get("Images/G7 - mining/ores/emerald.png"));
        this.coalt3.loadFromFile(Paths.get("Images/G7 - mining/ores/gem.png"));
        this.coalt4.loadFromFile(Paths.get("Images/G7 - mining/ores/yg_14b.png"));
        this.coalt5.loadFromFile(Paths.get("Images/G7 - mining/ores/gg_04a.png"));
        this.coalt6.loadFromFile(Paths.get("Images/G7 - mining/ores/mg_03.png"));
        this.coalt7.loadFromFile(Paths.get("Images/G7 - mining/ores/pg_06.png"));
        this.coalt8.loadFromFile(Paths.get("Images/G7 - mining/ores/rg_08.png"));
        this.coalt9.loadFromFile(Paths.get("Images/G7 - mining/ores/sg_13a.png"));

        this.logt0.loadFromFile(Paths.get("Images/logs/board.png"));
        this.logt1.loadFromFile(Paths.get("Images/logs/resources_basic.png"));
        this.logt2.loadFromFile(Paths.get("Images/logs/resources_basic.png.png"));
        this.logt3.loadFromFile(Paths.get("Images/logs/resources_basic.png(1).png"));
        this.logt4.loadFromFile(Paths.get("Images/logs/resources_basic.png(2).png"));
        this.logt5.loadFromFile(Paths.get("Images/logs/resources_basic.png(3).png"));
        this.logt6.loadFromFile(Paths.get("Images/logs/resources_basic.png(4).png"));
        this.logt7.loadFromFile(Paths.get("Images/logs/resources_basic.png(5).png"));
        this.logt8.loadFromFile(Paths.get("Images/logs/wood.png"));
        this.logt9.loadFromFile(Paths.get("Images/logs/Wood Log.png"));

        this.foodt0.loadFromFile(Paths.get("Images/G6 - eating/food/Apple.png"));
        this.foodt1.loadFromFile(Paths.get("Images/G6 - eating/food/Avocado.png"));
        this.foodt2.loadFromFile(Paths.get("Images/G6 - eating/food/Bacon.png"));
        this.foodt3.loadFromFile(Paths.get("Images/G6 - eating/food/Boar.png"));
        this.foodt4.loadFromFile(Paths.get("Images/G6 - eating/food/Bread.png"));
        this.foodt5.loadFromFile(Paths.get("Images/G6 - eating/food/Brownie.png"));
        this.foodt6.loadFromFile(Paths.get("Images/G6 - eating/food/Cheese.png"));
        this.foodt7.loadFromFile(Paths.get("Images/G6 - eating/food/Cherry.png"));
        this.foodt8.loadFromFile(Paths.get("Images/G6 - eating/food/Chicken.png"));
        this.foodt9.loadFromFile(Paths.get("Images/G6 - eating/food/Jerky.png"));

        this.bootst0.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC222.png"));
        this.bootst1.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC224.png"));
        this.bootst2.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC225.png"));
        this.bootst3.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC229.png"));
        this.bootst4.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC232.png"));
        this.bootst5.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC234.png"));
        this.bootst6.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC235.png"));
        this.bootst7.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC238.png"));
        this.bootst8.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC239.png"));
        this.bootst9.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC240.png"));

        this.legst0.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC202.png"));
        this.legst1.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC204.png"));
        this.legst2.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC205.png"));
        this.legst3.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC209.png"));
        this.legst4.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC212.png"));
        this.legst5.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC214.png"));
        this.legst6.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC215.png"));
        this.legst7.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC218.png"));
        this.legst8.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC219.png"));
        this.legst9.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC220.png"));

        this.chestst0.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC182.png"));
        this.chestst1.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC184.png"));
        this.chestst2.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC185.png"));
        this.chestst3.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC189.png"));
        this.chestst4.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC192.png"));
        this.chestst5.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC194.png"));
        this.chestst6.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC195.png"));
        this.chestst7.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC198.png"));
        this.chestst8.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC199.png"));
        this.chestst9.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC200.png"));

        this.helmetst0.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC162.png"));
        this.helmetst1.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC164.png"));
        this.helmetst2.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC165.png"));
        this.helmetst3.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC169.png"));
        this.helmetst4.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC172.png"));
        this.helmetst5.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC174.png"));
        this.helmetst6.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC175.png"));
        this.helmetst7.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC178.png"));
        this.helmetst8.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC179.png"));
        this.helmetst9.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC180.png"));

        this.shieldst0.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC142.png"));
        this.shieldst1.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC144.png"));
        this.shieldst2.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC145.png"));
        this.shieldst3.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC149.png"));
        this.shieldst4.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC152.png"));
        this.shieldst5.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC154.png"));
        this.shieldst6.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC155.png"));
        this.shieldst7.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC158.png"));
        this.shieldst8.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC159.png"));
        this.shieldst9.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC160.png"));

        load();
        amountFree();
    }

    /**
     * Constructor to create Inventory
     *
     * @param win RenderWindow instance of Inv will be rendered in.
     * @throws IOException
     */
    public Inv(RenderWindow win) throws IOException {
        window = win;
        this.blank.loadFromFile(Paths.get("Images/G9 - thing dropped on the floor/BLANK_ICON.png"));

        ids = new File("Text files/inventoryID");

        this.swordt0.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (1).png"));
        this.swordt1.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (2).png"));
        this.swordt2.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (3).png"));
        this.swordt3.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (6).png"));
        this.swordt4.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (10).png"));
        this.swordt5.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (11).png"));
        this.swordt6.loadFromFile(Paths.get("Images/G10 - fighting/swords/S1 (14).png"));
        this.swordt7.loadFromFile(Paths.get("Images/G10 - fighting/swords/S2 (1).png"));
        this.swordt8.loadFromFile(Paths.get("Images/G10 - fighting/swords/S3 (2).png"));
        this.swordt9.loadFromFile(Paths.get("Images/G10 - fighting/swords/S8 (2).png"));

        this.pickaxet0.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/0.png"));
        this.pickaxet1.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g3119.png"));
        this.pickaxet2.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g4788.png"));
        this.pickaxet3.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g5177.png"));
        this.pickaxet4.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g6716.png"));
        this.pickaxet5.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g8384.png"));
        this.pickaxet6.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g10063.png"));
        this.pickaxet7.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g10144.png"));
        this.pickaxet8.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/g11157.png"));
        this.pickaxet9.loadFromFile(Paths.get("Images/G7 - mining/pickaxes/pickaxe (1).png"));

        this.bowt0.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black1.png"));
        this.bowt1.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black2.png"));
        this.bowt2.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black3.png"));
        this.bowt3.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black4.png"));
        this.bowt4.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black5.png"));
        this.bowt5.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black6.png"));
        this.bowt6.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black7.png"));
        this.bowt7.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black8.png"));
        this.bowt8.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black9.png"));
        this.bowt9.loadFromFile(Paths.get("Images/G10 - fighting/bows/Bow Black10.png"));

        this.axet0.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/axe (1) (copy).png"));
        this.axet1.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g7538.png"));
        this.axet2.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8477.png"));
        this.axet3.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8545.png"));
        this.axet4.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8616.png"));
        this.axet5.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8708.png"));
        this.axet6.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8765.png"));
        this.axet7.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8818.png"));
        this.axet8.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g8989.png"));
        this.axet9.loadFromFile(Paths.get("Images/G8 - woodcutting/axes/g9432.png"));

        this.coalt0.loadFromFile(Paths.get("Images/G7 - mining/ores/bg_01.png"));
        this.coalt1.loadFromFile(Paths.get("Images/G7 - mining/ores/dg_28.png"));
        this.coalt2.loadFromFile(Paths.get("Images/G7 - mining/ores/emerald.png"));
        this.coalt3.loadFromFile(Paths.get("Images/G7 - mining/ores/gem.png"));
        this.coalt4.loadFromFile(Paths.get("Images/G7 - mining/ores/yg_14b.png"));
        this.coalt5.loadFromFile(Paths.get("Images/G7 - mining/ores/gg_04a.png"));
        this.coalt6.loadFromFile(Paths.get("Images/G7 - mining/ores/mg_03.png"));
        this.coalt7.loadFromFile(Paths.get("Images/G7 - mining/ores/pg_06.png"));
        this.coalt8.loadFromFile(Paths.get("Images/G7 - mining/ores/rg_08.png"));
        this.coalt9.loadFromFile(Paths.get("Images/G7 - mining/ores/sg_13a.png"));

        this.foodt0.loadFromFile(Paths.get("Images/G6 - eating/food/Apple.png"));
        this.foodt1.loadFromFile(Paths.get("Images/G6 - eating/food/Avocado.png"));
        this.foodt2.loadFromFile(Paths.get("Images/G6 - eating/food/Bacon.png"));
        this.foodt3.loadFromFile(Paths.get("Images/G6 - eating/food/Boar.png"));
        this.foodt4.loadFromFile(Paths.get("Images/G6 - eating/food/Bread.png"));
        this.foodt5.loadFromFile(Paths.get("Images/G6 - eating/food/Brownie.png"));
        this.foodt6.loadFromFile(Paths.get("Images/G6 - eating/food/Cheese.png"));
        this.foodt7.loadFromFile(Paths.get("Images/G6 - eating/food/Cherry.png"));
        this.foodt8.loadFromFile(Paths.get("Images/G6 - eating/food/Chicken.png"));
        this.foodt9.loadFromFile(Paths.get("Images/G6 - eating/food/Jerky.png"));

        this.bootst0.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC222.png"));
        this.bootst1.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC224.png"));
        this.bootst2.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC225.png"));
        this.bootst3.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC229.png"));
        this.bootst4.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC232.png"));
        this.bootst5.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC234.png"));
        this.bootst6.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC235.png"));
        this.bootst7.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC238.png"));
        this.bootst8.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC239.png"));
        this.bootst9.loadFromFile(Paths.get("Images/G10 - fighting/boots/EquipmentIconsC240.png"));

        this.legst0.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC202.png"));
        this.legst1.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC204.png"));
        this.legst2.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC205.png"));
        this.legst3.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC209.png"));
        this.legst4.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC212.png"));
        this.legst5.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC214.png"));
        this.legst6.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC215.png"));
        this.legst7.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC218.png"));
        this.legst8.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC219.png"));
        this.legst9.loadFromFile(Paths.get("Images/G10 - fighting/legs/EquipmentIconsC220.png"));

        this.chestst0.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC182.png"));
        this.chestst1.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC184.png"));
        this.chestst2.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC185.png"));
        this.chestst3.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC189.png"));
        this.chestst4.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC192.png"));
        this.chestst5.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC194.png"));
        this.chestst6.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC195.png"));
        this.chestst7.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC198.png"));
        this.chestst8.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC199.png"));
        this.chestst9.loadFromFile(Paths.get("Images/G10 - fighting/chestplate/EquipmentIconsC200.png"));

        this.helmetst0.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC162.png"));
        this.helmetst1.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC164.png"));
        this.helmetst2.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC165.png"));
        this.helmetst3.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC169.png"));
        this.helmetst4.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC172.png"));
        this.helmetst5.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC174.png"));
        this.helmetst6.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC175.png"));
        this.helmetst7.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC178.png"));
        this.helmetst8.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC179.png"));
        this.helmetst9.loadFromFile(Paths.get("Images/G10 - fighting/helmets/EquipmentIconsC180.png"));

        this.shieldst0.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC142.png"));
        this.shieldst1.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC144.png"));
        this.shieldst2.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC145.png"));
        this.shieldst3.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC149.png"));
        this.shieldst4.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC152.png"));
        this.shieldst5.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC154.png"));
        this.shieldst6.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC155.png"));
        this.shieldst7.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC158.png"));
        this.shieldst8.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC159.png"));
        this.shieldst9.loadFromFile(Paths.get("Images/G10 - fighting/shields/EquipmentIconsC160.png"));

        this.logt0.loadFromFile(Paths.get("Images/logs/board.png"));
        this.logt1.loadFromFile(Paths.get("Images/logs/resources_basic.png"));
        this.logt2.loadFromFile(Paths.get("Images/logs/resources_basic.png.png"));
        this.logt3.loadFromFile(Paths.get("Images/logs/resources_basic.png(1).png"));
        this.logt4.loadFromFile(Paths.get("Images/logs/resources_basic.png(2).png"));
        this.logt5.loadFromFile(Paths.get("Images/logs/resources_basic.png(3).png"));
        this.logt6.loadFromFile(Paths.get("Images/logs/resources_basic.png(4).png"));
        this.logt7.loadFromFile(Paths.get("Images/logs/resources_basic.png(5).png"));
        this.logt8.loadFromFile(Paths.get("Images/logs/wood.png"));
        this.logt9.loadFromFile(Paths.get("Images/logs/Wood Log.png"));

        load();
        amountFree();
    }


    /**
     * Accessor method
     *
     * @return Returns current items in Inventory
     */
    public LinkedList<Items> getInv() {
        return inventory;
    }


    /**
     * Adds item to inventory
     *
     * @param a Item to be added to inventory
     */
    public void addItem(Items a) {
        amountFree();
        if (amountFree > 0) {
            inventory.add(findFree(), a);
            removeFree();
        } else {
            System.out.println(" gui.menu.Inventory Full");
        }

        amountFree();
    }


    /**
     * Removed item from Inventory
     *
     * @param a Item to be removed from inventory
     */
    public void removeItem(Items a) {
        inventory.remove(a);
    }


    /**
     * Swaps the locations of items in inventory
     *
     * @param a Item 1 to be swapped
     * @param b Item 2 to be swapped
     */
    public void swap(int a, int b) { // a is location of first, b location of second
        inventory.add(a, inventory.get(b));
        inventory.remove(a);
        inventory.add(b, inventory.get(a));
        inventory.remove(b);
    }


    /**
     * Saved current inventory
     */
    public void save() {
        invText.clear();
        for (int i = 0; i < inventory.size(); i++) {
            invText.add(inventory.get(i).getID());
            // invText.add(2);
        }
        // System.out.println(invText);

        try {
            FileWriter fw = new FileWriter(ids, false);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < inventory.size(); i++) {
                output.write(invText.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("failed");
        }

    }
    /**
     * newGame
     */
    public void newGame() {
        invText.clear();
        for (int i = 0; i < inventory.size(); i++) {
            invText.add(0);
        }
        // System.out.println(invText);

        try {
            FileWriter fw = new FileWriter(ids, false);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < inventory.size(); i++) {
                output.write(invText.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("failed");
        }

    }

    /**
     * Loads inventory of last game boot.
     */
    public void load() throws IOException {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(ids));
            while ((line = input.readLine()) != null) {
                invText.add(Integer.parseInt(line));
            }
            input.close();
        } catch (Exception e) {

        }

        for (int i = 0; i < 70; i++) {
            Items item=getItemById(invText.get(i));
            inventory.add(item);
            if(item instanceof Food){
                foods.add((Food)item);
            }

        }

    }

    /**
     * return an item given the id of the item
     * @param i integer represents the id of item they want to get
     * @return
     * @throws IOException
     */
    public Items getItemById(int i)throws IOException {
        Items item;
        Sword sword;
        Pickaxe pickaxe;
        Axe axe;
        BowItem bow;
        Food food;
        Chest chest;
        Helmet helmet;
        Legs legs;
        Boots boots;
        Shields shields;



        if ((i) == 0) { // need to convert id to item
            item = new Items(window, blank, 0);
            return item;
        }
        if ((i) == 10) { // need to convert id to item
            sword = new Sword(window, swordt0, 10, 0, 0, 0, 5); //RenderWindow win, Texture t, int id, int damage, int prot, int archery, int defence
            return sword;
        }
        if ((i) == 11) { // need to convert id to item
            sword = new Sword(window, swordt1, 11, 0, 0, 1, 10);
            return sword;
        }
        if ((i) == 12) { // need to convert id to item
            sword = new Sword(window, swordt2, 12, 0, 0, 2, 10);
            return sword;
        }
        if ((i) == 13) { // need to convert id to item
            sword = new Sword(window, swordt3, 13, 0, 0, 3, 10);
            return sword;
        }
        if ((i) == 14) { // need to convert id to item
            sword = new Sword(window, swordt4, 14, 0, 0, 4, 10);
            return sword;
        }
        if ((i) == 15) { // need to convert id to item
            sword = new Sword(window, swordt5, 15, 0, 0, 5, 10);
            return sword;
        }
        if ((i) == 16) { // need to convert id to item
            sword = new Sword(window, swordt6, 16, 0, 0, 6, 10);
            return sword;
        }
        if ((i) == 17) { // need to convert id to item
            sword = new Sword(window, swordt7, 17, 0, 0, 7, 10);
            return sword;
        }
        if ((i) == 18) { // need to convert id to item
            sword = new Sword(window, swordt8, 18, 0, 0, 8, 10);
            return sword;
        }
        if ((i) == 19) { // need to convert id to item
            sword = new Sword(window, swordt9, 19, 0, 0, 9, 10);
            return sword;
        }
        //////////////////
        if ((i) == 20) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet0, 20, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 21) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet1, 21, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 22) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet2, 22, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 23) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet3, 23, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 24) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet4, 24, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 25) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet5, 25, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 26) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet6, 26, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 27) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet7, 27, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 28) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet8, 28, 0, 0, 0, 0);
            return pickaxe;
        }
        if ((i) == 29) { // need to convert id to item
            pickaxe = new Pickaxe(window, pickaxet9, 29, 0, 0, 0, 0);
            return pickaxe;
        }
        /////////////
        if ((i) == 30) { // need to convert id to item
            bow = new BowItem(window, bowt0, 30, 0, 0, 10, 0);
            return bow;
        }
        if ((i) == 31) { // need to convert id to item
            bow = new BowItem(window, bowt1, 31, 0, 0, 11, 0);
            return bow;
        }
        if ((i) == 32) { // need to convert id to item
            bow = new BowItem(window, bowt2, 32, 0, 0, 12, 0);
            return bow;
        }
        if ((i) == 33) { // need to convert id to item
            bow = new BowItem(window, bowt3, 33, 0, 0, 13, 0);
            return bow;
        }
        if ((i) == 34) { // need to convert id to item
            bow = new BowItem(window, bowt4, 34, 0, 0, 14, 0);
            return bow;
        }
        if ((i) == 35) { // need to convert id to item
            bow = new BowItem(window, bowt5, 35, 0, 0, 15, 0);
            return bow;
        }
        if ((i) == 36) { // need to convert id to item
            bow = new BowItem(window, bowt6, 36, 0, 0, 16, 0);
            return bow;
        }
        if ((i) == 37) { // need to convert id to item
            bow = new BowItem(window, bowt7, 37, 0, 0, 17, 0);
            return bow;
        }
        if ((i) == 38) { // need to convert id to item
            bow = new BowItem(window, bowt8, 38, 0, 0, 18, 0);
            return bow;
        }
        if ((i) == 39) { // need to convert id to item
            bow = new BowItem(window, bowt9, 39, 0, 0, 19, 0);
            return bow;
        }
        /////////////////////////
        if ((i) == 40) { // need to convert id to item
            axe = new Axe(window, axet0, 40, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 41) { // need to convert id to item
            axe = new Axe(window, axet1, 41, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 42) { // need to convert id to item
            axe = new Axe(window, axet2, 42, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 43) { // need to convert id to item
            axe = new Axe(window, axet3, 43, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 44) { // need to convert id to item
            axe = new Axe(window, axet4, 44, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 45) { // need to convert id to item
            axe = new Axe(window, axet5, 45, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 46) { // need to convert id to item
            axe = new Axe(window, axet6, 46, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 47) { // need to convert id to item
            axe = new Axe(window, axet7, 47, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 48) { // need to convert id to item
            axe = new Axe(window, axet8, 48, 0, 0, 0, 0);
            return axe;
        }
        if ((i) == 49) { // need to convert id to item
            axe = new Axe(window, axet9, 49, 0, 0, 0, 0);
            return axe;
        }
        ///////////////
        if ((i) == 50) { // need to convert id to item
            item = new Items(window, coalt0, 50);
            return item;
        }
        if ((i) == 51) { // need to convert id to item
            item = new Items(window, coalt1, 51);
            return item;
        }
        if ((i) == 52) { // need to convert id to item
            item = new Items(window, coalt2, 52);
            return item;
        }
        if ((i) == 53) { // need to convert id to item
            item = new Items(window, coalt3, 53);
            return item;
        }
        if ((i) == 54) { // need to convert id to item
            item = new Items(window, coalt4, 54);
            return item;
        }
        if ((i) == 55) { // need to convert id to item
            item = new Items(window, coalt5, 55);
            return item;
        }
        if ((i) == 56) { // need to convert id to item
            item = new Items(window, coalt6, 56);
            return item;
        }
        if ((i) == 57) { // need to convert id to item
            item = new Items(window, coalt7, 57);
            return item;
        }
        if ((i) == 58) { // need to convert id to item
            item = new Items(window, coalt8, 58);
            return item;
        }
        if ((i) == 59) { // need to convert id to item
            item = new Items(window, coalt9, 59);
            return item;
        }
        //////////
        if ((i) == 60) { // need to convert id to item
            item = new Items(window, logt0, 60);
            return item;
        }
        if ((i) == 61) { // need to convert id to item
            item = new Items(window, logt1, 61);
            return item;
        }
        if ((i) == 62) { // need to convert id to item
            item = new Items(window, logt2, 62);
            return item;
        }
        if ((i) == 63) { // need to convert id to item
            item = new Items(window, logt3, 63);
            return item;
        }
        if ((i) == 64) { // need to convert id to item
            item = new Items(window, logt4, 64);
            return item;
        }
        if ((i) == 65) { // need to convert id to item
            item = new Items(window, logt5, 65);
            return item;
        }
        if ((i) == 66) { // need to convert id to item
            item = new Items(window, logt6, 66);
            return item;
        }
        if ((i) == 67) { // need to convert id to item
            item = new Items(window, logt7, 67);
            return item;
        }
        if ((i) == 68) { // need to convert id to item
            item = new Items(window, logt8, 68);
            return item;
        }
        if ((i) == 69) { // need to convert id to item
            item = new Items(window, logt9, 69);
            return item;
        }
        /////////////////////////
        if ((i) == 70) { // need to convert id to item
            food = new Food(10, window, 70, foodt0,10,0,0,10,30000);
            return food;

        }
        if ((i) == 71) { // need to convert id to item
            food = new Food(10, window, 71, foodt1,0,10,10,0,30);
            return food;

        }
        if ((i) == 72) { // need to convert id to item
            food = new Food(10, window, 72, foodt2,20,0,0,0,30);
            return food;

        }
        if ((i) == 73) { // need to convert id to item
            food = new Food(10, window, 73, foodt3,0,0,0,20,30);
            return food;

        }
        if ((i) == 74) { // need to convert id to item
            food = new Food(10, window, 74, foodt4,10,10,10,10,30);
            return food;

        }
        if ((i) == 75) { // need to convert id to item
            food = new Food(10, window, 75, foodt5,20,20,20,20,20);
            return food;

        }
        if ((i) == 76) { // need to convert id to item
            food = new Food(10, window, 76, foodt6,100,0,100,-50,30);
            return food;

        }
        if ((i) == 77) { // need to convert id to item
            food = new Food(10, window, 77, foodt7,0,0,0,100,30);
            return food;

        }
        if ((i) == 78) { // need to convert id to item
            food = new Food(10, window, 78, foodt8,50,50,50,50,30);
            return food;

        }
        if ((i) == 79) { // need to convert id to item
            food = new Food(10, window, 79, foodt9,1000,100,1000,100,10);
            return food;

        }
        ///////////////////////
        if ((i) == 80) { // need to convert id to item
            helmet = new Helmet(window, helmetst0, 80, 10, 10, 10, 10);
            return helmet;
        }
        if ((i) == 81) { // need to convert id to item
            helmet = new Helmet(window, helmetst1, 81,  11, 11, 11, 11);
            return helmet;
        }
        if ((i) == 82) { // need to convert id to item
            helmet = new Helmet(window, helmetst2, 82,  12, 12, 12, 12);
            return helmet;
        }
        if ((i) == 83) { // need to convert id to item
            helmet = new Helmet(window, helmetst3, 83,  13, 13, 13, 13);
            return helmet;
        }
        if ((i) == 84) { // need to convert id to item
            helmet = new Helmet(window, helmetst4, 84,  14, 14, 14, 14);
            return helmet;
        }
        if ((i) == 85) { // need to convert id to item
            helmet = new Helmet(window, helmetst5, 85,  15, 15, 15, 15);
            return helmet;
        }
        if ((i) == 86) { // need to convert id to item
            helmet = new Helmet(window, helmetst6, 86,  16, 16, 16, 16);
            return helmet;
        }
        if ((i) == 87) { // need to convert id to item
            helmet = new Helmet(window, helmetst7, 87,  17, 17, 17, 17);
            return helmet;
        }
        if ((i) == 88) { // need to convert id to item
            helmet = new Helmet(window, helmetst8, 88,  18, 18, 18, 18);
            return helmet;
        }
        if ((i) == 89) { // need to convert id to item
            helmet = new Helmet(window, helmetst9, 89,  19, 19, 19, 19);
            return helmet;
        }
        /////////////
        if ((i) == 90) { // need to convert id to item
            chest = new Chest(window, chestst0, 90, 10, 10, 10, 10);
            return chest;
        }
        if ((i) == 91) { // need to convert id to item
            chest = new Chest(window, chestst1, 91, 11, 11, 11, 11);
            return chest;
        }
        if ((i) == 92) { // need to convert id to item
            chest = new Chest(window, chestst2, 92, 12, 12, 12, 12);
            return chest;
        }
        if ((i) == 93) { // need to convert id to item
            chest = new Chest(window, chestst3, 93, 13, 13, 13, 13);
            return chest;
        }
        if ((i) == 94) { // need to convert id to item
            chest = new Chest(window, chestst4, 94, 14, 14, 14, 14);
            return chest;
        }
        if ((i) == 95) { // need to convert id to item
            chest = new Chest(window, chestst5, 95, 15, 15, 15, 15);
            return chest;
        }
        if ((i) == 96) { // need to convert id to item
            chest = new Chest(window, chestst6, 96, 16, 16, 16, 16);
            return chest;
        }
        if ((i) == 97) { // need to convert id to item
            chest = new Chest(window, chestst7, 97, 17, 17, 17, 17);
            return chest;
        }
        if ((i) == 98) { // need to convert id to item
            chest = new Chest(window, chestst8, 98, 18, 18, 18, 18);
            return chest;
        }
        if ((i) == 99) { // need to convert id to item
            chest = new Chest(window, chestst9, 99, 19, 19, 19, 19);
            return chest;
        }
        ////////
        if ((i) == 100) { // need to convert id to item
            legs = new Legs(window, legst0, 100, 10, 10, 10, 10);
            return legs;
        }
        if ((i) == 101) { // need to convert id to item
            legs = new Legs(window, legst1, 101, 11, 11, 11, 11);
            return legs;
        }
        if ((i) == 102) { // need to convert id to item
            legs = new Legs(window, legst2, 102, 12, 12, 12, 12);
            return legs;
        }
        if ((i) == 103) { // need to convert id to item
            legs = new Legs(window, legst3, 103, 13, 13, 13, 13);
            return legs;
        }
        if ((i) == 104) { // need to convert id to item
            legs = new Legs(window, legst4, 104, 14, 14, 14, 14);
            return legs;
        }
        if ((i) == 105) { // need to convert id to item
            legs = new Legs(window, legst5, 105, 15, 15, 15, 15);
            return legs;
        }
        if ((i) == 106) { // need to convert id to item
            legs = new Legs(window, legst6, 106, 16, 16, 16, 16);
            return legs;
        }
        if ((i) == 107) { // need to convert id to item
            legs = new Legs(window, legst7, 107, 17, 17, 17, 17);
            return legs;
        }
        if ((i) == 108) { // need to convert id to item
            legs = new Legs(window, legst8, 108, 18, 18, 18, 18);
            return legs;
        }
        if ((i) == 109) { // need to convert id to item
            legs = new Legs(window, legst9, 109,  19, 19, 19, 19);
            return legs;
        }
        //////
        if ((i) == 110) { // need to convert id to item
            boots = new Boots(window, bootst0, 110, 10, 10, 10, 10);
            return boots;
        }
        if ((i) == 111) { // need to convert id to item
            boots = new Boots(window, bootst1, 111, 11, 11, 11, 11);
            return boots;
        }
        if ((i) == 112) { // need to convert id to item
            boots = new Boots(window, bootst2, 112, 12, 12, 12, 12);
            return boots;
        }
        if ((i) == 113) { // need to convert id to item
            boots = new Boots(window, bootst3, 113, 13, 13, 13, 13);
            return boots;
        }
        if ((i) == 114) { // need to convert id to item
            boots = new Boots(window, bootst4, 114,14, 14, 14, 14);
            return boots;
        }
        if ((i) == 115) { // need to convert id to item
            boots = new Boots(window, bootst5, 115,  15, 15, 15, 15);
            return boots;
        }
        if ((i) == 116) { // need to convert id to item
            boots = new Boots(window, bootst6, 116, 16, 16, 16, 16);
            return boots;
        }
        if ((i) == 117) { // need to convert id to item
            boots = new Boots(window, bootst7, 117, 17, 17, 17, 17);
            return boots;
        }
        if ((i) == 118) { // need to convert id to item
            boots = new Boots(window, bootst8, 118, 18, 18, 18, 18);
            return boots;
        }
        if ((i) == 119) { // need to convert id to item
            boots = new Boots(window, bootst9, 119,  19, 19, 19, 19);
            return boots;
        }
        /////////
        if ((i) == 120) { // need to convert id to item
            shields = new Shields(window, shieldst0, 120, 1, 10, 1, 10);
            return shields;
        }
        if ((i) == 121) { // need to convert id to item
            shields = new Shields(window, shieldst1, 121, 2, 20, 2, 20);
            return shields;
        }
        if ((i) == 122) { // need to convert id to item
            shields = new Shields(window, shieldst2, 122, 3, 30, 3, 30);
            return shields;
        }
        if ((i) == 123) { // need to convert id to item
            shields = new Shields(window, shieldst3, 123, 4, 40, 4, 40);
            return shields;
        }
        if ((i) == 124) { // need to convert id to item
            shields = new Shields(window, shieldst4, 124, 5, 50, 5, 0);
            return shields;
        }
        if ((i) == 125) { // need to convert id to item
            shields = new Shields(window, shieldst5, 125, 6, 60, 6, 60);
            return shields;
        }
        if ((i) == 126) { // need to convert id to item
            shields = new Shields(window, shieldst6, 126, 7, 70, 7, 70);
            return shields;
        }
        if ((i) == 127) { // need to convert id to item
            shields = new Shields(window, shieldst7, 127, 8, 80, 8, 80);
            return shields;
        }
        if ((i) == 128) { // need to convert id to item
            shields = new Shields(window, shieldst8, 128, 9, 90, 9, 9);
            return shields;
        }
        if ((i) == 129) { // need to convert id to item
            shields = new Shields(window, shieldst9, 129, 10, 100, 10, 100);
            return shields;
        }
        //////

        item = new Items(window, blank, 0); // new game load starter inv (atm its empty but might want wooden tools?)
        return item;

    }

    public void eatCheck(Player player,Bar bar){
        for(int i=0;i<foods.size();i++){
            foods.get(i).eat(this,player,bar);
        }
    }

    /**
     * Deletes all items from inventory
     */
    public void del() {
        ids.delete();
    }

    public void addByID(int id) throws IOException {
        save();
        load();
        amountFree();
        //System.out.println(amountFree);
        if (amountFree > 0) {
            Items item = getItemById(id);
            if(item instanceof Food){
                foods.add((Food)item);
            }
            inventory.set(findFree(),item);
            save();
            load();
        }
    }

    /**
     * Accessor method
     *
     * @return The amount of free items in inventory
     */
    public int amountFree() {
        int count = 0;
        for (int i = 0; i < 70; i++) {
            if (inventory.get(i).getID() == 0) {
                count++;
            }
        }
        amountFree = count;
        return count;
    }


    /**
     * Removes all items from inventory
     */
    public void removeFree() {
        int i = 0;
        while (i < 70) {
            if (inventory.get(i).getID() == 0) {
                inventory.remove(i);
                i = 80;
            }
            i++;
        }
    }

    /**
     * Used to load items for the first game save.
     *
     * @param a
     */
    public void removeFree(int a) {
        Items item;
        int i = 0;
        while (i < 70) {
            if (inventory.get(i).getID() == a) {
                item = new Items(window, blank, 0); // new game load starter inv (atm its empty but might want wooden tools?)
                inventory.set(i, item);
                i = 80;
            }
            i++;
        }
    }


    /**
     * Find a free space in the inventory
     *
     * @return Free index in the inventory.
     */
    public int findFree() {
        int i = 0;
        while (i < 70) {
            if (inventory.get(i).getID() == 0) {
                return i;
            }
            i++;
        }
        return i;
    }

    public int returnIndex(int a) {
        int i = 0;
        while (i < 70) {
            if (inventory.get(i).getID() == a) {
                return i;
            }
            i++;
        }
        return i;
    }

    public int countItems(int a) {
        int i = 0;
        int count = 0;
        while (i < 70) {
            if (inventory.get(i).getID() == a) {
                count++;
            }
            i++;
        }
        return count;
    }

}

