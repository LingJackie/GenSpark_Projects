package com.example.gamegui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 50;
    private int m = 25;

//    double gridWidth = sceneWidth / n;
//    double gridHeight = sceneHeight / m;
    double gridWidth = 25;
    double gridHeight = 25;



    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        GameWorld map =  new GameWorld(50,25,25);

        // initialize playfield
        for( int i=0; i < map.length(); i++) {
            for( int j=0; j < map.width(); j++) {

                // add node to group
                root.getChildren().add( map.getTile(i,j));


            }
        }



        Scene scene = new Scene( root, sceneWidth, sceneHeight);

        primaryStage.setScene( scene);
        primaryStage.show();

        Rectangle r = new Rectangle();
        r.setX(225);
        r.setY(225);
        r.setWidth(25);
        r.setHeight(25);
        root.getChildren().add(r);
        Image img = new Image(getClass().getResourceAsStream("player.png"));
        r.setFill(new ImagePattern(img));



//        Rectangle r3 = new Rectangle();
//        r3.setX(400);
//        r3.setY(400);
//        r3.setWidth(25);
//        r3.setHeight(25);
//        root.getChildren().add(r3);
//        Image img3 = new Image(getClass().getResourceAsStream("goblin.png"));
//        r3.setFill(new ImagePattern(img3));

        Rectangle r4 = new Rectangle();
        r4.setX(500);
        r4.setY(500);
        r4.setWidth(50);
        r4.setHeight(50);
        root.getChildren().add(r4);
        Image img4 = new Image(getClass().getResourceAsStream("jacob.png"));
        r4.setFill(new ImagePattern(img4));


        Rectangle r5 = new Rectangle();
        r5.setX(100);
        r5.setY(100);
        r5.setWidth(50);
        r5.setHeight(50);
        root.getChildren().add(r5);
        r5.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("jacob.png"))));
        

        Rectangle r2 = new Rectangle();
        r2.setX(10);
        r2.setY(10);
        r2.setWidth(100);
        r2.setHeight(25);
        root.getChildren().add(r2);
        r2.setFill(Color.RED);



    }

    public static void main(String[] args) {
        launch(args);
    }


}