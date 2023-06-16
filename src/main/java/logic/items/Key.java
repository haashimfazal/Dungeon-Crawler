package logic.items;

import gui.GameScreen;
import logic.GameLogic;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;

/**
 * Class representing keys.
 */
public class Key extends Items {

    /**
     * Constructor for a key.
     *
     * @param win Render window
     * @param t   texture of a key
     * @param keyId  of a key. Same as a level index
     */
    public Key(RenderWindow win, Texture t, int keyId) {
        super(win, t, keyId);


    }
}
