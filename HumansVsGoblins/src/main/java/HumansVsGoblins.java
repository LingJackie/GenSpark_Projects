import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HumansVsGoblins {

    private GameWorld world;
    private Actor player;
    private ArrayList<Goblin> goblinHorde = new ArrayList<Goblin>();
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
        this. updateAllActors();
        combatRunning = false;
        gameRunning = true;
    }

    // Checks if a goblin and player occupies the same tile and starts combat if they are
    public boolean isInCombat(){
        for(Goblin g: goblinHorde){
            if(g.getX() == player.getX() && g.getY() == player.getY()){
                combatRunning = true;
                return true;
            }
        }
        return false;
    }

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

    public void updateAllActors(){
        //world.setTile(player.getX(), player.getY(), player.toString());
        for(Goblin g: goblinHorde){
            world.setActorMap(g.getX(), g.getY(), g.toString());
        }
    }

    public void combatLoop(){
        System.out.println("Combat has started.");
        while(combatRunning){
            System.out.println("Make your move.(Fight: attack; Leave: n, s, e, w)");
            Scanner myObj = new Scanner(System.in);
        }

    }

    public void gameLoop(){

        while(gameRunning){
            try{
                System.out.println(this.getWorldMap());
                System.out.println("Make your move.(n, s, e, w)");
                Scanner myObj = new Scanner(System.in);
                System.out.println(this.movePlayer(myObj.nextLine()));
                this.updateAllActors();
                if(this.isInCombat()){
                    System.out.println("Combat has started.");
                }
            }catch (Exception e){
                System.out.println("idk");
            }


        }
    }
}
