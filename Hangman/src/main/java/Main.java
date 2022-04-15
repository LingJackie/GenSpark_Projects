import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    public static void main(String args[]) throws IOException {

        Hangman stuff = new Hangman("abigail", "_______", 0);
        stuff.startGame();

//            String gallows = "  +---+2\n3  |   |\n      |\n      |\n      |\n      |\n=========";
//
//            Gallows g = new Gallows(0);
//            System.out.println(g);
//
//        System.out.println(g.updateGallowsAscii());



    }
}
