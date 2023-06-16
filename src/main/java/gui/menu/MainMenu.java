package gui.menu;

import gui.GameScreen;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.*;
import org.jsfml.window.event.Event;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainMenu {

    private static final float BUTTON_SIZE_X = 347; // Width of button image
    private static final float BUTTON_SIZE_Y = 84; // Length of button image

    private RenderWindow window;
    private Mouse mouse;
    private Vector2i mousePosition;

    private float screenHeight = GameScreen.window.getSize().y;
    private float screenWidth = GameScreen.window.getSize().x;

    // Textures for the main menu
    private Texture logo = new Texture();
    private Texture background = new Texture();
    private Texture controls = new Texture();
    private Texture newGameButton = new Texture();
    private Texture newGameButton2 = new Texture();
    private Texture loadGameButton = new Texture();
    private Texture loadGameButton2 = new Texture();
    private Texture optionsButton = new Texture();
    private Texture optionsButton2 = new Texture();
    private Texture controlsButton = new Texture();
    private Texture controlsButton2 = new Texture();
    private Texture exitButton = new Texture();
    private Texture exitButton2 = new Texture();

    // Textures for the options menu
    private Texture soundOption = new Texture();
    private Texture soundOnHover = new Texture();
    private Texture soundOffHover = new Texture();
    private Texture soundOption2 = new Texture();
    private Texture easyDiff = new Texture();
    private Texture easyDiffHover = new Texture();
    private Texture medDiff = new Texture();
    private Texture medDiffHover = new Texture();
    private Texture hardDiff = new Texture();
    private Texture hardDiffHover = new Texture();
    private Texture optExit = new Texture();
    private Texture optExit2 = new Texture();

    private boolean newGame = false;
    private boolean loadGame = false;
    private boolean optionsMenu = false;
    private boolean controlsMenu = false;
    private boolean isSoundOn = true;
    private boolean onEasyDiff = false;
    private boolean onMedDiff = true;
    private boolean onHardDiff = false;
    private boolean randomBoolean = true;

    private int whichButton = 0;

    private String difficulty = "medium";


    public MainMenu(RenderWindow win) {
        this.window = win;
        this.draw();
    }

    public void drawMain() {
        ArrayList<Sprite> menuSprites = new ArrayList<>();

        Sprite gameLogo = new Sprite(logo);
        Sprite gameBackground = new Sprite(background);

        Sprite newButton = new Sprite(newGameButton);
        Sprite newButtonHover = new Sprite(newGameButton2);

        Sprite loadButton = new Sprite (loadGameButton);
        Sprite loadButtonHover = new Sprite (loadGameButton2);

        Sprite optButton = new Sprite (optionsButton);
        Sprite optButtonHover = new Sprite(optionsButton2);

        Sprite contButton = new Sprite(controlsButton);
        Sprite contButtonHover = new Sprite(controlsButton2);

        Sprite exButton = new Sprite(exitButton);
        Sprite exButtonHover = new Sprite(exitButton2);

        gameBackground.setPosition(0,0);
        gameLogo.setOrigin(Vector2f.div(new Vector2f(logo.getSize()), 2));
        gameLogo.setPosition(960, 200);

        newButton.setPosition(780, 360);
        loadButton.setPosition(780, 480);
        optButton.setPosition(780, 600);
        contButton.setPosition(780, 720);
        exButton.setPosition(780, 840);


        menuSprites.add(newButton);
        menuSprites.add(loadButton);
        menuSprites.add(optButton);
        menuSprites.add(contButton);
        menuSprites.add(exButton);

        window.draw(gameBackground);
        window.draw(gameLogo);


        /**
         * Checks which button the user is on, each number corresponds to the order of the button on the screen
         * e.g. new button = 0, load button = 1, options button = 2 etc.
         */
        switch(whichButton) {
            case 0:
                menuSprites.set(0, newButtonHover);
                newButtonHover.setPosition(780, 360);
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }
                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    this.newGame = true;
                    this.randomBoolean = true;
                }
                break;
            case 1:
                menuSprites.set(1, loadButtonHover);
                loadButtonHover.setPosition(780, 480);
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }
                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    this.newGame = true;
                    this.loadGame = true;
                }
                break;
            case 2:
                menuSprites.set(2, optButtonHover);
                optButtonHover.setPosition(780, 600);
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }
                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    this.optionsMenu = true;
                    this.whichButton = 5;
                    try {
                        TimeUnit.MILLISECONDS.sleep(125); // Makes sure key isn't pressed multiple times
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                menuSprites.set(3, contButtonHover);
                contButtonHover.setPosition(780, 720);
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }

                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    this.controlsMenu = true;
                }

                break;
            case 4:
                menuSprites.set(4, exButtonHover);
                exButtonHover.setPosition(780, 840);
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }

                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    window.close();
                }

                break;
        }

        if(optionsMenu) {
            this.drawOptionsMenu();
        }

        if(controlsMenu) {
            this.drawControlsMenu();
        }

        if(Keyboard.isKeyPressed(Keyboard.Key.DOWN)) {
            whichButton++;
            try {
                TimeUnit.MILLISECONDS.sleep(150); // Makes sure key isn't pressed multiple times
            } catch(Exception e) {
                e.printStackTrace();
            }
            if (whichButton > 4) {
                whichButton = 0;
            }
        }

        if(Keyboard.isKeyPressed(Keyboard.Key.UP)) {
            whichButton--;
            try {
                TimeUnit.MILLISECONDS.sleep(150); // Makes sure key isn't pressed multiple times
            } catch(Exception e) {
                e.printStackTrace();
            }
            if (whichButton < 0) {
                whichButton = 4;
            }
        }

    }

    /**
     public boolean alreadyAdded(int num) {
     int difference = whichButton - num;
     if(difference == 1) {
     return true;
     }
     return false;

     }
     **/

    public void drawOptionsMenu() {
        ArrayList<Sprite> menuSprites = new ArrayList<>();

        Sprite gameLogo = new Sprite(logo);
        Sprite gameBackground = new Sprite(background);
        Sprite optBack = new Sprite(optExit);
        Sprite soundOn = new Sprite(soundOption);
        Sprite soundOff = new Sprite(soundOption2);
        Sprite soundOnHov = new Sprite(soundOnHover);
        Sprite soundOffHov = new Sprite(soundOffHover);
        Sprite easyDifficulty = new Sprite(easyDiff);
        Sprite medDifficulty = new Sprite(medDiff);
        Sprite hardDifficulty = new Sprite(hardDiff);
        Sprite easyHover = new Sprite(easyDiffHover);
        Sprite medHover = new Sprite(medDiffHover);
        Sprite hardHover = new Sprite(hardDiffHover);

        gameBackground.setPosition(0,0);

        gameLogo.setOrigin(Vector2f.div(new Vector2f(logo.getSize()), 2));
        gameLogo.setPosition(960, 200);

        optBack.setOrigin(Vector2f.div(new Vector2f(optExit.getSize()), 2));
        optBack.setPosition(1920 / 2, 640);
        soundOn.setPosition(780, 360);
        soundOff.setPosition(780, 360);
        // soundOnHov.setPosition(780, 360);
        soundOffHov.setPosition(780, 360);

        easyDifficulty.setPosition(780, 500);
        medDifficulty.setPosition(780, 500);
        hardDifficulty.setPosition(780, 500);
        easyHover.setPosition(780, 500);
        medHover.setPosition(780, 500);
        hardHover.setPosition(780, 500);

        window.draw(gameBackground);
        window.draw(gameLogo);
        window.draw(optBack);

        menuSprites.add(soundOn);
        menuSprites.add(medDifficulty);

        switch(whichButton) {
            case 5:
                if(isSoundOn) {
                    menuSprites.set(0, soundOnHov);
                } else {
                    menuSprites.set(0, soundOffHov);
                }

                soundOnHov.setPosition(780, 360);

                for(Sprite s: menuSprites) {
                    window.draw(s);
                }

                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(125); // Makes sure key isn't pressed multiple times
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    if(isSoundOn) {
                        isSoundOn = false;
                    } else {
                        isSoundOn = true;
                    }
                }
                break;

            case 6:
                if(onMedDiff) {
                    menuSprites.set(1, medHover);
                } else if(onHardDiff) {
                    menuSprites.set(1, hardHover);
                    this.difficulty = "hard";
                } else if(onEasyDiff) {
                    menuSprites.set(1, easyHover);
                    this.difficulty = "easy";
                }
                for(Sprite s: menuSprites) {
                    window.draw(s);
                }

                if(Keyboard.isKeyPressed(Keyboard.Key.RETURN)) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(125); // Makes sure key isn't pressed multiple times
                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                    if(onMedDiff) {
                        onMedDiff = false;
                        onHardDiff = true;
                    } else if(onHardDiff) {
                        onHardDiff = false;
                        onEasyDiff = true;
                    } else if(onEasyDiff) {
                        onMedDiff = true;
                        onEasyDiff = false;
                    }
                }
                break;
        }

        if(Keyboard.isKeyPressed(Keyboard.Key.DOWN)) {
            whichButton++;
            try {
                TimeUnit.MILLISECONDS.sleep(125); // Makes sure key isn't pressed multiple times
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(Keyboard.isKeyPressed(Keyboard.Key.UP)) {
            whichButton--;
            try {
                TimeUnit.MILLISECONDS.sleep(125); // Makes sure key isn't pressed multiple times
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(whichButton < 5) {
            whichButton = 6;
        } else if (whichButton > 6) {
            whichButton = 5;
        }

        if(Keyboard.isKeyPressed(Keyboard.Key.BACKSPACE)) {
            this.optionsMenu = false;
            whichButton = 0;
            return;
        }


    }

    public void drawControlsMenu() {
        Sprite gameLogo = new Sprite(logo);
        Sprite gameBackground = new Sprite(background);
        Sprite controlMenu = new Sprite(controls);

        gameBackground.setPosition(0,0);

        gameLogo.setOrigin(Vector2f.div(new Vector2f(logo.getSize()), 2));
        gameLogo.setPosition(960, 200);


        controlMenu.setOrigin(Vector2f.div(new Vector2f(controls.getSize()), 2));
        controlMenu.setPosition(960, 580);

        window.draw(gameBackground);
        window.draw(gameLogo);
        window.draw(controlMenu);

        if(Keyboard.isKeyPressed(Keyboard.Key.BACKSPACE)) {
            this.controlsMenu = false;
            return;
        }
    }

    public void draw() {
        View view = new View(new FloatRect(0, 0, 1920, 1080));

        this.loadImages();

        while(window.isOpen()) {

            window.setView(view);

            this.drawMain();
            window.display();

            if(this.newGame) {
                break;
            }

            for(Event event: window.pollEvents()) {
                if(event.type == Event.Type.CLOSED) {
                    window.close();
                }
            }
        }
    }

    public boolean getSound() {
        return isSoundOn;
    }

    public void loadImages() {
        try {
            logo.loadFromFile(Paths.get("Images/main/logo.png"));
            background.loadFromFile(Paths.get("Images/main/background.png"));
            controls.loadFromFile(Paths.get("Images/main/controls.png"));
            newGameButton.loadFromFile(Paths.get("Images/buttons/new_game.png"));
            newGameButton2.loadFromFile(Paths.get("Images/buttons/new_game2.png"));
            loadGameButton.loadFromFile(Paths.get("Images/buttons/load_game.png"));
            loadGameButton2.loadFromFile(Paths.get("Images/buttons/load_game2.png"));
            optionsButton.loadFromFile(Paths.get("Images/buttons/options.png"));
            optionsButton2.loadFromFile(Paths.get("Images/buttons/options_2.png"));
            controlsButton.loadFromFile(Paths.get("Images/buttons/controls.png"));
            controlsButton2.loadFromFile(Paths.get("Images/buttons/controls_2.png"));
            exitButton.loadFromFile(Paths.get("Images/buttons/exit.png"));
            exitButton2.loadFromFile(Paths.get("Images/buttons/exit_2.png"));
            soundOption.loadFromFile(Paths.get("Images/buttons/sound_on.png"));
            soundOnHover.loadFromFile(Paths.get("Images/buttons/sound_on_hover.png"));
            soundOffHover.loadFromFile(Paths.get("Images/buttons/sound_off_hover.png"));
            soundOption2.loadFromFile(Paths.get("Images/buttons/sound_off.png"));
            easyDiff.loadFromFile(Paths.get("Images/buttons/difficulty_easy.png"));
            easyDiffHover.loadFromFile(Paths.get("Images/buttons/difficulty_easy_hover.png"));
            medDiff.loadFromFile(Paths.get("Images/buttons/difficulty_med.png"));
            medDiffHover.loadFromFile(Paths.get("Images/buttons/difficulty_med_hover.png"));
            hardDiff.loadFromFile(Paths.get("Images/buttons/difficulty_hard.png"));
            hardDiffHover.loadFromFile(Paths.get("Images/buttons/difficulty_hard_hover.png"));
            optExit.loadFromFile(Paths.get("Images/buttons/opt_exit.png"));
            optExit2.loadFromFile(Paths.get("Images/buttons/opt_exit2.png"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The purpose of this method is to check whether the mouse is within the coordinates of the button (the sprite image of the buttons)
     * @param button a button sprite
     * @return return true or false value depending on whether the mouse is within the button's coordinates

    public boolean isMouseOnButton(Sprite button) {
    float minX = button.getPosition().x;
    float minY = button.getPosition().y;
    float maxX = minX + BUTTON_SIZE_X;
    float maxY = minY + BUTTON_SIZE_Y;

    if((mousePosition.x > minX && mousePosition.x < maxX) && (mousePosition.y > minY && mousePosition.y < maxY)) {
    return true;
    } else {
    return false;
    }
    }*/

    public boolean getNewGame() {
        return newGame;
    }

    public boolean getLoadGame() {
        return loadGame;
    }

    public boolean getRandomBoolean() { return randomBoolean; }

    public String getDifficulty() {
        return this.difficulty;
    }


}

