import gui.GameScreen;
import logic.items.FloorItem;
import logic.GameLogic;
import logic.entities.EnemyCluster;
import logic.entities.PlayerEntity;
import logic.items.Rock;
import logic.items.Tree;
import resources.ScreenElementResources;
import resources.ScreenElements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RenderItems {
    static Map<String, ScreenElements> levelElements = new HashMap<>();
    static Map<String, ScreenElements> roomElements = new HashMap<>();

    public RenderItems() throws IOException {

        new ScreenElementResources();
        levelElements.put("LEVEL_1", ScreenElementResources.LEVEL_1());
        levelElements.put("LEVEL_2", ScreenElementResources.LEVEL_2());
        levelElements.put("LEVEL_3", ScreenElementResources.LEVEL_3());
        levelElements.put("LEVEL_4", ScreenElementResources.LEVEL_4());
        levelElements.put("LEVEL_5", ScreenElementResources.LEVEL_5());
        levelElements.put("LEVEL_6", ScreenElementResources.LEVEL_6());
        levelElements.put("LEVEL_7", ScreenElementResources.LEVEL_7());
        levelElements.put("LEVEL_8", ScreenElementResources.LEVEL_8());
        levelElements.put("LEVEL_9", ScreenElementResources.LEVEL_9());
        levelElements.put("LEVEL_10", ScreenElementResources.LEVEL_10());

        roomElements.put("ROOM_1", ScreenElementResources.ROOM_1());
        roomElements.put("ROOM_2", ScreenElementResources.ROOM_2());
        roomElements.put("ROOM_3", ScreenElementResources.ROOM_3());
        roomElements.put("ROOM_4", ScreenElementResources.ROOM_4());
        roomElements.put("ROOM_5", ScreenElementResources.ROOM_5());
        roomElements.put("ROOM_6", ScreenElementResources.ROOM_6());
        roomElements.put("ROOM_7", ScreenElementResources.ROOM_7());
        roomElements.put("ROOM_8", ScreenElementResources.ROOM_8());
        roomElements.put("ROOM_9", ScreenElementResources.ROOM_9());
        roomElements.put("ROOM_10", ScreenElementResources.ROOM_10());
    }

    /**
     * Renders items on the screen depending on the level.
     */
    public static void renderLevelItems() throws IOException{
        String levelName = GameLogic.getCurrentPlace().getLevelName();
        ScreenElements list = GameLogic.isPlayLevel() ? levelElements.get(levelName) : roomElements.get(levelName);

        if(GameLogic.isPlayLevel() && !list.getBoss().checkStatus())
        {
            if(!list.getBossKilled())
            {
                list.bossKilled();
                list.getNPC().updateDialogue();
            }

        }

        for (EnemyCluster ec : list.getEnemies()) {
            ec.draw(PlayerEntity.getPlayer(), GameScreen.getGui().getInven(),list.getChallenge());
        }

        for (Tree tree : list.getTrees()) {
            tree.draw(GameScreen.getGui().getBar(), GameScreen.getGui().getInven(), PlayerEntity.getPlayer(), list.getChallenge());
        }

        for (Rock rock : list.getRocks()) {
            rock.draw(GameScreen.getGui().getBar(), GameScreen.getGui().getInven(), PlayerEntity.getPlayer(), list.getChallenge());
        }

        for (FloorItem floorItem : list.getFloorItems()) {
            floorItem.draw(PlayerEntity.getPlayer(), GameScreen.getGui().getInven());
        }

        if (GameLogic.isPlayLevel()) {
            list.getChallenge().draw(GameScreen.getGui().getBar(),GameScreen.getGui().getInven());
            list.getNPC().draw(PlayerEntity.getPlayer(),GameScreen.getGui());
        }
    }
}
