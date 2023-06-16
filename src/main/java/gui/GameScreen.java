package gui;

import logic.GameLogic;
import logic.level.Tier;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

import java.io.IOException;

public class GameScreen extends RenderWindow {

    public static RenderWindow window;
    private static double zoom;
    private static double initialZoom;
    private static int initialActualTileSize;
    private static int levelXTiles;
    private static int levelYTiles;
    public static int screenHeight;
    public static int screenWidth;
    private static GUI gui;
    /**
     * Constructor for GameScreen
     */
    public GameScreen() throws IOException {
        window = new RenderWindow();
        window.create(VideoMode.getDesktopMode(), "Dungeon crawler!", FULLSCREEN);

        window.setFramerateLimit(30);
        initialZoom = calculateZoom();

        Tier currentPlace = GameLogic.getCurrentPlace();
        initialActualTileSize = currentPlace.getActualTileSize();
        levelXTiles = currentPlace.getSizeX();
        levelYTiles = currentPlace.getSizeY();

        gui = new GUI(window);
    }

    /**
     * Accessor method
     *
     * @return The GameScreen's renderWindow.
     */
    public static RenderWindow getWindow() {
        return window;
    }

    /**
     * Calculates the zoom level depending on the screen size.
     *
     * @return zoom size
     */
    public static double calculateZoom() {

        double x = GameScreen.getWindow().getSize().x;
        double y = GameScreen.getWindow().getSize().y;

        double xSize = GameLogic.getCurrentPlace().getSizeX() * Tier.getTileSize(); // Size of the first level. But it's assumed that all levels will contain the same amount of tiles
        double ySize = GameLogic.getCurrentPlace().getSizeY() * Tier.getTileSize();

        double zoom1 = y / ySize * 0.90;
        double zoom2 = x / xSize; // Tiles vertically take 90% of the screen

        zoom = zoom1 > zoom2 ? zoom2 : zoom1;

        return zoom;
    }


    /**
     * Sets the zoom value.
     *
     * @param z value to be set
     */
    public static void setZoom(double z) {
        zoom = z;
    }

    /**
     * Access the zoom of the level.
     *
     * @return zoom value of the level
     */
    public static double getZoom() {
        return zoom;
    }

    /**
     * Access the initial zoom of the level.
     *
     * @return zoom value of the level
     */
    public static double getInitialZoom() {
        return initialZoom;
    }

    /**
     * Access the actual tile size of the first level.
     *
     * @return zoom value of the level
     */
    public static int getInitialActualTileSize() {
        return initialActualTileSize;
    }

    /**
     * Access to gui.
     *
     * @return gui
     */
    public static GUI getGui() {
        return gui;
    }

    /**
     * Accessor to the number of tiles in X of a level.
     *
     * @return number of tiles in X of a level
     */
    public static int getLevelXTiles() {
        return levelXTiles;
    }

    /**
     * Accessor to the number of tiles in X of a level.
     *
     * @return number of tiles in X of a level
     */
    public static int getLevelYTiles() {
        return levelYTiles;
    }

}
