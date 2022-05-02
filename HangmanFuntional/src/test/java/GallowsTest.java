import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GallowsTest {

    Gallows testGallows;
    String[] defaultGallows = new String[]{"  +---+\n  |   |\n      |\n      |\n      |\n      |\n========="};

    @BeforeEach
    void setUp(){
        testGallows = new Gallows(0);
        
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

    @Test
    void test_updateGallowsAscii_set_state_to_6() {
        testGallows.setState(6);
        assertEquals("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========\n", testGallows.updateGallowsAscii());
        assertEquals(6, testGallows.getState());
    }


    @Test
    void test_addLimb_state_neg_1() {
        testGallows.addLimb(-1);
        assertEquals("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_1() {
        testGallows.addLimb(1);
        assertEquals("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_2() {
        testGallows.addLimb(2);
        assertEquals("  +---+\n  |   |\n      |\n  |   |\n      |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_3() {
        testGallows.addLimb(3);
        assertEquals("  +---+\n  |   |\n      |\n /|   |\n      |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_4() {
        testGallows.addLimb(4);
        assertEquals("  +---+\n  |   |\n      |\n /|\\  |\n      |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_5() {
        testGallows.addLimb(5);
        assertEquals("  +---+\n  |   |\n      |\n      |\n /    |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_6() {
        testGallows.addLimb(6);
        assertEquals("  +---+\n  |   |\n      |\n      |\n / \\  |\n      |\n=========\n", testGallows.toString());
    }
    @Test
    void test_addLimb_state_20() {
        testGallows.addLimb(20);
        assertEquals("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========\n", testGallows.toString());
    }


}