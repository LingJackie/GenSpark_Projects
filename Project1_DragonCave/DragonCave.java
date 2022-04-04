import java.util.Scanner;

public class DragonCave {

    public static void main(String args[]) {
        System.out.print("You are in a land full of dragons. In front of you,\n" +
                "you see 2 caves. In one cave, the dragon is friendly \n" +
                "an will share his treasure with you. The other dragon \n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String choice = myObj.nextLine();  // Read user input

        if(choice.equals("1")){
            System.out.println("You approach the cave...\n" +
                    "It's dark and spooky...\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "Gobbles you down in one bite!");
        }else{
            System.out.println("You approach the cave...\n" +
                    "It's well lit.\n" +
                    "A large dragon jumps out from his two floor cottage!\n" +
                    "He hands you 5 runes and tells you to get off his property.");
        }


    }
}