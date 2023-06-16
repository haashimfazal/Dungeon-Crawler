package logic.level;

import gui.GameScreen;
import gui.Renderer;
import logic.level.Tile;

import java.io.Serializable;
import java.util.List;

public class Tier implements Serializable {

    public Tile[][] tier; // IA: leave it as public
    private static int tileSize = 32; // Size is the same for all tiles
    private String levelName;
    private String openDoorName;
    public int openedDoorX;
    public int openedDoorY;

    /**
     * Constructor for Tier
     *
     * @param level The level the tier will be on
     * @param floor The floor the tier will be on
     * @param tile  The tile the tier will have
     * @param door  The door the tier will have
     */
    public Tier(String[] level, String levelName, String floor, String tile, String door, String lockedDoor, String rope, String stairs, String ladder) {

        this.openedDoorX = 0;
        this.openedDoorX = 0; // the first level doesn't have a door

        tier = new Tile[level.length][];
        this.levelName = levelName;
        this.openDoorName = door;

        for (int y = 0; y < level.length; y++) {
            tier[y] = new Tile[level[y].length()];

            for (int x = 0; x < level[y].length(); x++) {
                switch (level[y].charAt(x)) {
                    case '#':
                        tier[y][x] = new Tile(tile, x, y);
                        tier[y][x].setType("wall");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '_':
                        tier[y][x] = new Tile(floor, x, y);
                        tier[y][x].setType("floors");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '/':
                        tier[y][x] = new Tile(door, x, y);
                        tier[y][x].setType("door");
                        tier[y][x].setLevelName(levelName);
                        if (x == 0) this.openedDoorY = y;
                        break;
                    case '%':
                        tier[y][x] = new Tile(lockedDoor, x, y);
                        tier[y][x].setType("lockedDoor");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '|':
                        tier[y][x] = new Tile(rope, x, y);
                        tier[y][x].setType("rope_up");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '!':
                        tier[y][x] = new Tile(rope, x, y);
                        tier[y][x].setType("rope_down");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '$':
                        tier[y][x] = new Tile(stairs, x, y);
                        tier[y][x].setType("stairs_up");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '&':
                        tier[y][x] = new Tile(stairs, x, y);
                        tier[y][x].setType("stairs_down");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '<':
                        tier[y][x] = new Tile(ladder, x, y);
                        tier[y][x].setType("ladder_up");
                        tier[y][x].setLevelName(levelName);
                        break;
                    case '>':
                        tier[y][x] = new Tile(ladder, x, y);
                        tier[y][x].setType("ladder_down");
                        tier[y][x].setLevelName(levelName);
                        break;
                }
            }
        }
    }

    /**
     * Returns the number of tiles vertically.
     *
     * @return the number of tiles vertically
     */
    public int getSizeY() { // IA: don't make it into static
        return tier.length;
    }

    /**
     * Returns the number of tiles horizontally.
     *
     * @return the number of tiles horizontally
     */
    public int getSizeX() { // IA: don't make it into static
        return tier[0].length;
    }

    /**
     * Returns the name of the current level.
     *
     * @return level name
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Access the size of this tile.
     *
     * @return size of this tile
     */
    public static int getTileSize() {
        return tileSize;
    }

    /**
     * Access the actual tile size displayed on the screen.
     *
     * @return actual tile size.
     */
    public static int getActualTileSize() {
        return (int) (GameScreen.getZoom() * tileSize);
    }

    /**
     * Returns the tile at x and y positions.
     *
     * @param x position
     * @param y position
     * @return the tile
     */
    public Tile getTileAt(int x, int y) {
        if (x >= 0 && y >= 0 && x < getSizeX() && y < getSizeY()) return tier[y][x];
        return null;
    }

    /**
     * Return the open door name.
     * @return
     */
    public String getOpenDoorName() {
        return openDoorName;
    }


}