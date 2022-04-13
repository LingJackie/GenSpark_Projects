import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private int randNum; //random number between 1 and 20
    private int tries; //tries used
    private final int maxTries = 6;
    private String name;
    private boolean gameRunning; // default should be true that the game is still running
    private boolean continueGame;// Uses this when choosing to replay game

    // Helpers
    public void generateRandNum(){
        Random rand = new Random();
        this.randNum = rand.nextInt(20) + 1;
    }
    public void setUpNewGame(){
        generateRandNum();
        setTries(0);
        gameRunning = true;
    }
    // this ones used for testing
    public void setUpNewGame(int randNum, int tries, boolean gameRunning){
        this.randNum = randNum;
        this.tries = tries;
        this.gameRunning = gameRunning;
    }

    public void setTries(int tries)             { this.tries = tries; }
    public void setRandNum(int randNum)         { this.randNum = randNum; }
    public int getTries()                       { return this.tries; }
    public int getRandNum()                     { return this.randNum; }
    public boolean isGameRunning()              { return this.gameRunning; }
    public boolean isContinueGame()             { return this.continueGame; }
    public void setGameRunning(boolean bool)    { this.gameRunning = bool; }
    public void setContinueGame(boolean bool)   { this.continueGame = bool; }



    // Constructor
    public GuessTheNumber() {
        this.name = "";
        this.continueGame = true;
        this.tries = 0;
    }


    public String greeting(){
        try{
            Scanner nameObj = new Scanner(System.in);
            String name = nameObj.nextLine();
            this.name = name;
            return "Well, " + name + ", I am thinking of a number between 1 and 20.";
        }catch(Exception e){
            return "Somethings wrong, buddy.";
        }
    }

    // Returns a String response for when you make a guess
    public String guessResponse(int guessNum){
        if (this.tries == this.maxTries) {
            this.gameRunning = false;
            return "You ran out of tries";
        } else if (guessNum > this.randNum) {
            return "Your guess is too high.";
        } else if (guessNum < this.randNum) {
            return "Your guess is too low.";
        } else if (this.randNum == guessNum) {
            this.gameRunning = false;
            return "Good job, " + name + "! You guessed my number in " + tries + " guesses!";
        }
        return "";
    }

    /*
    continueGame: Determines with the game will be replayed or not
    gameRunning: As long as this is true the game will keep running
    */
    public void playGame(){
        int guessNum; //the guessed number
        Scanner numObj = new Scanner(System.in);

        while(continueGame) {
            setUpNewGame();
            while (this.gameRunning) {
                System.out.println("Take a Guess.");
                try{
                    guessNum = Integer.parseInt(numObj.nextLine());
                }catch (Exception e){
                    guessNum = -1;
                }
                this.tries++;
                System.out.println(guessResponse(guessNum));
            }
            System.out.println("Would you like to play again?(y or n)");
            replay();
        }
    }
    public void replay(){
        Scanner playAgainObj = new Scanner(System.in);
        try{
            this.continueGame = playAgainObj.nextLine().equals("y");
        }catch (Exception e){
            this.continueGame = false;
            System.out.println("I'm sorry something went wrong, I'll end the game");
        }
    }

    public void startGame(){
        System.out.println("Hello! What is your name?");
        System.out.println(greeting());
        playGame();
    }

}
