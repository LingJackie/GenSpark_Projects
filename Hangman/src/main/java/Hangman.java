import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman {


    private String randWord;
    private String guessWord;
    private String gallows = "  +---+2\n3  |   |\n      |\n      |\n      |\n      |\n=========";
    private int tries;
    private final int maxTries = 6;


    /* Helpers */
    public String getRandWord() { return randWord; }
    public String getGuessWord(){ return guessWord; }

    public Hangman(){
        this.randWord = genRandWord();
        this.guessWord = genBlankLines(this.randWord);

    }
    public Hangman(String randWord, String guessWord){
        this.randWord = randWord;
        this.guessWord = guessWord;
    }
    public void updateGallows(int tries){
        
    }



    public String genBlankLines(String randWord){
        String blanks = "";
        for(int i = 0; i< randWord.length(); i++){
            blanks +="_";
        }
        return blanks;
    }

    // Grabs a random word from file containing a bunch of words
    public String genRandWord(){
        try{
            Path filePath = Paths.get("src/main/resources/wordlist.txt");//needs try catch
            Random rand = new Random();
            int randNum = rand.nextInt( (int)Files.lines(filePath).parallel().count() );

            int count = 0;
            for (String line : Files.readAllLines(filePath)) {
                if(count == randNum){
                    return line;
                }
                count++;
            }
            return "";
        }catch(Exception e){
            return "";
        }
    }

    public void updateGuess(String letter){
        if( !guessWord.contains(letter) && randWord.contains(letter) ){
            Pattern patt = Pattern.compile(letter);
            Matcher matcher = patt.matcher(randWord);

            // Finds all the indices of where there is an occurrence of letter in randWord and updates guessWord accordingly
            while(matcher.find()) {
                guessWord = guessWord.substring(0, matcher.start()) + letter + guessWord.substring(matcher.start()+1);
            }
        }
    }

//    public String gameResponse(String letter){
//        return ;
//    }

    public void runGame(){
        String guessLetter = "";
        System.out.println(guessWord);
        while(!guessWord.equals(randWord)){
            try{
                Scanner myObj = new Scanner(System.in);
                guessLetter = myObj.nextLine();
                updateGuess(guessLetter);
                System.out.println(guessWord);

            }catch (Exception e){
                System.out.println("idk");
            }
        }

    }

}
