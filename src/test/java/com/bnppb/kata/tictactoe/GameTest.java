package com.bnppb.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    @DisplayName("Should Switch the player")
    void switchPlayer() {
        Game game = new Game();

        game.setCurrentPlayer("X");
        assertEquals("X", game.getCurrentPlayer());

        game.switchPlayer();
        assertEquals("O", game.getCurrentPlayer());

        game.switchPlayer();
        assertEquals("X", game.getCurrentPlayer());
    }

    @Test
    @DisplayName("Should initialize the board")
    void initializeGame1() {

        Game game = new Game();
        String[][] boardBefore = game.getTicTacToe();

        game.initializeGame();
        String[][] boardAfter = game.getTicTacToe();

        assertNull(boardBefore);
        assertTrue(boardAfter != null);
        assertEquals("_", boardAfter[2][0]);


    }

    @Test
    @DisplayName("Should initialize the current player and rest moves")
    void initializeGame2() {

        Game game = new Game();
        String currentPlayerBefore = game.getCurrentPlayer();
        ArrayList<String> movesBefore = game.getMoves();

        game.initializeGame();

        String currentPlayerAfter = game.getCurrentPlayer();
        ArrayList<String> movesAfter = game.getMoves();

        assertNull(currentPlayerBefore);
        assertNull(movesBefore);
        assertEquals("X", currentPlayerAfter);
        assertEquals(0, movesAfter.size());

    }
}