package com.example.gamegui;

import eventHandlers.PlayerMovementHandler;
import inventory.InventoryNode;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import misc.Dice;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.*;



public class GameGui extends Application {

    private final double sceneWidth = 1024;
    private final double sceneHeight = 768;

    private final int n = 50;
    private final int m = 28;
    private Group root;

    public void startInventory(Stage primaryStage){
        Group inventoryRoot = new Group();
        Label secondLabel = new Label("I'm a Label on new Window");


        inventoryRoot.getChildren().add(secondLabel);

        Scene secondScene = new Scene(inventoryRoot, 230, 100);

        // New window (Stage)
        Stage inventoryWindow = new Stage();
        inventoryWindow.setTitle("Inventory");
        inventoryWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        inventoryWindow.setX(primaryStage.getX() + 200);
        inventoryWindow.setY(primaryStage.getY() + 100);

        inventoryWindow.show();

        for(int i =0;i<5;i++){
            for(int j = 0; j<6;j++){
                inventoryRoot.getChildren().add( new InventoryNode("hmm",i,j,75));
            }
        }
    }


    @Override
    public void start(Stage primaryStage) {
        HVG game1 = new HVG();
        game1.setUpGameWorldGUI();
        game1.spawnPlayer();
        game1.spawnGoblinHorde(5);

//        Human player = game1.getPlayer();
//        TileNode tile = game1.getGameWorld().getTile(24, 28);


        root = new Group();
        root.getChildren().add(game1.getMapGroup());
        Scene scene = new Scene( root, sceneWidth, sceneHeight);
        primaryStage.setScene( scene);
        primaryStage.setTitle("Humans vs Goblins");
        primaryStage.show();
//        game1.getMapGroup().setVisible(false);


        Rectangle r2 = new Rectangle();
        r2.setX(10);
        r2.setY(10);
        r2.setWidth(100);
        r2.setHeight(25);
        root.getChildren().add(r2);
        r2.setFill(Color.RED);


        // Detects arrow keys for player movement
        PlayerMovementHandler stuff = new PlayerMovementHandler(game1);
        scene.setOnKeyPressed(stuff);





    }

    public static void main(String[] args) {
        launch(args);
    }


}