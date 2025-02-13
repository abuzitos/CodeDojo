package org.codedojo.projetoIA.tennis;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    @Test
    public void testInitialScore() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When the game starts
        // Then the score should be "Love - Love"
        assertEquals("Love - Love", game.getScore());
    }

    @Test
    public void testPlayer1ScoresFirstPoint() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When player 1 scores the first point
        game.addPointPlayer1();
        // Then the score should be "Fifteen - Love"
        assertEquals("Fifteen - Love", game.getScore());
    }

    @Test
    public void testPlayer2ScoresFirstPoint() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When player 2 scores the first point
        game.addPointPlayer2();
        // Then the score should be "Love - Fifteen"
        assertEquals("Love - Fifteen", game.getScore());
    }

    @Test
    public void testPlayersAreTied() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score one point each
        game.addPointPlayer1();
        game.addPointPlayer2();
        // Then the score should be "Fifteen - Fifteen"
        assertEquals("Fifteen - Fifteen", game.getScore());
    }

    @Test
    public void testPlayer1WinsGame() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When player 1 scores four points
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        // Then the score should be "Game Player 1"
        assertEquals("Game Player 1", game.getScore());
    }

    @Test
    public void testPlayer2WinsGame() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When player 2 scores four points
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        // Then the score should be "Game Player 2"
        assertEquals("Game Player 2", game.getScore());
    }

    @Test
    public void testDeuce() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score three points each
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        // Then the score should be "Deuce"
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void testAdvantagePlayer1() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score three points each and player 1 scores one more point
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer1();
        // Then the score should be "Advantage Player 1"
        assertEquals("Advantage Player 1", game.getScore());
    }

    @Test
    public void testAdvantagePlayer2() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score three points each and player 2 scores one more point
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        // Then the score should be "Advantage Player 2"
        assertEquals("Advantage Player 2", game.getScore());
    }

    @Test
    public void testPlayer1WinsAfterAdvantage() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score three points each, player 1 scores one more point, and then player 1 scores another point
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer1();
        game.addPointPlayer1();
        // Then the score should be "Game Player 1"
        assertEquals("Game Player 1", game.getScore());
    }

    @Test
    public void testPlayer2WinsAfterAdvantage() {
        // Given a new tennis game
        TennisGame game = new TennisGame();
        // When both players score three points each, player 2 scores one more point, and then player 2 scores another point
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer1();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        game.addPointPlayer2();
        // Then the score should be "Game Player 2"
        assertEquals("Game Player 2", game.getScore());
    }
}
