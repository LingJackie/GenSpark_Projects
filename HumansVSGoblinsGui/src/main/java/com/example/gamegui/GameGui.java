package com.example.gamegui;

import eventHandlers.PlayerInputHandler;
import inventory.InventoryNode;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


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
        PlayerInputHandler plyrMvmt = new PlayerInputHandler(game1);
        scene.setOnKeyPressed(plyrMvmt);

//        // Detects num keys to select options during combat
//        CombatHandler cmbt = new CombatHandler(game1);
//        scene.setOnKeyPressed(cmbt);


        Label label = new Label("this is Pane example");

        // create a Pane
        Rectangle combat = new Rectangle(sceneWidth,sceneHeight);
        root.getChildren().add(combat);
        combat.setVisible(false);

    }

    public static void main(String[] args) {
        launch(args);
    }


}