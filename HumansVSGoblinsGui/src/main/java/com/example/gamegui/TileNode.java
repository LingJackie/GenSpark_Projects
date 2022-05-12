package com.example.gamegui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class TileNode extends StackPane {

    Label tileLabel;
    Rectangle landTile;// Tile that's going to be displayed

    public void setTileLabel(String label){
        tileLabel.setText(label);
    }
    // Takes in a hex value
    public void setTileColor(String color){
        landTile.setFill(Color.web(color));
    }
    public void setTileTexture(Image texture){
        landTile.setFill(new ImagePattern(texture));
    }

    /*
        Constructor
        size -> Dimensions of the tile i.e. if size is 25 then tile would be 25x25
        x,y -> Coords on the grid
     */
    public TileNode(String tileName, double x, double y, int size){

        landTile = new Rectangle(size,size);
        landTile.setFill(Color.BLACK);

        // create label
        this.tileLabel = new Label(tileName);


        // set position
        setTranslateX(x*size);
        setTranslateY(y*size);
        getChildren().addAll(landTile,tileLabel);
    }

    @Override
    public String toString() {
        return "("+tileLabel.getText()+")";
    }
}
