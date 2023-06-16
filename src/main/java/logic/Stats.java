package logic;

import logic.Skills.*;
import logic.entities.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;


public class Stats implements Serializable {
    Mining mining = new Mining();
    WoodCutting woodCutting = new WoodCutting();
    Attack attack=new Attack();
    Protection prot=new Protection();
    Archery archery=new Archery();
    Defence defence=new Defence();

    File ids;
    ArrayList<Integer> invText = new ArrayList<Integer>();


    public Stats() throws IOException {
        ids = new File("Text files/statsFile");
        load();

    }
    public void loop(Player player) {

        player.setMining(mining.checkLevelUp());
        player.setWoodcutting(woodCutting.checkLevelUp());
        player.setArchery(archery.checkLevelUp());
        player.setAttack(attack.checkLevelUp());
        player.setDefence(defence.checkLevelUp());
        player.setProt(prot.checkLevelUp());
    }


    public void newGame() {
        invText.clear();
        for (int i = 0; i < 6; i++) {
            invText.add(1);
            invText.add(0);
            invText.add(1);
        }
        // System.out.println(invText);

        try {
            FileWriter fw = new FileWriter(ids, false);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < 18; i++) {
                output.write(invText.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("failed");
        }

    }

    /**
     * Saved current inventory
     */
    public void save() {
        invText.clear();
        invText.add(getMining().getSkill());
        invText.add((int)getMining().getXP());
        invText.add((int)getMining().getXPNeeded());

        invText.add(getWoodCutting().getSkill());
        invText.add((int)getWoodCutting().getXP());
        invText.add((int)getWoodCutting().getXPNeeded());

        invText.add(getArchery().getSkill());
        invText.add((int)getArchery().getXP());
        invText.add((int)getArchery().getXPNeeded());

        invText.add(getAttack().getSkill());
        invText.add((int)getAttack().getXP());
        invText.add((int)getAttack().getXPNeeded());

        invText.add(getProt().getSkill());
        invText.add((int)getProt().getXP());
        invText.add((int)getProt().getXPNeeded());

        invText.add(getDefence().getSkill());
        invText.add((int)getDefence().getXP());
        invText.add((int)getDefence().getXPNeeded());
        // System.out.println(invText);

        try {
            FileWriter fw = new FileWriter(ids, false);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < invText.size(); i++) {
                output.write(invText.get(i).toString() + "\n");
            }
            System.out.println("success");
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
//        System.out.println((float)invText.get(1));
        getMining().setSkill(invText.get(0));
        getMining().setXP((float)invText.get(1));
        getMining().setXPNeeded((float)invText.get(2));

        getWoodCutting().setSkill(invText.get(3));
        getWoodCutting().setXP((float)invText.get(4));
        getWoodCutting().setXPNeeded((float)invText.get(5));

        getArchery().setSkill(invText.get(6));
        getArchery().setXP((float)invText.get(7));
        getArchery().setXPNeeded((float)invText.get(8));

        getAttack().setSkill(invText.get(9));
        getAttack().setXP((float)invText.get(10));
        getAttack().setXPNeeded((float)invText.get(11));

        getProt().setSkill(invText.get(12));
        getProt().setXP((float)invText.get(13));
        getProt().setXPNeeded((float)invText.get(14));

        getDefence().setSkill(invText.get(15));
        getDefence().setXP((float)invText.get(16));
        getDefence().setXPNeeded((float)invText.get(17));

    }

    /**
     * Accessor method
     *
     * @return Instance of mining.
     */
    public Mining getMining() {
        return mining;
    }


    /**
     * Accessor method
     *
     * @return Instance of Woodcutting.
     */
    public WoodCutting getWoodCutting() {
        return woodCutting;
    }

    /**
     * Accessor method
     *
     * @return Instance of Woodcutting.
     */
    public Archery getArchery() {
        return archery;
    }

    /**
     * Accessor method
     *
     * @return Instance of Woodcutting.
     */
    public Attack getAttack() {
        return attack;
    }
    /**
     * Accessor method
     *
     * @return Instance of Woodcutting.
     */
    public Protection getProt() {
        return prot;
    }
    /**
     * Accessor method
     *
     * @return Instance of Woodcutting.
     */
    public Defence getDefence() {
        return defence;
    }


}
