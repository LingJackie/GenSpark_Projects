import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

class DragonCaveTest {
    DragonCave testCave;

    @BeforeEach
    void setUp(){
        testCave = new DragonCave();
    }

    @Test
    void startingMessage() {
        assertEquals("You are in a land full of dragons. In front of you,\n" +
                "you see 2 caves. In one cave, the dragon is friendly \n" +
                "an will share his treasure with you. The other dragon \n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)", testCave.startingMessage());
    }

    @Test
    void makeChoice() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals("You approach the cave...\n" +
                "It's dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!", testCave.makeChoice());
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertEquals("You approach the cave...\n" +
                "It's well lit.\n" +
                "A large dragon jumps out from his two floor cottage!\n" +
                "He hands you 5 runes and tells you to get off his property.", testCave.makeChoice());
    }


}