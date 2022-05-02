import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GallowsTest {

    Gallows testGallows;

    @BeforeEach
    void setUp(){
        testGallows = new Gallows(0);
        
    }

    @Test
    void test_readFile() {
        assertEquals(49, testGallows.getGallowsList().size());
    }

    @Test
    void test_incrementState_from_0_to_6() {
        assertEquals("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(1, testGallows.getState());

        assertEquals("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(2, testGallows.getState());

        assertEquals("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(3, testGallows.getState());

        assertEquals("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(4, testGallows.getState());

        assertEquals("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(5, testGallows.getState());

        assertEquals("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========\n", testGallows.incrementState());
        assertEquals(6, testGallows.getState());
    }



}