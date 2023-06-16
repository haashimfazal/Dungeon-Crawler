package gui.menu;

import gui.GameScreen;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import java.io.IOException;
import java.nio.file.Paths;

public class LocationInformation {
    private RenderWindow spawnWindow;
    private Texture text = new Texture();
    private RectangleShape shapeForText;
    private boolean currentDisplayed = true;
    private String currentTextImage = "LEVEL_0";

    /**
     * Constructor for LocationInformation
     * @param spawnWindow RenderWindow instance that LocationInformation instance will be rendered in.
     */
    public LocationInformation(RenderWindow spawnWindow)
    {
        this.spawnWindow = spawnWindow;
        shapeForText = new RectangleShape(new Vector2f(spawnWindow.getSize().x, spawnWindow.getSize().y));
    }


    /**
     * Sets the text image, dependent on if File is valid.
     * @param textImage FileName containing text image.
     */
    public void setTextImage(String textImage)
    {
        try {
            text.loadFromFile(Paths.get("Images/FullScreenIcons/"+textImage+".png"));
            shapeForText.setTexture(text);
            currentTextImage = textImage;
        } catch (IOException e) {

            System.out.println("Couldn't find Images/FullScreenIcons/"+textImage);
        }
    }

    public void setLevel(String x)
    {
        currentTextImage = x;
//        System.out.println(currentTextImage);
        setTextImage(currentTextImage);
    }



    /**
     * Renders LocationInformation onto current RenderWindow instance
     */
    public boolean draw(String currentLevel)
    {
        if(!currentLevel.equals(currentTextImage))
            setLevel(currentLevel);
        if(Keyboard.isKeyPressed(Keyboard.Key.I))
        {
            spawnWindow.draw(shapeForText);
            return true;
        }
        return false;
    }
}
