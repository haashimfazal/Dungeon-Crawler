package logic;

import gui.menu.TutorialMenu;
import logic.entities.Player;
import logic.entities.PlayerEntity;
import logic.items.Items;
import logic.level.Tier;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class SaveGame {
    private Tier currentLevel;
    private Stats playerStats;
    private Player player;
    private int playerX;
    private int playerY;
    private LinkedList<Items> currentInventory;
    private String locationsPath = "SaveData/integers.txt";
    private String playerDataPath = "SaveData/playerData.txt";
    //private Inv invent = new Inv();

    public SaveGame() {
    }

    public void saveToFile() {
        player = PlayerEntity.getPlayer();
        currentLevel = GameLogic.getCurrentPlace();
        playerStats = player.getStats();
        //invent.save();

        try {
            FileOutputStream fileOut = new FileOutputStream("SaveData/save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(currentLevel);
            out.writeObject(playerStats);
            this.savePlayerData();
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void savePlayerData() {
        try {
            int currentHealth = Math.round(player.getHealth());

            FileWriter myWriter = new FileWriter(locationsPath);
            FileWriter playerWriter = new FileWriter(playerDataPath);

            String xPosition = Integer.toString(player.getXPosition()) + "\n";
            String yPosition = Integer.toString(player.getYPosition()) + "\n";
            String health = Integer.toString(currentHealth) + "\n";

            myWriter.write(xPosition + yPosition + health);
            myWriter.close();
            playerStats.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getPlayerData() {
        int[] playerData = new int[3];
        int count = 0;
        try {
            File myObj = new File(locationsPath);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()) {
                int data = Integer.parseInt(myReader.nextLine());
                playerData[count] = data;
                count++;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return playerData;
    }

    public void loadFromFile() {
        TutorialMenu.inLoadState(true);
        Tier loadLevel;
        //Stats playerStats = null;
        Player loadPlayer = null;
        Player currentPlayer = PlayerEntity.getPlayer();
        int[] playerData = this.getPlayerData();
        try {
            FileInputStream fileIn = new FileInputStream("SaveData/save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            loadLevel = (Tier) in.readObject();
            //playerStats = (Stats) in.readObject();
            // loadPlayer = (Player) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            System.out.println("Could not be loaded. New game has been loaded instead.");
            return;
        } catch(ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        GameLogic.setCurrentPlace(loadLevel); // loads the level
        currentPlayer.setXPosition(playerData[0]); // loads the x location of the player
        currentPlayer.setYPosition(playerData[1]); // loads the y location of the player
        currentPlayer.setHealth(playerData[2]); // loads the health of the player
        //try {
            // playerStats.load();
        //} catch (Exception e) {
            //System.out.println("Not able to load player stats");
        //}
    }
}
