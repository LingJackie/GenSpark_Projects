import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {

//        Hangman stuff = new Hangman("abigail", "_______", 0,"player");
//        stuff.startGame();

        Hangman game = new Hangman();
        game.startGame();

//        try{
//            List<String> words = Files.readAllLines(Paths.get("src/main/resources/gallows2.txt"));
//           System.out.print(words.stream().reduce("", (partialGallows, elem) -> partialGallows+elem+"\n"));
//        }catch (IOException e) {
//        }

    }
}
