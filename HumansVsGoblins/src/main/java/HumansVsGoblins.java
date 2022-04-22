import java.util.ArrayList;

public class HumansVsGoblins {

    private GameWorld world;
    private Actor player;
    private ArrayList<Goblin> goblinHorde = new ArrayList<Goblin>();

    public String getWorldMap(){
        return world.toString();
    }


    public HumansVsGoblins(){
        world = new GameWorld();
        player = new Human("jackie",10,5,10);
        world.setTile(player.getX(), player.getY(), player.toString());
    }


    // Moves player based on "n","s","e","w" inputs
    public String movePlayer(String direction){
        world.setTile(player.getX(), player.getY(), ". ");// Clears original position of emoji
        String message = player.move(direction);
        world.setTile(player.getX(), player.getY(), player.toString());// puts emoji in new position
        return message;
    }

    public void generateGoblins(int hordeSize){
        for(int i =0;i<hordeSize;i++){
            goblinHorde.add(new Goblin("goblin"+i, 3,3,3));
        }
    }

    public void initGame(){

    }
}
