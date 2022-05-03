import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Hangman {


    private String randWord;
    private String guessWord;
    private Gallows gallows;
    private String missedLetters;
    private String correctLetters;
    private boolean gameRunning; // True would mean that the game is still running

    private ScoreBoard scoreBoard;


    // Initializes/Resets everything
    private void initNewGame(){
        this.randWord = genRandWord();
        this.guessWord = genBlankLines(this.randWord);
        this.gallows = new Gallows(0);
        this.missedLetters = "";
        this.correctLetters = "";
        this.gameRunning = true;
        
    }

    public String getRandWord() { return randWord; }
    public String getGuessWord(){ return guessWord; }


    
    // Constructors
    public Hangman(){
        this.initNewGame();
        scoreBoard = new ScoreBoard("player");
    }

    public Hangman(String randWord, String guessWord, int tries, String name){
        this.randWord = randWord;
        this.guessWord = guessWord;
        this.gallows = new Gallows(tries);
        this.missedLetters = "";
        this.correctLetters = "";
        this.gameRunning =  true;
        scoreBoard = new ScoreBoard(name);
    }
  


    // Generates the corresponding amount of blank lines based on the inputted word
    public String genBlankLines(String randWord){
        ArrayList<String> tmpArr = new ArrayList<String>(Arrays.asList(randWord.split("")));
        return tmpArr.stream()
                    .reduce("", (partialString, element) -> partialString + "_");

    }

    // Grabs a random word from a file containing a bunch of words
    public String genRandWord(){
        try{
            Path filePath = Paths.get("src/main/resources/wordlist.txt");//needs try catch
            Random rand = new Random();
            int randNum = rand.nextInt( (int)Files.lines(filePath).parallel().count() );
            List<String> words = Files.readAllLines(filePath);
            return words.get(randNum);
        }catch(Exception e){
            return "";
        }
    }

    public String replaceWithBlank(String letter){
        if(correctLetters.contains(letter)){
            return letter;
        }else{
            return "_";
        }
    }
    // Replaces each blank with a correctly guessed letter
    public void updateGuessBlanks(String letter){
        if( !guessWord.contains(letter) && randWord.contains(letter) ){
            correctLetters+=letter;
            guessWord=Arrays.asList(randWord.split("")).stream()
                                                            .map(l -> replaceWithBlank(l))
                                                            .reduce("",(partialStr,l) -> partialStr+l);
        }
    }

    // Checks the guess and returns a response
    public String makeGuess(String letter){
        if(letter.length()>1){ // Inputted multiple letters
            return "One guess at a time, please.";
        }else if(!Character.isLetter(letter.charAt(0))){  // Input not in alphabet
            return "Invalid Input.";
        }else if( !guessWord.contains(letter) && randWord.contains(letter) ){// Guessed correct letter
            updateGuessBlanks(letter);
        }else if(guessWord.contains(letter) || missedLetters.contains(letter)){// Inputted an already guessed letter
            return "You have already guessed that letter. Choose again.";
        }else if(!randWord.contains(letter)) {// Guess was wrong
            missedLetters+=letter;
            gallows.incrementState();
        }
        return gallows.toString() + "Missed letters:" + missedLetters + "\n" + guessWord;// Returns the gallows + incorrectly guessed letters + blanks
    }

    // Checks if the player has used up all tries or if they correctly guessed the right word
    // Returns a message to the player
    private String checkGameEnded(){
        String message="";
        if(gallows.getState() == 6){
            message="Too bad. The secret word is \"" + randWord + "\". You Lost.";
            gameRunning = false;
        }if(guessWord.equals(randWord)){
            message="Yes! The secret word is \"" + randWord + "\". You have won!";
            gameRunning = false;
            scoreBoard.addScore(randWord.length()*10);// If solved add score
        }
        return message;
    }

    // Manages the logic for the whole game
    public void gameLoop(){
        System.out.println("HANGMAN\n"+gallows+"Missed letters:"+ missedLetters + "\n"+guessWord);
        while(gameRunning){
            try{
                Scanner myObj = new Scanner(System.in);
                String guessLetter = myObj.nextLine();
                System.out.println(makeGuess(guessLetter));
                System.out.println(checkGameEnded());
            }catch (Exception e){
                System.out.println("Something Went wrong.");
            }
        }

        System.out.println("Do you want to play again? (yes or no)");
        try{
            Scanner myObj = new Scanner(System.in);
            String replay = myObj.nextLine();
            if(replay.equals("yes") || replay.equals("y")){
                initNewGame();
                gameLoop();
            }else{
                System.out.println("Game will now terminate. Your total score is: " + scoreBoard.getScore());// Once game ends save score to a file
                scoreBoard.saveScore();
                System.out.println(scoreBoard.checkHighScore());
            }
        }catch (Exception e){
            System.out.println("Error. Something went wrong. Game will now terminate. ");
        }
    }

    // Starts the game
    public void startGame(){
        System.out.println("Enter your name to start:");
        try{
            Scanner myObj = new Scanner(System.in);
            scoreBoard.setName(myObj.nextLine());
        }catch (Exception e){
            System.out.println("Name invalid. Game will proceed.");
        }
        gameLoop();


    }



}
