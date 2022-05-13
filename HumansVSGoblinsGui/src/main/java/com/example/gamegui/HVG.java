package com.example.gamegui;

import javafx.scene.Group;
import misc.Dice;

import java.util.ArrayList;

public class HVG {
    private final int n = 50;
    private final int m = 28;

    private Group mapGroup;// Gui component that holds and displays the game map
    private GameWorld map;

    private Human player;
    private ArrayList<Goblin> goblinHorde;

    Dice dice;

    public Human getPlayer()        {return player;}
    public Group getMapGroup()      {return mapGroup;}
    public GameWorld getGameWorld() {return map;}

    public HVG(){
        dice = new Dice();
        goblinHorde = new ArrayList<Goblin>();

        mapGroup = new Group();
        map =  new GameWorld(n,m);
    }

    public void setUpGameWorldGUI(){
        for( int i=0; i < map.length() ; i++) {
            for( int j=0; j < map.width(); j++) {
                // add node to group
                mapGroup.getChildren().add( map.getTile(i,j));
            }
        }
    }
    public void spawnPlayer(){
        player = new Human("jackie",5,5,5,true);
        // Moves player to the center of map
        player.setLoc(n/2,m/2);
        mapGroup.getChildren().add(player.getSprite());// Adds sprite to the map
    }
    public void spawnGoblinHorde(int hordeSize){
        for(int i =0;i<hordeSize;i++){
            goblinHorde.add(new Goblin("goblin"+i, 3,3,3));
            goblinHorde.get(i).setLoc(dice.rollDWhatever(n),dice.rollDWhatever(m));
            mapGroup.getChildren().add(goblinHorde.get(i).getSprite());// Adds sprite to the map
        }
    }
}
