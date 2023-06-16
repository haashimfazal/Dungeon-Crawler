package gui.menu;

import gui.GameScreen;
import logic.GameLogic;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Maps extends MiniMenu {

    static List<Texture> mapTextures = new LinkedList<>();
    static List<Map> maps = new LinkedList<>();

    public Maps(RenderWindow win, Font font) throws IOException {
        super(win, font);

        loadMaps(font);
    }
    /**
     * Loads all maps.
     *
     * @param font
     * @throws IOException
     */
    private void loadMaps(Font font) throws IOException {

        File dir = new File("Images/G1 - GUI/Maps");

        int count = 0;
        for (File file : dir.listFiles()) {

            Texture mapTexture = new Texture();
            Map mMap;

            mapTexture.loadFromFile(Paths.get(file.getAbsolutePath()));
            mMap = new Map(window, mapTexture, font);

            mapTextures.add(count, mapTexture);
            maps.add(count, mMap);
            count++;
        }
    }

    /**
     * Accessor to the current map.
     *
     * @return current map
     */
    public static Map getCurrentMap() {
        return maps.get(GameLogic.getKeyCount());
    }

    /**
     * Accessor to the current map texture.
     *
     * @return current map texture
     */
    public static Texture getCurrentMapTexture() {
        return mapTextures.get(GameLogic.getKeyCount());
    }

    /**
     * Accessor to the current map sprite.
     *
     * @return current map sprite
     */
    public static Sprite getCurrentSprite() {

        Sprite map = new Sprite(getCurrentMapTexture());
        float scale = GameScreen.getWindow().getSize().x / map.getGlobalBounds().width;
        map.setScale(scale, scale);

        return map;
    }

}
