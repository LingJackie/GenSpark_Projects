import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumansVsGoblinsTest {
    HumansVsGoblins test_game;

    @BeforeEach
    void setUp() {
        test_game = new HumansVsGoblins(2,0);// Should create a world of size 2 x 4
    }

    @Test
    void test_player_move_out_of_bounds(){
        // Spawn point is at 0,0 top left of map
        assertEquals("You cannot go that way.", test_game.movePlayer("n"));
        assertEquals("You cannot go that way.", test_game.movePlayer("w"));
    }

    @Test
    void test_checkCombat_true(){
        // Combat starts when a player and goblin both occupy the same tile
        Goblin testGoblin1 = new Goblin();
        test_game.addGoblin(testGoblin1);
        testGoblin1.setLocation(0,0);
        assertTrue(test_game.checkCombatStart());
    }

    @Test
    void test_deathHandler_goblin_dies(){
        Goblin testGoblin1 = new Goblin();// Default creates goblin with 3 in all stats
        testGoblin1.takeDamage(30);// Kills it
        assertEquals("goblin has died.", test_game.deathHandler(testGoblin1));
    }

    @Test
    void test_deathHandler_player_dies(){
        test_game.getPlayer().takeDamage(50);// Default player has 5 in all stats; 5*10 = 50 health
        // Default human name is Steve
        assertEquals("Steve has died.\nGAME OVER", test_game.deathHandler(test_game.getPlayer()));
    }

}