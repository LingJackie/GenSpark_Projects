package com.example.gamegui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Goblin extends Actor{

    public Goblin(String name, int strength, int constitution, int dexterity) {
        super(name, strength, constitution, dexterity);
        playable = false;
        try{
            setSprite("goblin.png");
        }catch (Exception e){
        }
    }
    public Goblin() {
        super("goblin", 3, 3, 3);
        playable = false;
        try{
            setSprite("goblin.png");
        }catch (Exception e){
        }
    }
}
