package misc;

import java.util.Random;

public class Dice {
    private Random rand;
    public Dice(){
        rand = new Random();
    }
    public int rollD5()     { return rand.nextInt(5) + 1; }
    public int rollD10()    { return rand.nextInt(10) + 1; }
    public int rollD20()    { return rand.nextInt(20) + 1; }
}
