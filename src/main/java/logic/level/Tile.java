package logic.level;

import java.io.Serializable;

public class Tile implements Serializable {

    private String name;
    private int posX;
    private int posY;
    private String type;
    public static int size; // TODO: size is the same for all tiles
    private static String levelName;

    /**
     * Constructor for tile
     * @param name Name of tile
     * @param x xPosition of Tile
     * @param y yPosition of Tile
     */
    public Tile(String name, int x, int y) {
        this.name = name;
        this.posX = x;
        this.posY = y;
        this.size = 32; // Size is 32 pixels of every tile
    }

    /**
     * Sets the name of this tile.
     * 
     * @param name name of the tile.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Determines the name of this tile.
     * 
     * @return the name of the tile
     */
    public String getName() {
        return name;
    }

    /**
     * Determines the x position of this tile.
     * 
     * @return the x position of the tile
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Determines the y position of this tile.
     * 
     * @return the y position of the tile
     */
    public int getPosY() {
        return posY;
    }


    /**
     * Sets the type of the tile.
     * @param type of the tile
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Access the type of the tile.
     * @return type of the tile
     */
    public String getType() {
        return type;
    }

    /**
     * Access the size of this tile.
     * @return size of this tile
     */
    public int getSize(){
        return size;
    }

    /**
     * Returns the name of the current level.
     * @return level name
     */
    public String getLevelName(){
        return levelName;
    }

    public void setLevelName(String name) {
        levelName = name;
    }

    public void changeTile(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
