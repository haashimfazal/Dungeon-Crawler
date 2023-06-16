package gui;

import gui.menu.LocationInformation;
import logic.level.Tier;
import logic.level.Tile;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import resources.Textures;

import javax.swing.text.Element;
import java.awt.*;

public class Renderer {
    /**
     * Empty constructor for Renderer.
     */
    public Renderer() {
    }

    /**
     * Renders logic.level and displays tiers.
     * 
     * @param tier   data of the logic.level
     * @param window to add tiles
     */
    public void renderLevel(Tier tier, RenderWindow window) {

        // Iterates through all tiers
        for (int y = 0; y < tier.getSizeY(); y++) {
            for (int x = 0; x < tier.getSizeX(); x++) {

                Texture texture = Textures.getTexture(tier.getTileAt(x, y).getName());
                Sprite sprite = Textures.toSprite(texture);
                sprite.setScale((float)GameScreen.getZoom(), (float)GameScreen.getZoom());

                // Draws a single tile on the screen
                float drawPosX = calcPosX(texture, tier.getTileAt(x, y));
                float drawPosY = calcPosY(texture, tier.getTileAt(x, y));
                sprite.setPosition(drawPosX, drawPosY);
                window.draw(sprite);

            }
        }
    }

    /**
     * Calculates the x position of the passed tile.
     * 
     * @param texture the current texture
     * @param tile    the current tile
     * @return the x position
     */
    private float calcPosX(Texture texture, Tile tile) {
        return tile.getPosX() * texture.getSize().x * (float) GameScreen.getZoom();
    }

    /**
     * Calculates the y position of the passed tile.
     * 
     * @param texture the current sprite
     * @param tile    the current tile
     * @return the y position
     */
    private float calcPosY(Texture texture, Tile tile) {
        return (float) (tile.getPosY() * texture.getSize().y * (float) GameScreen.getZoom());
    }



}