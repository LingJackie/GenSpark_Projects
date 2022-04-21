public class Main {

    public static void main(String args[]){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";


        System.out.println(ANSI_YELLOW + "This text is colored" + ANSI_RESET);
        GameWorld tmpWorld =new GameWorld();
        System.out.println(tmpWorld);

        Actor player = new Actor("jackie",10,5,10);
        Actor goblin = new Actor("gobby",10,5,10);
        System.out.println(goblin.getStats());
        System.out.println(goblin.attack(player));
    }
}
