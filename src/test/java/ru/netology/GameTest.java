package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "Petya", 7);
    Player player2 = new Player(2, "Vanya", 8);
    Player player3 = new Player(3, "Sasha", 9);
    Player player4 = new Player(4, "Ilya", 10);
    Player player5 = new Player(5, "Sergei", 10);

    @Test
    void addPlayer() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        Map<String, Player> expected = new HashMap<>();
        expected.put("Petya", player1);
        expected.put("Vanya", player2);
        expected.put("Sasha", player3);
        expected.put("Ilya", player4);
        expected.put("Sergei", player5);

        assertEquals(expected, game.registeredPlayers);
    }

    @Test
    void addPlayerNull() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        assertThrows(IllegalArgumentException.class, () -> game.addPlayer(null));
    }

    @Test
    void addAddedPlayer() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);

        assertThrows(IllegalArgumentException.class, () -> game.addPlayer(player1));
    }

    @Test
    void shouldFindByName() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);


        assertEquals(player3, game.findByName("Sasha"));
    }

    @Test
    void shouldFindByNameNull() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);


        assertThrows(IllegalArgumentException.class, () -> game.findByName(null));
    }

    @Test
    void shouldWinnerSecond() {
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

        assertEquals(2, game.round("Petya", "Vanya"));
    }

    @Test
    void shouldWinnerFirst() {
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

        assertEquals(1, game.round("Vanya", "Petya"));
    }

    @Test
    void shouldWinnerDraw() {
        Game game = new Game();
        game.addPlayer(player4);
        game.addPlayer(player5);

        assertEquals(0, game.round("Ilya", "Sergei"));
    }

    @Test
    void notRegisteredExceptionSecond() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);


        assertThrows(IllegalArgumentException.class, () -> game.round("Ilya", "Alik"));
    }

    @Test
    void notRegisteredExceptionFirst() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        assertThrows(IllegalArgumentException.class, () -> game.round("Alik", "Ilya"));
    }

    @Test
    void hashCodeShouldBeDifferentForDifferentObjects() {
        assertNotEquals(player1.hashCode(), player2.hashCode());
        assertEquals(player1.hashCode(), player1.hashCode());

    }

    @Test
    public void testEquals_SameObject() {
        Player player = new Player(1, "Player1", 100);
        assertEquals(player, player);
    }

    @Test
    public void testEquals_EqualObjects() {
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(1, "Player1", 100);
        assertEquals(player1, player2);
    }

    @Test
    public void testEquals_DifferentId() {
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player1", 100);
        assertNotEquals(player1, player2);
    }

    @Test
    public void testEquals_DifferentName() {
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(1, "Player2", 100);
        assertNotEquals(player1, player2);
    }

    @Test
    public void testEquals_DifferentStrength() {
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(1, "Player1", 120);
        assertNotEquals(player1, player2);
    }

    @Test
    public void testEquals_NullObject() {
        Player player = new Player(1, "Player1", 100);
        assertNotEquals(null, player);
    }
}




