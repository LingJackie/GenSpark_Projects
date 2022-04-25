import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    Tile testTile;
    final String CROSSED_SWORDS_EMOJI = "\u2694";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";

    @BeforeEach
    void setUp() {
        testTile = new Tile("=");
    }

    @Test
    void toggleCombatMarker_toggle_On_and_toggle_off() {
        assertEquals(ANSI_RED+CROSSED_SWORDS_EMOJI+ANSI_RESET,testTile.toggleCombatMarker());
        assertEquals("=",testTile.toggleCombatMarker());
    }
    @Test
    void set_and_clear_actor_icon(){
        assertEquals("3",testTile.setActorIcon("3"));
        assertEquals("=",testTile.clearActorIcon());
    }
}