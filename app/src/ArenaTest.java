import main.Arena;
import main.Player;
import main.Dice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArenaTest {

    private Player player1;
    private Player player2;
    private Player player3;
    private Arena arena;
    private Dice dice;

    @Before
    public void setUp() {
        player1 = new Player("Alice", 100, 5, 5);
        player2 = new Player("Bob", 100, 10, 10);
        player3 = new Player("Messi", 1, 10, 10);

        arena = new Arena();
        arena.addPlayer(player1);
        arena.addPlayer(player2);
        arena.addPlayer(player3);

        dice = new Dice(1);
        arena.setDice(dice);
    }

    @Test
    public void testInitialPlayers() {
        assertEquals(3, arena.getPlayers().size());
    }

    @Test
    public void testDiceRoll() {
        int roll = dice.rollDice();
        assertTrue(roll >= 1 && roll <= 6);
    }

    @Test
    public void testStartGame() {
        arena.startGame();
        assertEquals(1, arena.getPlayers().size());
        Player winner = arena.getPlayers().get(0);
        assertTrue(winner.getName().equals("Alice") || winner.getName().equals("Bob") || winner.getName().equals("Messi"));
    }

    @Test
    public void testPlayerAttributes() {
        assertEquals("Alice", player1.getName());
        assertEquals(100, player1.getHealth());
        assertEquals(5, player1.getStrength());
        assertEquals(5, player1.getAttack());
    }

    @Test
    public void testPlayerHealthReduction() {
        player1.setHealth(50);
        assertEquals(50, player1.getHealth());
        player1.setHealth(20);
        assertEquals(20, player1.getHealth());
    }

    @Test
    public void testPlayerElimination() {
        player1.setHealth(0);
        assertFalse(player1.isAlive(player1.getHealth()));
    }
}
