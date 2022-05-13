
import com.example.gamegui.TileNode;
import javafx.embed.swing.JFXPanel;
import misc.Coord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static misc.Constants.SPRITE_DIMENSION;
import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    Coord testCoord;
    TileNode[][] test2DArr;
    JFXPanel fxPanel;

    @BeforeEach
    void setup(){
        fxPanel = new JFXPanel();// Having this fixes the 'Toolkit not initialized' exception for some reason

        testCoord = new Coord();// Defaults coordinate to 0,0
        test2DArr = new TileNode[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++) {
                test2DArr[i][j] = new TileNode(i,j,SPRITE_DIMENSION,true);
            }
        }
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
        assertTrue(testCoord.incrementX(test2DArr));
        assertEquals(1, testCoord.getTrueX());
        assertEquals(25, testCoord.getGuiX());

        assertFalse(testCoord.incrementX(test2DArr));
        assertEquals(1, testCoord.getTrueX());
        assertEquals(25, testCoord.getGuiX());

    }
    @Test
    void test_IncrementY() {
        assertTrue(testCoord.incrementY(test2DArr));
        assertEquals(1, testCoord.getTrueY());
        assertEquals(25, testCoord.getGuiY());

        assertFalse(testCoord.incrementY(test2DArr));
        assertEquals(1, testCoord.getTrueY());
        assertEquals(25, testCoord.getGuiY());
    }
    @Test
    void test_DecrementX() {
        assertFalse(testCoord.decrementX(test2DArr));
        assertEquals(0, testCoord.getTrueX());
        assertEquals(0, testCoord.getGuiX());
    }
    @Test
    void test_DecrementY() {
        assertFalse(testCoord.decrementY(test2DArr));
        assertEquals(0, testCoord.getTrueY());
        assertEquals(0, testCoord.getGuiY());
    }
}