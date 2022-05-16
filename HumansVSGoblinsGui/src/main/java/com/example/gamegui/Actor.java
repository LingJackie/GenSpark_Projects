package com.example.gamegui;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import misc.Coord;

import java.io.FileNotFoundException;

import static misc.Constants.SPRITE_DIMENSION;

public class Actor {
    private String name;

    private int strength;// Determines damage dealt
    private int constitution;// Determines health
    private int dexterity;// Determines initiative

    private int attackPower;// Derived from strength and weapon stats
    private int maxHealth;// Derived from constitution and maybe armor
    private int currHealth;

    protected Rectangle sprite;// Holds actor's sprite
    Coord actorCoord;

    protected boolean playable;

    public int getCurrHealth()      {return currHealth;}
    public int getMaxHealth()       {return maxHealth;}
    public String getHealthRatio()  {return currHealth +"/"+ maxHealth;}
    public String getName()         {return name;}
    public int getDexterity()       {return dexterity;}
    public Coord getCoord()         {return actorCoord;}
    public Rectangle getSprite()    {return sprite;}

    public void setName(String name)        { this.name = name;}
    public void setSprite(String imgName) throws FileNotFoundException {
        Image img = new Image(getClass().getResourceAsStream(imgName));
        sprite.setFill(new ImagePattern(img));
    }
    public void setLoc(int x, int y){
        actorCoord.setLoc(x,y);
        updateSpriteLoc();
    }


    public boolean isDead()     { return currHealth <= 0; }
    public boolean isPlayable() { return playable; }




    // Constructor
    public Actor(String name, int strength, int constitution, int dexterity){
        this.name = name;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;

        attackPower = strength;
        maxHealth = constitution*10;
        currHealth = maxHealth;

        // Inits location at 0,0
        actorCoord = new Coord();


        initSprite();
    }

    private void initSprite(){
        sprite = new Rectangle(SPRITE_DIMENSION,SPRITE_DIMENSION);
        sprite.setFill(Color.BLACK);
        updateSpriteLoc();
    }
    private void updateSpriteLoc(){
        sprite.setX(actorCoord.getGuiX());
        sprite.setY(actorCoord.getGuiY());
    }

    public String takeDamage(int damage){
        currHealth -= damage;
        currHealth = currHealth<0?0:currHealth;
        return name + " has taken " + damage + " damage";
    }
    public String heal(int healedAmt){
        currHealth = currHealth+healedAmt > maxHealth? maxHealth: currHealth+healedAmt;
        return name + " has healed for " + healedAmt + " health";
    }

    // Total damage should be attackPower+diceRoll+(weapon damage)
    public String attack(Actor someDude, int diceRoll){// In the future have it take a Weapon object as a parameter
        int totalDamageDealt = this.attackPower+diceRoll;
        someDude.takeDamage(totalDamageDealt);
        return this.name +" attacks "+ someDude.getName() + "\n" + someDude.getName() +" takes " + totalDamageDealt + " damage.";
    }

    // Updates an Actors Coords and Sprite location
    public String moveActor(String direction, TileNode[][] world){
        switch (direction){
            case "n":
                if(!actorCoord.decrementY(world)){// If actor tries to go out of bounds or to something that's impassable
                    return name + " stays put at" + actorCoord;
                }
                updateSpriteLoc();
                return name + " moves north to " + actorCoord;
            case "s":
                if(!actorCoord.incrementY(world)){
                    return name + " stays put at " + actorCoord;
                }
                updateSpriteLoc();
                return name + " moves south to " + actorCoord;
            case "e":
                if(!actorCoord.incrementX(world)){
                    return name + " stays put at " + actorCoord;
                }
                updateSpriteLoc();
                return name + " moves east to " + actorCoord;
            case "w":
                if(!actorCoord.decrementX(world)){
                    return name + " stays put at " + actorCoord;
                }
                updateSpriteLoc();
                return name + " moves west to " + actorCoord;
            default:
                return name + " stays put at " + actorCoord;
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
