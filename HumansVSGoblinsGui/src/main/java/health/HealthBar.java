package health;

import com.example.gamegui.Actor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class HealthBar {

    ArrayList<HealthNode> worldHealthBar;
    ArrayList<HealthNode> combatHealthBar;
    Group worldHealthBarGui;
    Group combatHealthBarGui;

    public Group getWorldHealthBarGui() {return worldHealthBarGui;}
    public Group getCombatHealthBarGui() {return combatHealthBarGui;}

    // size -> sprite size
    public HealthBar(int size, Actor someDude){
        worldHealthBar = new ArrayList<HealthNode>();
        worldHealthBarGui = new Group();

        // Adds 1 heart for every 10 points of health
        for(int i =0;i<someDude.getMaxHealth()/10;i++){
            worldHealthBar.add(new HealthNode((i*size)+15,15, size));
            worldHealthBarGui.getChildren().add(worldHealthBar.get(i));
        }
    }
    /*
    Example:
    Health => 36/50
    tmpNum = 3.6
    numFullHearts = 3;
    tmpNum2 = .6
     */
    public void updateHealthBar(Actor someDude){
        double tmpNum = someDude.getCurrHealth()/10.0;
        int numFullHearts = (int)tmpNum;
        double tmpNum2 = tmpNum - numFullHearts;

        for(int i = numFullHearts; i< worldHealthBar.size();i++){
            if(i == numFullHearts && tmpNum2 != 0){
                worldHealthBar.get(i).setHeartState("half");
                continue;
            }
            worldHealthBar.get(i).setHeartState("empty");

        }
    }
}
