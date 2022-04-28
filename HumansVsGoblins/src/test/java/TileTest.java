import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    Tile testTile;

    @BeforeEach
    void setUp() {
        testTile = new Tile("=");
    }

    @Test
    void toggleCombatMarker_toggle_On_and_toggle_off() {
        assertEquals(ColorAndEmoji.ANSI_RED+ ColorAndEmoji.CROSSED_SWORDS_EMOJI+ ColorAndEmoji.ANSI_RESET,testTile.toggleCombatMarker());
        assertEquals("=",testTile.toggleCombatMarker());
    }
    @Test
    void set_and_clear_actor_icon(){
        assertEquals("3",testTile.setActorIcon("3"));
        assertEquals("=",testTile.clearActorIcon());
    }
}