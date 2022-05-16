package com.example.gamegui;

import eventHandlers.PlayerInputHandler;
import inventory.InventoryNode;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import static misc.Constants.SPRITE_DIMENSION;


public class GameGui extends Application {

    private final double sceneWidth = 960;
    private final double sceneHeight = 720;

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
        game1.spawnGoblinHorde(5);
        game1.spawnPlayer();



        //Fires up the GUI
        root = new Group();
        root.getChildren().add(game1.getMapGroup());
        Scene scene = new Scene( root, sceneWidth, sceneHeight);
        primaryStage.setScene( scene);
        primaryStage.setTitle("Humans vs Goblins");
        primaryStage.show();
//        game1.getMapGroup().setVisible(false);



        // Detects arrow keys for player movement and number keys for combat actions
        PlayerInputHandler plyrMvmt = new PlayerInputHandler(game1);
        scene.setOnKeyPressed(plyrMvmt);







//        Label label = new Label("this is Pane example");
//        // create a Pane
//        Rectangle combat = new Rectangle(sceneWidth,sceneHeight);
//        root.getChildren().add(combat);
//        combat.setVisible(false);
        CombatGui combatGui = new CombatGui((int)sceneWidth,(int)sceneHeight,game1.getPlayer(),game1.getGoblinHorde().get(0));
        root.getChildren().add(combatGui.getCombatScreen());
//        combatGui.getCombatScreen().setVisible(false);
    }

    public static void main(String[] args) {
        launch(args);
    }


}