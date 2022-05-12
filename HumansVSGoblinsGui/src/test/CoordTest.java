
import misc.Coord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    Coord testCoord;

    @BeforeEach
    void setup(){
        testCoord = new Coord();
    }

    @Test
    void test_setX_to_1() {
        testCoord.setX(1);
        assertEquals(25, testCoord.getGuiX());
    }
    @Test
    void test_setY_to_1() {
        testCoord.setY(1);
        assertEquals(25, testCoord.getGuiY());
    }


    @Test
    void test_IncrementX() {
        testCoord.incrementX();
        assertEquals(25, testCoord.getGuiX());
    }
    @Test
    void test_IncrementY() {
        testCoord.incrementY();
        assertEquals(25, testCoord.getGuiY());
    }
    @Test
    void test_DecrementX() {
        testCoord.decrementX();
        assertEquals(-25, testCoord.getGuiX());
    }
    @Test
    void test_DecrementY() {
        testCoord.decrementY();
        assertEquals(-25, testCoord.getGuiY());
    }
}