package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "Petya", 7);
    Player player2 = new Player(2, "Vanya", 8);
    Player player3 = new Player(3, "Sasha", 9);
    Player player4 = new Player(4, "Ilya", 10);
    Player player5 = new Player(5, "Sergei", 10);
    Player playerNull = null;

    @Test
    void addPlayer() {
        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        List<Player> expected = Arrays.asList(player1, player2, player3, player4, player5);
        List<Player> actual = game.getRegisteredPlayers();

        assertEquals(expected, actual);
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
}




