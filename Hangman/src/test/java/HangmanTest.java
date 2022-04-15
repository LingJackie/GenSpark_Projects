import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

class HangmanTest {
    Hangman testGame1;
    Hangman testGame2;

    @BeforeEach
    void setUp() {
        testGame1 = new Hangman();
        testGame2 = new Hangman("racecar","_______");
    }

    @Test
    void genBlankLines() {
        assertEquals("______", testGame1.genBlankLines("jackie"));
        assertEquals("", testGame1.genBlankLines(""));
    }

    @Test
    void genRandWord() {
        assertFalse(testGame1.genRandWord().length() == 0);
    }

    @Test
    void updateGuess(){
        testGame2.updateGuess("r");
        assertEquals("r_____r", testGame2.getGuessWord());

        testGame2.updateGuess("e");
        assertEquals("r__e__r", testGame2.getGuessWord());
    }
}