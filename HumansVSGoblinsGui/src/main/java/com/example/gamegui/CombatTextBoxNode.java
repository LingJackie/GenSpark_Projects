package com.example.gamegui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class CombatTextBoxNode extends StackPane {

    private Label label;
    private Rectangle textBox;// Tile that's going to be displayed



    public void setTileLabel(String text){
        label.setText(text);
    }
    // Takes in a hex value
    public void setTileColor(String color){
        textBox.setFill(Color.web(color));
    }

    /*
        Constructor
        size -> Dimensions of the tile i.e. if size is 25 then tile would be 25x25
        x,y -> Coords on the grid
     */
    public CombatTextBoxNode(int x, int y, double width, double height, String text){

        textBox = new Rectangle(width,height);
        textBox.setFill(Color.WHITE);
        textBox.setStroke(Color.BLACK);

        // create label
        this.label = new Label(text);


        // set position
        setTranslateX(x);
        setTranslateY(y);
        getChildren().addAll(textBox,this.label);
    }


}
