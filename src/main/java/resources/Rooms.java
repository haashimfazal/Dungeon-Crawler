package resources;

import logic.GameLogic;
import logic.level.Tier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Rooms {

    static LinkedList<Tier> rooms = new LinkedList<>();

    public Rooms() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("Text files/Rooms"));
            String line = reader.readLine();

            while (line != null) {
                String[] levelArray = line.split(",");

                rooms.push(
                        new Tier(Arrays.copyOfRange(levelArray, 8, levelArray.length), levelArray[0], levelArray[1], levelArray[2],
                                levelArray[3], levelArray[4], levelArray[5], levelArray[6], levelArray[7]));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reverses a linked list so index of a list element corresponds to the level
        Collections.reverse(rooms);

    }

    /**
     * Returns a room at index i.
     *
     * @param i index of a returned room
     * @return room at index i
     */
    public Tier getRoom(int i) {
        return (Tier) rooms.get(GameLogic.getCurrentLevelIndex());
    }


    /**
     * Returns a room of a current level at index i.
     *
     * @param i index of a returned room
     * @return room at index i
     */
    public static Tier getRoomOfLevel(int i) {
        return rooms.get(GameLogic.getCurrentLevelIndex());
    }

}
