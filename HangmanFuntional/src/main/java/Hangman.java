import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {


    private String randWord;
    private String guessWord;
    private Gallows gallows;
    private String missedLetters;
    private boolean gameRunning; // True would mean that the game is still running


    // Initializes/Resets everything
    public void initNewGame(){
        this.randWord = genRandWord();
        this.guessWord = genBlankLines(this.randWord);
        this.gallows = new Gallows(0);
        this.missedLetters = "";
        this.gameRunning = true;
        
    }

    public String getRandWord() { return randWord; }
    public String getGuessWord(){ return guessWord; }


    
    // Constructors
    public Hangman(){
        initNewGame();
    }

    public Hangman(String randWord, String guessWord, int tries){
        this.randWord = randWord;
        this.guessWord = guessWord;
        this.gallows = new Gallows(tries);
        this.missedLetters = "";
        this.gameRunning =  true;
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

    // Replaces each blank with a correctly guessed letter
    public void updateGuessBlanks(String letter){
        if( !guessWord.contains(letter) && randWord.contains(letter) ){
            Pattern patt = Pattern.compile(letter);
            Matcher matcher = patt.matcher(randWord);

            // Finds all the indices of where there is an occurrence of letter in randWord and updates guessWord accordingly
            while(matcher.find()) {
                guessWord = guessWord.substring(0, matcher.start()) + letter + guessWord.substring(matcher.start()+1);
            }
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

    // Manages the logic for the whole game
    public void gameLoop(){
        System.out.println("HANGMAN\n"+gallows+"Missed letters:"+ missedLetters + "\n"+guessWord);
        while(gameRunning){
            try{
                Scanner myObj = new Scanner(System.in);
                String guessLetter = myObj.nextLine();
                System.out.println(makeGuess(guessLetter));
            }catch (Exception e){
                System.out.println("idk");
            }
            if(gallows.getState() == 6){
                System.out.println("Too bad. The secret word is \"" + randWord + "\". You Lost.");
                gameRunning = false;
                break;
            }if(guessWord.equals(randWord)){
                System.out.println("Yes! The secret word is \"" + randWord + "\". You have won!");
                gameRunning = false;
                break;
            }
        }
    }

    // starts the game
    public void startGame(){
        gameLoop();

        System.out.println("Do you want to play again? (yes or no)");
        try{
            Scanner myObj = new Scanner(System.in);
            String replay = myObj.nextLine();
            if(replay.equals("yes") || replay.equals("y")){
                initNewGame();
                startGame();
            }else{
                System.out.println("Game will now terminate.");
            }
        }catch (Exception e){
            System.out.println("idk");
        }

    }



}
