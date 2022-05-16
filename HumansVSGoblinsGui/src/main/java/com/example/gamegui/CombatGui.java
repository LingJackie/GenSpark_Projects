package com.example.gamegui;

import health.HealthBar;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


import java.io.FileNotFoundException;

import static misc.Constants.SPRITE_DIMENSION;

public class CombatGui {

    private int sceneWidth;
    private int sceneHeight;

    private Group combatScreen;
    private Rectangle background;

    private Rectangle playerCombatSprite;
    private Rectangle goblinCombatSprite;

    private Rectangle bottomBar;

    CombatTextBoxNode textBox;
    CombatTextBoxNode actionBox1;
    CombatTextBoxNode actionBox2;
    CombatTextBoxNode actionBox3;
    CombatTextBoxNode actionBox4;


    // Returns the GUI Group (Add this to the scene root)
    public Group getCombatScreen()  {return combatScreen;}


    public CombatGui(int width, int height, Human player, Goblin goblin){
        sceneHeight = height;
        sceneWidth = width;
        combatScreen = new Group();
        background = new Rectangle(width,height);


        bottomBar = new Rectangle(0,sceneHeight-(sceneHeight/4), sceneWidth,sceneHeight/4);


//        textPane =new StackPane();
//        textBox = new Rectangle(0,sceneHeight-(sceneHeight/4)-10, sceneWidth/2,(sceneHeight/4)-20);
//        text = new Text("What will jackie do?");

        // Adds background
        try{ setSprite("battle_background.jpg",background);
        }catch(Exception e){ background.setFill(Color.AQUA); }
        combatScreen.getChildren().add(background);

        // Adds player combat sprite
        playerCombatSprite = new Rectangle(75,200,425,425);
        try{ setSprite("player_combat.png",playerCombatSprite);
        }catch(Exception e){ playerCombatSprite.setFill(Color.BLACK); }
        combatScreen.getChildren().add(playerCombatSprite);

        HealthBar playerHealthBar = new HealthBar(225,175,SPRITE_DIMENSION, player);
        combatScreen.getChildren().add(playerHealthBar.getWorldHealthBarGui());


        // Adds goblin combat sprite
        goblinCombatSprite = new Rectangle(sceneWidth-375,125,300,300);
        try{ setSprite("goblin_combat.png",goblinCombatSprite);
        }catch(Exception e){ goblinCombatSprite.setFill(Color.BLACK); }
        combatScreen.getChildren().add(goblinCombatSprite);

        HealthBar goblinHealthBar = new HealthBar(sceneWidth-275,425,SPRITE_DIMENSION, goblin);
        combatScreen.getChildren().add(goblinHealthBar.getWorldHealthBarGui());

        // Adds bottom bar
        bottomBar.setFill(Color.GREY);
        combatScreen.getChildren().add(bottomBar);

        // Adds text box
        textBox = new CombatTextBoxNode(10, sceneHeight-(sceneHeight/4)+10, (sceneWidth/2)-20,(sceneHeight/4)-20, "What will Jackie do?");
        combatScreen.getChildren().add(textBox);

        // Adds action boxes
        actionBox1 = new CombatTextBoxNode((sceneWidth/2)+5, sceneHeight-(sceneHeight/4)+10, (sceneWidth/4)-25,(sceneHeight/8)-30,"[1] ATTACK");
        combatScreen.getChildren().add(actionBox1);
        actionBox2 = new CombatTextBoxNode((sceneWidth*3/4)+5, sceneHeight-(sceneHeight/4)+10, (sceneWidth/4)-25,(sceneHeight/8)-30,"[2] INVENTORY");
        combatScreen.getChildren().add(actionBox2);

        actionBox3 = new CombatTextBoxNode((sceneWidth/2)+5, sceneHeight-(sceneHeight/8)+10, (sceneWidth/4)-25,(sceneHeight/8)-30,"[3] HEAL");
        combatScreen.getChildren().add(actionBox3);
        actionBox4 = new CombatTextBoxNode((sceneWidth*3/4)+5, sceneHeight-(sceneHeight/8)+10, (sceneWidth/4)-25,(sceneHeight/8)-30,"[4] LEAVE");
        combatScreen.getChildren().add(actionBox4);



    }
    private void setSprite(String imgName, Rectangle rec) throws FileNotFoundException {
        Image img = new Image(getClass().getResourceAsStream(imgName));
        rec.setFill(new ImagePattern(img));
    }
}
