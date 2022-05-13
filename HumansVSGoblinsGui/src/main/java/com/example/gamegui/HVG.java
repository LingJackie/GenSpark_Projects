package com.example.gamegui;

import javafx.scene.Group;
import misc.Dice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HVG {
    private final int n = 50;
    private final int m = 28;

    private Group mapGroup;// Gui component that holds and displays the game map
    private GameWorld map;
    private boolean gameRunning;
    
    private boolean engagedInCombat;
    private Goblin engagedEnemy; // Current combat engaged goblin
    private Queue<Actor> combatTurnQueue;
    private int turns;  // Number of turns spent in combat(Resets after each encounter)
    
    private Human player;
    private ArrayList<Goblin> goblinHorde;

    Dice dice;

    
    public Dice getDice()                       {return dice;}
    public Human getPlayer()                    {return player;}
    public Group getMapGroup()                  {return mapGroup;}
    public GameWorld getGameWorld()             {return map;}
    public Queue<Actor> getCombatTurnQueue()    {return combatTurnQueue;}
    public int getTurns()                       {return turns;}
    public Goblin getEngagedEnemy()             {return engagedEnemy;}

    public int incrementTurns()                 {return ++turns;}

    public boolean isEngagedInCombat()  {return engagedInCombat;}

    public HVG(){
        dice = new Dice();
        goblinHorde = new ArrayList<Goblin>();

        mapGroup = new Group();
        map =  new GameWorld(n,m);
        
        engagedInCombat = false;
        combatTurnQueue = new LinkedList<Actor>() ;
        gameRunning = true;

        turns = -1;
    }

    public void setUpGameWorldGUI(){
        for( int i=0; i < map.length() ; i++) {
            for( int j=0; j < map.width(); j++) {
                // add node to group
                mapGroup.getChildren().add( map.getTile(i,j));
            }
        }
    }
    // Spawns player at the center of the map
    public void spawnPlayer(){
        player = new Human("jackie",5,5,5,true);
        player.setLoc(n/2,m/2);
        mapGroup.getChildren().add(player.getSprite());// Adds sprite to the map
    }
    // Spawns goblins in random locations
    public void spawnGoblinHorde(int hordeSize){
        for(int i =0;i<hordeSize;i++){
            goblinHorde.add(new Goblin("goblin"+i, 3,3,3));
            goblinHorde.get(i).setLoc(dice.rollDWhatever(n),dice.rollDWhatever(m));
            mapGroup.getChildren().add(goblinHorde.get(i).getSprite());// Adds sprite to the map
        }
    }


    /*===== COMBAT =====*/
    // Checks if a goblin and player occupies the same tile
    public boolean checkEnemyPosOverlap(){
        for(Goblin g: goblinHorde){
            if(player.getCoord().equals(g.getCoord()) && !g.isDead()){
                engagedInCombat = true;
                engagedEnemy = g; // Sets the current engaged enemy
                return true;
            }
        }
        return false;
    }
    public void endCombat(){
        engagedInCombat = false;
        engagedEnemy = null;
        combatTurnQueue.clear();
        turns = -1;
    }
    public String deathHandler(Actor someDude){
        String message = "";
        if(someDude!=null && someDude.isDead()){
            endCombat();
            message += someDude.getName() + " has died.";
            if(someDude.isPlayable()){
                gameRunning = false;
                message += "\nGAME OVER";
            }
        }
        return message;
    }
    // Determines whose turn starts first in combat; Highest initiative starts first
    public String initCombat(int diceRoll1, int diceRoll2){
        int playerInitiative = player.getDexterity() + diceRoll1;
        int goblinInitiative = engagedEnemy.getDexterity() + diceRoll2;
        String message = player.getName() + " Initiative:" + playerInitiative + "   "
                + engagedEnemy.getName() + " Initiative:" + goblinInitiative+"\n";
        if(playerInitiative>goblinInitiative){
            combatTurnQueue.add(player);
            combatTurnQueue.add(engagedEnemy);
            return message + player.getName()+ " starts first.";
        }else{
            combatTurnQueue.add(engagedEnemy);
            combatTurnQueue.add(player);
            return message + engagedEnemy.getName()+ " starts first.";
        }
    }
    public String goblinCombatTurn(){
        return engagedEnemy.attack(player, dice.rollD10()) + " on turn " + ++turns;
    }

    public void combatLoop(){
        while(engagedInCombat){
            System.out.println(player.getHealthRatio());// Displays player health bar
            System.out.println(engagedEnemy.getHealthRatio());// Displays goblin health bar

            // Checks whose turn it is
            if(combatTurnQueue.peek().isPlayable()){
                //System.out.println(playerCombatTurn());
            }else{
                System.out.println(goblinCombatTurn());
            }
            combatTurnQueue.add(combatTurnQueue.remove());

            System.out.println(deathHandler(player));// Checks if player has died
            System.out.println(deathHandler(engagedEnemy));// Checks if goblin has died

        }

    }
}
