package resources;

import logic.level.Tier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Levels {

    static LinkedList<Tier> levels = new LinkedList<>();

    /**
     * Reads the levels file and adds all levels to the linked list.
     */
    public Levels() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("Text files/Levels"));
            String line = reader.readLine();

            while (line != null) {
                String[] levelArray = line.split(",");

                // Adds a logic.level to the levels array
                levels.push(
                        new Tier(Arrays.copyOfRange(levelArray, 8, levelArray.length), levelArray[0], levelArray[1], levelArray[2],
                                levelArray[3], levelArray[4], levelArray[5], levelArray[6], levelArray[7]));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reverses a linked list so index of a list element corresponds to the level
        Collections.reverse(levels);
    }

    /**
     * Returns a level at index i.
     * 
     * @param i index of a returned level
     * @return level at index i
     */
    public static Tier getLevel(int i) {
        return levels.get(i);
    }

    /**
     * Returns a linked list of all levels within a game
     * 
     * @return all levels
     */
    public LinkedList<Tier> getAllLevels() {
        return levels;
    }

    /**
     * Accessor method.
     * @return Returns the number of levels available.
     */
    public static int nrOfLevels(){
        return levels.size();
    }

}
