package resources;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Textures {

    private static HashMap<String, Texture> dungeonTiresTextures;

    /**
     * Initialises textures by images.
     */
    public static void init() {

        // Initialises dungeon tires
        dungeonTiresTextures = new HashMap<String, Texture>();

        File folder = new File("Images/Dungeon tiers");

        for (File file : folder.listFiles()) {
            try {
                Texture texture = new Texture();
                texture.loadFromFile(file.toPath());
                dungeonTiresTextures.put(file.getName().replaceAll(".png", ""), texture);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a texture of the image.
     *
     * @param name of the image
     * @return
     */
    public static Texture getTexture(String name) {
        Texture texture = dungeonTiresTextures.get(name);
        if (texture != null)
            return texture;
        else
            return dungeonTiresTextures.get("error");
    }
    /**
     * Converts texture to sprite.
     *
     * @param texture to be converted
     * @return sprite
     */
    public static Sprite toSprite(Texture texture) {
        Sprite sprite = new Sprite();
        sprite.setTexture(texture);
        return sprite;
    }
}
