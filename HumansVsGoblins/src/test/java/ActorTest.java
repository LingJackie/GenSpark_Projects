import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class ActorTest {
    Actor testPlayer1;
    Actor testGoblin1;

    @BeforeEach
    void setUp() {
        testPlayer1 = new Human("test_player1",5,5,5, true);
        testGoblin1 = new Goblin("test_goblin1",3,3,3);

    }

    @Test// Player strength = 5; diceRoll = 5; Total attack power = 10
    void test_attack(){
        assertEquals("test_player1 attacks test_goblin1\ntest_goblin1 takes 10 damage.",testPlayer1.attack(testGoblin1,5));
    }

    @Test
    void test_displayHealthBar_goblin_after_taking_10_damage(){
        testGoblin1.takeDamage(10);
        assertEquals(ColorAndEmoji.ANSI_PURPLE+"\uD83D\uDE08"+ ColorAndEmoji.ANSI_RESET+ " test_goblin1\n" +
                "HP:"+ColorAndEmoji.ANSI_RED+"#####"+ ColorAndEmoji.ANSI_RESET+"++ 20/30",testGoblin1.displayHealthBar());
    }
    @Test
    void test_displayHealthBar_goblin_after_taking_20_damage(){
        testGoblin1.takeDamage(20);
        assertEquals(ColorAndEmoji.ANSI_PURPLE+"\uD83D\uDE08"+ ColorAndEmoji.ANSI_RESET+ " test_goblin1\n" +
                "HP:"+ColorAndEmoji.ANSI_RED+"###"+ ColorAndEmoji.ANSI_RESET+"++++ 10/30",testGoblin1.displayHealthBar());
    }


    /*MOVEMENT TESTS*/
    @Test
    void test_player_move_north(){
        assertEquals("test_player1 moves north.",testPlayer1.move("n"));
        assertEquals(-1,testPlayer1.getX());
        assertEquals(0,testPlayer1.getY());
    }
    @Test
    void test_player_move_south(){
        assertEquals("test_player1 moves south.",testPlayer1.move("s"));
        assertEquals(1,testPlayer1.getX());
        assertEquals(0,testPlayer1.getY());
    }
    @Test
    void test_player_move_east(){
        assertEquals("test_player1 moves east.",testPlayer1.move("e"));
        assertEquals(0,testPlayer1.getX());
        assertEquals(1,testPlayer1.getY());
    }
    @Test
    void test_player_move_west(){
        assertEquals("test_player1 moves west.",testPlayer1.move("w"));
        assertEquals(0,testPlayer1.getX());
        assertEquals(-1,testPlayer1.getY());
    }
    @Test
    void test_player_move_incorrect_input(){
        assertEquals("test_player1 stays put.",testPlayer1.move("hdgff"));
    }
}