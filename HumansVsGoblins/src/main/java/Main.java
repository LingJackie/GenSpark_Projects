

public class Main {

    public static void main(String args[]){
//        GameWorld tmpWorld =new GameWorld();
//        System.out.println(tmpWorld);

//        Actor player = new Actor("jackie",10,5,10);
//        Actor goblin = new Actor("gobby",10,5,10);
//        System.out.println(goblin.getStats());
//        System.out.println(goblin.attack(player));

        HumansVsGoblins game1 = new HumansVsGoblins(5, 5);
        game1.startGame();

    }
}
