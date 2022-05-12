package com.example.gamegui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Human extends Actor{

    public Human(String name, int strength, int constitution, int dexterity, boolean playable) {
        super(name, strength, constitution, dexterity);
        this.playable = playable;
        try{
           setSprite("player.png");
        }catch (Exception e){
        }
    }
}
