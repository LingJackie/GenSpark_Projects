package com.example.gamegui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class TileNode extends StackPane {

    private final String CROSSED_SWORDS_EMOJI = "\u2694";


    private String landscapeIcon;
    private String actorIcon;
    private boolean combatMarker;

    Rectangle landTile;// Tile that's going to be displayed


    // Takes in a hex value
    public void setTileColor(String color){
        landTile.setFill(Color.web(color));
    }
    public void setTileTexture(Image texture){
        landTile.setFill(new ImagePattern(texture));
    }
    // Sets the tile icon to an actors icon
    public String setActorIcon(String actor_icon){
        this.actorIcon = actor_icon;
        return this.toString();
    }
    public String clearActorIcon(){
        this.actorIcon = "";
        return this.toString();
    }

    // Toggles if combat is occurring on this tile
    public String toggleCombatMarker(){
        combatMarker = combatMarker? false: true;
        return this.toString();
    }


    /*
        Constructor
        size -> Dimensions of the tile i.e. if size is 25 then tile would be 25x25
        x,y -> Coords on the grid
     */
    public TileNode(String landscapeIcon, double x, double y, int size){
        this.landscapeIcon =landscapeIcon;
        this.actorIcon = "";
        this.combatMarker = false;

        landTile = new Rectangle(size,size);
        landTile.setFill(Color.BLACK);

        // create label
        Label label = new Label(landscapeIcon);


        // set position
        setTranslateX(x*size);
        setTranslateY(y*size);
        getChildren().addAll(landTile,label);
    }
}
