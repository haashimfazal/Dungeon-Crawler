package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.jsfml.audio.Sound;
import org.jsfml.audio.SoundBuffer;
import org.jsfml.audio.SoundSource;

public class SoundManager {
    public static final SoundManager INSTANCE = new SoundManager();     // Singleton instance of the SoundManager
    public static final String SOUND_DIR = "Sounds/";                   // location of Sounds directory
    public static final String DATABASE_FILE = "SoundDatabase"; // name of the database file

    private HashMap<String, SoundBuffer> soundBuffers = new HashMap<String, SoundBuffer>(); // dictionary of sounds
    private Sound sound = new Sound();                                  // the main Sound object for playing sounds
    private String lastPlayed = null; // current/last played sound
    private boolean isSoundOn = true;


    /**
     * Constructor for the SoundManager class, reading in the sound database file and
     * subsequently loading each sound into the dictionary.
     */
    public SoundManager() {
        sound.setVolume(40);
        try {
            File soundDatabase = new File(SOUND_DIR + DATABASE_FILE);
            FileReader fileReader = new FileReader(soundDatabase);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] scanned = line.split(":");
                if (scanned.length != 2) {
                    throw new Exception("One of the lines in the sound database file is not formatted correctly.");
                }
                createSoundBuffer(scanned[0], scanned[1]);

            }
            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error occurred whilst trying to populate the sound database.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        createSoundBuffer("die", "Player/13gameover9NL.wav");
        createSoundBuffer("lvlup", "Player/12win1NL.wav");
        createSoundBuffer("axe", "Player/skills/205516__everheat__axe-barrel2.wav");
        createSoundBuffer("pickaxe", "Player/skills/61307__mv4824__pick-axe.wav");
        createSoundBuffer("eat", "Player/EAT1.wav");
        createSoundBuffer("enemyDeath", "death5.wav");
        createSoundBuffer("openGUI", "rattling.wav");

        createSoundBuffer("arrow", "909rim.wav");

    }

    /**
     * Plays a sound from the sound database corresponding to the given
     * reference string
     *
     * @param soundName a String containing the name of the desired sound
     */
    public void playSound(String soundName) {

        if (!isSoundOn) {
            return;
        }

        if (soundName == lastPlayed && sound.getStatus() == SoundSource.Status.PLAYING)
            return;

        if (!soundBuffers.containsKey(soundName))
            return;

        lastPlayed = soundName;
        sound.setBuffer(soundBuffers.get(soundName));
        sound.play();
    }

    public void setSound(boolean sound) {
        this.isSoundOn = sound;
    }

    /**
     * Adds a SoundBuffer into the classes dictionary so that it can be played later on
     *
     * @param reference the friendly name of the sound
     * @param path      the filename of the sound (excluding the root sounds directory)
     */
    private void createSoundBuffer(String reference, String path) {
        SoundBuffer soundBuffer = new SoundBuffer();
        try {
            soundBuffer.loadFromFile(Paths.get(SOUND_DIR + path));
            soundBuffers.put(reference, soundBuffer);

        } catch (IOException e) {
            System.err.println("Error occurred whilst trying to populate sound database.");
            System.err.println("Perhaps the file does not exist? (" + SOUND_DIR + path + ")");
            e.printStackTrace();
        }
    }
}
