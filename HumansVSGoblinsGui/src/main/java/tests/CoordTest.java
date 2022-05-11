package tests;
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
}