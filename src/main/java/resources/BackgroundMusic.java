package resources;

import org.jsfml.system.Time;

import java.io.IOException;
import java.nio.file.Paths;


public class BackgroundMusic {

    private static final BackgroundMusic INSTANCE = new BackgroundMusic();
    private org.jsfml.audio.Music sound = new org.jsfml.audio.Music();
    private String currentFile;

    /**
     * Private constructor, prevents more than one instance of Background music and therefore overlapping themes.
     */
    private BackgroundMusic()
    {
        sound.setVolume(30);
    }

    /**
    * Plays a sound of file passed.
     * All files must be present in Sound/ directory, don't need to add ".wav"
     * @param filename Name of sound file.
     */
    public void playSound(String filename)
    {
        if(filename.equals(currentFile))
        {
            return;
        }

            try {
                sound.openFromFile(Paths.get("Sounds/" + filename + ".wav"));
                currentFile = filename;
            } catch (IOException e) {
                System.out.println("SOUND FILE NOT FOUND");
            }

        if(sound.getPlayingOffset() == Time.ZERO)
        {

            sound.play();
            sound.setLoop(true);
        }
    }

    /**
     * Used in place of a constructor, insures the same single instance is everywhere in the program.
     * @return Instance of BackgroundMusic
     */
    public static BackgroundMusic getInstance() {
        return INSTANCE;
    }




}




