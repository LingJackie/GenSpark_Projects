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
        testGame2 = new Hangman("racecar","_______", 0);
    }


    @Test
    void test_genBlankLines() {
        assertEquals("______", testGame1.genBlankLines("jackie"));
        assertEquals("_", testGame1.genBlankLines("a"));
    }

    @Test
    void test_genRandWord_word_generate_not_empty() {
        assertFalse(testGame1.genRandWord().length() == 0);
    }

    @Test
    void test_updateGuess(){
        testGame2.updateGuessBlanks("r");
        assertEquals("r_____r", testGame2.getGuessWord());

        testGame2.updateGuessBlanks("e");
        assertEquals("r__e__r", testGame2.getGuessWord());
    }

    @Test
    void test_makeGuess_bad_inputs(){
        assertEquals("One guess at a time, please.", testGame2.makeGuess("afsd"));
        assertEquals("Invalid Input.", testGame2.makeGuess("%"));
    }
    @Test
    void test_makeGuess_incorrect_guess(){
        assertEquals("One guess at a time, please.", testGame2.makeGuess("afsd"));
        assertEquals("Invalid Input.", testGame2.makeGuess("%"));
    }
}