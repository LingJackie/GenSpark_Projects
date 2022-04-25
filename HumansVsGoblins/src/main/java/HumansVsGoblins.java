import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HumansVsGoblins {



    private GameWorld world;
    private Actor player;
    private ArrayList<Goblin> goblinHorde = new ArrayList<Goblin>();
    private Goblin engagedEnemy; // Currently engaged goblin

    private boolean combatRunning;
    private boolean gameRunning;


    public String getWorldMap(){
        return world.toString();
    }


    public HumansVsGoblins(){
        world = new GameWorld();
        player = new Human("jackie",10,5,10);
        this.generateGoblins(3);
        world.setActorMap(player.getX(), player.getY(), player.toString());
        this. updateGoblinIcons();
        combatRunning = false;
        gameRunning = true;
    }

    /*===== WORLD SETUP =====*/
    // Generates a random index from within the world map
    public int generateRandXLocation(){
        Random rand = new Random();
        return rand.nextInt(world.length());
    }
    public int generateRandYLocation(){
        Random rand = new Random();
        return rand.nextInt(world.width());
    }

    // Moves player based on "n","s","e","w" inputs
    public String movePlayer(String direction){
        world.clearActorMap(player.getX(), player.getY());// Clears original position of player icon
        String message = player.move(direction);
        world.setActorMap(player.getX(), player.getY(), player.toString());// puts emoji in new position
        return message;
    }

    // Creates new goblins based on hordeSize
    public void generateGoblins(int hordeSize){
        for(int i =0;i<hordeSize;i++){
            goblinHorde.add(new Goblin("goblin"+i, 3,3,3));
            goblinHorde.get(i).setLocation(generateRandXLocation(),generateRandYLocation());
        }
    }

    public void updateGoblinIcons(){
        //world.setTile(player.getX(), player.getY(), player.toString());
        for(Goblin g: goblinHorde){
            world.setActorMap(g.getX(), g.getY(), g.toString());
        }
    }



    /*===== COMBAT STUFF =====*/
    // Sets up the combat encounter
    public void initCombat(Goblin g){
        combatRunning = true;
        world.toggleMapCombatMarker(g.getX(),g.getY());// toggles on a map combat marker
        engagedEnemy = g;
    }
    public void endCombat(Goblin g){
        combatRunning = false;
        world.toggleMapCombatMarker(g.getX(),g.getY());// toggles off map combat marker
        engagedEnemy = null;
    }

    // Checks if a goblin and player occupies the same tile, if so it will initialize combat
    public boolean checkCombat(){
        for(Goblin g: goblinHorde){
            // Checks player and goblin positions as well as if goblin is already dead
            if(g.getX() == player.getX() && g.getY() == player.getY() && !g.isDead()){
                initCombat(g);
                return true;
            }
        }
        return false;
    }

    public void combatLoop(){
        while(combatRunning){
            System.out.println("Make your move.(Fight: attack; Leave: n, s, e, w)");
            Scanner myObj = new Scanner(System.in);
            System.out.println(this.combatActions(myObj.nextLine()));
            System.out.println(player.displayHealthBar());// Displays health bar
            System.out.println(engagedEnemy.displayHealthBar());// Displays health bar

            if(engagedEnemy.isDead()){
                System.out.println(engagedEnemy.setDead());
                endCombat(engagedEnemy);

            }
        }

    }

    public String combatActions(String action){
        switch (action){
            case "attack":
                return player.attack(engagedEnemy) +"\n"+ engagedEnemy.attack(player);
            default:
                return "Not a valid action.";
        }
    }

    public void gameLoop(){
        while(gameRunning){
            try{
                System.out.println(this.getWorldMap());// Displays map
                System.out.println(player.displayHealthBar());// Displays health bar

                System.out.println("Make your move.(n, s, e, w)");
                Scanner myObj = new Scanner(System.in);
                System.out.println(this.movePlayer(myObj.nextLine()));
                this.updateGoblinIcons();

                if(this.checkCombat()){
                    System.out.println("Combat has started.");
                    System.out.println(this.getWorldMap());// Displays map
                    combatLoop();
                }
            }catch (Exception e){
                System.out.println("idk");
            }


        }
    }
}
