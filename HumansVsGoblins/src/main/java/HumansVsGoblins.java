import java.nio.file.Files;
import java.util.*;

public class HumansVsGoblins {



    private GameWorld world;
    private Human player;
    private ArrayList<Goblin> goblinHorde = new ArrayList<Goblin>();
    private Goblin engagedEnemy; // Current combat engaged goblin
    private Dice gameDice;

    private boolean combatRunning;
    private boolean gameRunning;

    private Queue<Actor> combatQueue;


    public String getWorldMap(){
        return world.toString();
    }
    public Human getPlayer()   {
        return player;
    }

    public void addGoblin(Goblin g){
        goblinHorde.add(g);
    }

    // Default constructor
    public HumansVsGoblins(){
        world = new GameWorld();
        player = new Human("Steve",5,5,5, true);
        world.setActorMap(player.getX(), player.getY(), player.toString());

        // Scales goblin horde size based off world size
        int numTiles = world.length()* world.width();
        int hordeSize = (numTiles/75)+1;
        this.generateGoblins(hordeSize);
        this.updateGoblinIcons();

        gameDice = new Dice();
        combatRunning = false;
        gameRunning = true;

        combatQueue = new LinkedList<Actor>();

    }
    // Constructor used for testing
    public HumansVsGoblins(int worldSize, int hordeSize){
        world = new GameWorld(worldSize);
        player = new Human("Steve",5,5,5, true);
        world.setActorMap(player.getX(), player.getY(), player.toString());

        this.generateGoblins(hordeSize);
        this.updateGoblinIcons();

        gameDice = new Dice();
        combatRunning = false;
        gameRunning = true;

        combatQueue = new LinkedList<Actor>();
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
        int oldX = player.getX();
        int oldY = player.getY();
        String message = player.move(direction);// Moves player
        if(!world.isOutOfBounds(player.getX(),player.getY())){// Checks if new position is out of bounds
            world.clearActorMap(oldX, oldY);// Clears original position of player icon
            world.setActorMap(player.getX(), player.getY(), player.toString());// puts icon in new position
            return message;
        }else{
            player.setLocation(oldX,oldY);
            return "You cannot go that way.";
        }
    }

    // Creates new goblins based on hordeSize
    public void generateGoblins(int hordeSize){
        for(int i =0;i<hordeSize;i++){
            goblinHorde.add(new Goblin("goblin"+i, 3,3,3));
            goblinHorde.get(i).setLocation(generateRandXLocation(),generateRandYLocation());
        }
    }

    public void updateGoblinIcons(){
        for(Goblin g: goblinHorde){
            world.setActorMap(g.getX(), g.getY(), g.toString());
        }
    }

    public void promptName(){
        System.out.println("Input a username:");
        Scanner myObj = new Scanner(System.in);
        player.setName(myObj.nextLine());
    }


    /*===== COMBAT STUFF =====*/
    // Sets up the combat encounter
    public void initCombat(Goblin g){
        combatRunning = true;
        world.toggleMapCombatMarker(g.getX(),g.getY());// toggles on a map combat marker
        engagedEnemy = g; // Sets the current engaged enemy
    }
    public void endCombat(){
        combatRunning = false;
        world.toggleMapCombatMarker(player.getX(),player.getY());// toggles off map combat marker
        this.updateGoblinIcons();
        engagedEnemy = null;
        combatQueue.clear();
    }

    // Checks if a goblin and player occupies the same tile, if so it will initialize combat
    public boolean checkCombatStart(){
        for(Goblin g: goblinHorde){
            // Checks player and goblin positions as well as if goblin is already dead
            if(g.getX() == player.getX() && g.getY() == player.getY() && !g.isDead()){
                initCombat(g);
                return true;
            }
        }
        return false;
    }
    public String deathHandler(Actor someDude){
        String message = "";
        if(someDude!=null && someDude.isDead()){
            endCombat();
            message += someDude.setDead();
            if(someDude.isPlayable()){
                gameRunning = false;
                message += "\nGAME OVER";
            }
        }
        return message;
    }
    // Determines whose turn starts first in combat; Highest initiative starts first
    public String rollInitiative(int diceRoll1, int diceRoll2){
        int playerInitiative = player.getDexterity() + diceRoll1;
        int goblinInitiative = engagedEnemy.getDexterity() + diceRoll2;
        String message = player.getName() + " Initiative:" + playerInitiative + "   "
                + engagedEnemy.getName() + " Initiative:" + goblinInitiative+"\n";
        if(playerInitiative>goblinInitiative){
            combatQueue.add(player);
            combatQueue.add(engagedEnemy);
            return message + player.getName()+ " starts first.";
        }else{
            combatQueue.add(engagedEnemy);
            combatQueue.add(player);
            return message + engagedEnemy.getName()+ " starts first.";
        }

    }
    // Prompts player for a combat action
    public String playerCombatTurn(){
        System.out.println("Your turn:\n<attack>    <leave>");
        Scanner myObj = new Scanner(System.in);
        return this.combatActions(myObj.nextLine());
    }
    public String goblinCombatTurn(){
        return engagedEnemy.attack(player, gameDice.rollD10());
    }
    // Actions player can perform during combat
    public String combatActions(String action){
        switch (action){
            case "attack":
                return player.attack(engagedEnemy, gameDice.rollD10());
            case "leave":
                endCombat();
                return "You chicken out and leave.";
            default:
                return "Not a valid action.";
        }
    }

    public void combatLoop(){
        while(combatRunning){
            System.out.println(player.displayHealthBar());// Displays player health bar
            System.out.println(engagedEnemy.displayHealthBar());// Displays goblin health bar

            // Checks whose turn it is
            if(combatQueue.peek().isPlayable()){
                System.out.println(playerCombatTurn());
            }else{
                System.out.println(goblinCombatTurn());
            }
            combatQueue.add(combatQueue.remove());

            System.out.println(deathHandler(player));// Checks if player has died
            System.out.println(deathHandler(engagedEnemy));// Checks if goblin has died

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

                if(this.checkCombatStart()){
                    System.out.println(this.getWorldMap());// Redisplay map, but it now has a combat indicator
                    System.out.println("Combat has started.");
                    System.out.println(this.rollInitiative(gameDice.rollD20(), gameDice.rollD20()));
                    combatLoop();
                }
            }catch (Exception e){
                System.out.println("Something went wrong in the game loop.");
            }


        }
    }
    public void startGame(){
        promptName();
        gameLoop();
    }
}
