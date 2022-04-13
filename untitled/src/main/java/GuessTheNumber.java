import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private int randNum; //random number between 1 and 20
    private int tries; //tries used
    private final int maxTries = 6;
    private String name;
    private boolean isGamePlaying; // default should be true that the game is still running
    private boolean isGameContinuing;

    // Helpers
    public void generateRandNum(){
        Random rand = new Random();
        this.randNum = rand.nextInt(20) + 1;
    }
    public void setUpNewGame(){
        generateRandNum();
        setTries(0);
        isGamePlaying = true;
    }
    public void setTries(int tries)     { this.tries = tries; }
    public void setRandNum(int randNum) { this.randNum = randNum; }
    public int getTries()               { return this.tries; }
    public int getRandNum()             { return this.randNum; }

    // Constructor
    public GuessTheNumber() {
        this.name = "";
        isGameContinuing = true;
    }


    public void greeting(){
        System.out.println("Hello! What is your name?");
        try{
            Scanner nameObj = new Scanner(System.in);
            String name = nameObj.nextLine();
            this.name = name;
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
        }catch(Exception e){
            System.out.println("Somethings wrong, buddy.");
        }
    }
    public String guessResponse(int guessNum){
        if (guessNum > this.randNum) {
            return "Your guess is too high.";
        } else if (guessNum < this.randNum) {
            return "Your guess is too low.";
        } else if (this.randNum == guessNum) {
            isGamePlaying = false;
            return "Good job, " + name + "! You guessed my number in " + tries + " guesses!";
        }if (this.tries == this.maxTries) {
            isGamePlaying = false;
            return "You ran out of tries";
        }
        return "";
    }

    public void playGame(){
        int guessNum; //the guessed number
        Scanner numObj = new Scanner(System.in);
        Scanner playAgainObj = new Scanner(System.in);

        while(isGameContinuing) {
            setUpNewGame();
            while (this.isGamePlaying) {
                System.out.println("Take a Guess.");
                try{
                    guessNum = Integer.parseInt(numObj.nextLine());
                }catch (Exception e){
                    guessNum = -1;
                }
                tries++;
                System.out.println(guessResponse(guessNum));
            }
        }
        System.out.println("Would you like to play again?(y or n)");
        try{
            this.isGameContinuing = playAgainObj.nextLine().equals("y");
        }catch (Exception e){
            this.isGameContinuing = false;
            System.out.println("I'm sorry something went wrong, I'll end the game");
        }

    }
    public void startGame(){
        greeting();
        playGame();
    }

}
