package logic;

import logic.level.Tier;
import resources.Levels;
import resources.Rooms;
import resources.Textures;

import java.util.LinkedList;

public class GameLogic {
    private static Tier currentLevel;
    private static Levels levels;
    private static Rooms rooms;
    private static int levelIndex;
    private static LinkedList<Integer> collectedKeys = new LinkedList<Integer>(); // List of unlocked levels
    private static int keyCount;
    private static boolean playLevel;
    private static Tier currentRoom;


    /**
     * Initiates the game.
     */
    public static void startGame() {
        Textures.init();

        levels = new Levels();
        rooms = new Rooms();
        currentLevel = levels.getLevel(0); // The level to be displayed
        currentRoom = rooms.getRoomOfLevel(0); // The level to be displayed
        playLevel = true;
        levelIndex = 0;
        keyCount = 0;
    }

    /**
     * Accessor to the current place (room or level).
     *
     * @return current level
     */
    public static Tier getCurrentPlace() {
        return playLevel == true ? currentLevel : currentRoom;
    }

    /**
     * Accessor to the current level.
     *
     * @return current level
     */
    public static Tier getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Accessor to the current room.
     *
     * @return current room
     */
    public static Tier getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Accessor to the number of tiles horizontally.
     *
     * @return number of tiles horizontally.
     */
    public static int getCurrentPlaceSizeX() {
        return playLevel == true ? currentLevel.tier[0].length : currentRoom.tier[0].length;
    }

    /**
     * Accessor to the number of tiles vertically.
     *
     * @return number of tiles vertically.
     */
    public static int getCurrentPlaceSizeY() {
        return playLevel == true ? currentLevel.tier.length : currentRoom.tier.length;
    }

    /**
     * Changes the current level.
     *
     * @param i index of the current level
     */
    public static void setCurrentLevel(int i) {
        currentLevel = levels.getLevel(i);
        levelIndex = i;
//        System.out.println(currentLevel.getLevelName());
    }

    public static void setCurrentPlace(Tier level) {
        if (playLevel == true) {
            currentLevel = level;

        } else {
            currentRoom = level;
        }
    }

    /**
     * Moves player to the next level.
     */
    public static void setToNextLevel() {
        levelIndex += 1;
        setCurrentLevel(levelIndex);
    }

    /**
     * Moves player to the previous level.
     */
    public static void setToPrevLevel() {
        levelIndex -= 1;
        setCurrentLevel(levelIndex);
    }

    /**
     * Adds the key to the list of collected keys.
     *
     * @param id of a key.
     */
    public static void addKeyToTheList(int id) {
        collectedKeys.add(id);
    }

    /**
     * Access the list of key IDs.
     *
     * @return list of key IDs
     */
    public static LinkedList<Integer> getCollectedKeys() {
        return collectedKeys;
    }

    /**
     * Access the current level index.
     *
     * @return current level index
     */
    public static int getCurrentLevelIndex() {
        return levelIndex;
    }

    /**
     * Unlocks the next level.
     */
    public static void unlockNextLevel() {
        Tier tier = GameLogic.getCurrentLevel();
        int xPosition = tier.getSizeX() - 1;
        for (int i = 0; i < tier.getSizeY(); i++) {
            if (tier.getTileAt(xPosition, i).getType() == "lockedDoor") {
                tier.getTileAt(xPosition, i).changeTile(tier.getOpenDoorName(), "door");
            }
        }
    }

    /**
     * Determines if room or level has to be rendered.
     *
     * @return boolean variable if the level has to be rendered
     */
    public static boolean isPlayLevel() {
        return playLevel;
    }

    /**
     * Sets the boolean value if room or level has to be rendered.
     * Recalculates zoom as a different room can have different number of tiles.
     *
     * @param ifPlay boolean variable to set if the level has to be rendered
     */
    public static void setPlayLevel(boolean ifPlay) {
        playLevel = ifPlay;
    }

    /**
     * Increments key count when a key is collected.
     */
    public static void incrementKeyCount() {
        keyCount++;
    }

    /**
     * Accessor to the key count that shows how many levels are unlocked.
     *
     * @return key count of unlocked levels
     */
    public static int getKeyCount() {
        return keyCount;
    }


}
