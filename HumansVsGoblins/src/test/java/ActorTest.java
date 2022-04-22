import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class ActorTest {
    Actor testPlayer1;
    Actor testGoblin1;

    @BeforeEach
    void setUp() {
        testPlayer1 = new Human("test_player1",5,5,5);
        testGoblin1 = new Goblin("test_goblin1",5,5,5);

    }

    @Test
    void attack(){
        assertEquals("test_player1 attacks test_goblin1\ntest_goblin1 takes 10 damage.",testPlayer1.attack(testGoblin1));
    }


}