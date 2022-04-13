import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {
    GuessTheNumber testGame;
    ByteArrayOutputStream printedLine;

    @BeforeEach
    void setUp() {
        this.testGame = new GuessTheNumber();

        this.printedLine = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printedLine));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void greeting() {
        System.setIn(new ByteArrayInputStream("Jackie".getBytes()));
        assertEquals("Well, Jackie, I am thinking of a number between 1 and 20.", this.testGame.greeting());
    }

    @Test
    void guessResponse() {
        testGame.setUpNewGame(10, 0, true);
        assertEquals("Your guess is too high.", testGame.guessResponse(11) );
        assertEquals("Your guess is too low.", testGame.guessResponse(9) );

        testGame.setTries(6);
        assertEquals("You ran out of tries", testGame.guessResponse(9) );

        testGame.setTries(0);
        assertEquals("Good job, ! You guessed my number in 0 guesses!", testGame.guessResponse(10) );
    }

    @Test
    void replay() {
        System.setIn(new ByteArrayInputStream("y".getBytes()));
        this.testGame.replay();
        assertTrue(this.testGame.isContinueGame());

        System.setIn(new ByteArrayInputStream("n".getBytes()));
        this.testGame.replay();
        assertFalse(this.testGame.isContinueGame());

        System.setIn(new ByteArrayInputStream("bananna".getBytes()));
        this.testGame.replay();
        assertFalse(this.testGame.isContinueGame());

    }
}