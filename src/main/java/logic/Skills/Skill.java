package logic.Skills;

import java.util.LinkedList;

import org.jsfml.window.*;
import org.jsfml.window.event.*;

import jdk.jfr.Percentage;
import resources.SoundManager;

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


public class Skill {
    private int skill = 1;
    private float xp = 1;
    private float xpNeeded = 10;
    private float progressPercentage;


    /**
     * Loads instances of skill from csv.
     */
    public Skill() {

        //add load from csv
    }

    /**
     * Checks if Skill can be levelled up.
     *
     * @return True if skill can be levelled up, false otherwise.
     */
    public int checkLevelUp() {
        progressPercentage=xp/xpNeeded*100;
        //System.out.println(skill);
        if (xp >= xpNeeded) {
            incSkill();
            xp = 0;
        }
        return skill;
    }


    /**
     * Accessor method
     *
     * @return Integer value of skill.
     */
    public int getSkill() {
        return skill;
    }
    /**
     * Accessor method
     *
     * @return float value of skill.
     */
    public float getXP() {
        return xp;
    }
        /**
     * Accessor method
     *
     * @return float value of skill.
     */
    public float getXPNeeded() {
        return xpNeeded;
    }

        /**
     * Accessor method
     *
     * @return Integer value of progress.
     */
    public int getPercentage() {
        return (int)progressPercentage;
    }

    /**
     * Modifier
     *
     * @param a New value of Skill.
     */
    public void setSkill(int a) {
        skill = a;
    }
    
    /**
     * Modifier
     *
     * @param a New value of Percentage.
     */
    public void setXP(float a) {
        xp = a;
    }
    
    /** 
    *
    * @param a New value of Percentage.
    */
   public void setXPNeeded(float a) {
       xpNeeded = a;
   }


    /**
     * Increases value of skill.
     */
    private void incSkill() {
        skill++;
        xpNeeded = xpNeeded + (xpNeeded * skill / 10);
        SoundManager.INSTANCE.playSound("lvlup");

    }

    /**
     * Increases xP.
     *
     * @param a Amount xP will be increased by.
     */
    public void incXP(float a) {
        xp += a;
    }


}
