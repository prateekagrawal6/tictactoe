package com.bnppb.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

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

    @Test
    @DisplayName("Should valid input")
    void isValidInput() {
        Game game = new Game();

        assertFalse(game.isValidInput("66"));
        assertFalse(game.isValidInput("ab"));
        assertFalse(game.isValidInput("#@"));

        assertTrue(game.isValidInput("1"));
        assertTrue(game.isValidInput("9"));
    }

    @Test
    @DisplayName("Should valid place on board correct by position (1-9)")
    void placeAtBoard() {
        Game game = new Game();
        game.initializeGame();

        game.placeAtBoard("1");
        game.placeAtBoard("2");
        game.placeAtBoard("3");
        game.placeAtBoard("4");
        game.placeAtBoard("5");
        game.placeAtBoard("6");
        game.placeAtBoard("7");
        game.placeAtBoard("8");
        game.placeAtBoard("9");

        assertEquals("X", game.getTicTacToe()[0][0]);
        assertEquals("X", game.getTicTacToe()[0][1]);
        assertEquals("X", game.getTicTacToe()[0][2]);
        assertEquals("X", game.getTicTacToe()[1][0]);
        assertEquals("X", game.getTicTacToe()[1][1]);
        assertEquals("X", game.getTicTacToe()[1][2]);
        assertEquals("X", game.getTicTacToe()[2][0]);
        assertEquals("X", game.getTicTacToe()[2][1]);
        assertEquals("X", game.getTicTacToe()[2][2]);
    }

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
    @DisplayName("Should find out correct winner")
    void checkWinner() {
        Game game = new Game();
        game.initializeGame();


        game.placeAtBoard("1");
        game.placeAtBoard("2");

        game.checkWinner();
        assertNull(game.getWinner());

        game.placeAtBoard("3");
        game.checkWinner();

        assertEquals("X", game.getWinner());
    }

    @Test
    @DisplayName("Should find out correct winner - when X starts")
    void checkWinner2() {
        Game game = new Game();
        game.initializeGame();

        game.placeAtBoard("1");
        game.switchPlayer();
        game.placeAtBoard("2");
        game.switchPlayer();
        game.placeAtBoard("3");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("6");
        game.switchPlayer();
        game.placeAtBoard("7");

        game.checkWinner();
        assertEquals("X", game.getWinner());
    }

    @Test
    @DisplayName("Should find out correct winner - when O starts")
    void checkWinner3() {
        Game game = new Game();
        game.initializeGame();

        game.switchPlayer();
        game.placeAtBoard("1");
        game.switchPlayer();
        game.placeAtBoard("2");
        game.switchPlayer();
        game.placeAtBoard("3");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("6");
        game.switchPlayer();
        game.placeAtBoard("7");

        game.checkWinner();
        assertEquals("O", game.getWinner());
    }

    @Test
    @DisplayName("Should Draw when out of moves")
    void checkWinner4() {
        Game game = new Game();
        game.initializeGame();


        game.placeAtBoard("1");
        game.switchPlayer();
        game.placeAtBoard("3");
        game.switchPlayer();
        game.placeAtBoard("9");
        game.switchPlayer();
        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("7");
        game.switchPlayer();
        game.placeAtBoard("8");
        game.switchPlayer();
        game.placeAtBoard("2");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("6");

        game.checkWinner();
        assertNull(game.getWinner());
        assertEquals(9, game.getMoves().size());
    }




}