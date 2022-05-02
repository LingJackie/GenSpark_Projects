import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {

//        Hangman stuff = new Hangman("abigail", "_______", 0);
//        stuff.startGame();

//        Hangman game = new Hangman();
//        game.startGame();
        Gallows testy = new Gallows(0);
        ArrayList<String> adasd= testy.getGallowsList();
        System.out.println(testy.incrementState());


    }
}
