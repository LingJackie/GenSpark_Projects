import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String args[]) {
        Scanner nameObj = new Scanner(System.in);
        Scanner numObj = new Scanner(System.in);
        Scanner playAgainObj = new Scanner(System.in);

        Random rand = new Random();
        int randnum; //random number between 1 and 20
        int tries; //tries used
        int guessnum; //the guessed number

        System.out.println("Hello! What is your name?");
        String name = nameObj.nextLine();

        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");


        Boolean again = true;

        while(again) {
            randnum = rand.nextInt(20) + 1;
            tries = 0;
            guessnum= -1;

            while (randnum != guessnum && tries < 6) {
                System.out.println("Take a Guess.");
                guessnum = Integer.parseInt(numObj.nextLine());
                tries++;
                if (guessnum > randnum) {
                    System.out.println("Your guess is too high.");
                } else if (guessnum < randnum) {
                    System.out.println("Your guess is too low.");
                } else if (randnum == guessnum) {
                    System.out.println("Good job, " + name + "! You guessed my number in " + tries + " guesses!");
                }if (tries == 6) {
                    System.out.println("You ran out of tries");
                }
            }
            System.out.println("Would you like to play again?(y or n)");
            again = playAgainObj.nextLine().equals("y");
        }

    }
}
