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
        assertEquals("X", game.getTicTacToe()[0][0]);
        assertEquals(1, game.getMoves().size());

        game.placeAtBoard("2");
        assertEquals("X", game.getTicTacToe()[0][1]);
        assertEquals(2, game.getMoves().size());

        game.placeAtBoard("3");
        assertEquals("X", game.getTicTacToe()[0][2]);
        assertEquals(3, game.getMoves().size());

        game.placeAtBoard("4");
        assertEquals("X", game.getTicTacToe()[1][0]);
        assertEquals(4, game.getMoves().size());

        game.placeAtBoard("5");
        assertEquals("X", game.getTicTacToe()[1][1]);
        assertEquals(5, game.getMoves().size());

        game.placeAtBoard("6");
        assertEquals("X", game.getTicTacToe()[1][2]);
        assertEquals(6, game.getMoves().size());

        game.placeAtBoard("7");
        assertEquals("X", game.getTicTacToe()[2][0]);
        assertEquals(7, game.getMoves().size());

        game.placeAtBoard("8");
        assertEquals("X", game.getTicTacToe()[2][1]);
        assertEquals(8, game.getMoves().size());

        game.placeAtBoard("9");
        assertEquals("X", game.getTicTacToe()[2][2]);
        assertEquals(9, game.getMoves().size());

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
    @DisplayName("Should find out correct winner-1")
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
    @DisplayName("Should find out correct winner-2")
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
    @DisplayName("Should find out correct winner-3")
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
    @DisplayName("Should find out correct winner-4")
    void checkWinner4() {
        Game game = new Game();
        game.initializeGame();

        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("2");
        game.switchPlayer();
        game.placeAtBoard("3");
        game.switchPlayer();
        game.placeAtBoard("7");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("8");
        game.switchPlayer();
        game.placeAtBoard("9");
        game.switchPlayer();
        game.placeAtBoard("6");
        game.switchPlayer();
        game.placeAtBoard("1");

        game.checkWinner();
        assertEquals("X", game.getWinner());
    }

    @Test
    @DisplayName("Should find out correct winner-5")
    void checkWinner5() {
        Game game = new Game();
        game.initializeGame();

        game.placeAtBoard("9");
        game.switchPlayer();
        game.placeAtBoard("8");
        game.switchPlayer();
        game.placeAtBoard("7");
        game.switchPlayer();
        game.placeAtBoard("6");
        game.switchPlayer();
        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("3");

        game.checkWinner();
        assertEquals("X", game.getWinner());
    }

    @Test
    @DisplayName("Should find out correct winner-6")
    void checkWinner6() {
        Game game = new Game();
        game.initializeGame();

        game.placeAtBoard("2");
        game.switchPlayer();
        game.placeAtBoard("1");
        game.switchPlayer();
        game.placeAtBoard("4");
        game.switchPlayer();
        game.placeAtBoard("3");
        game.switchPlayer();
        game.placeAtBoard("6");
        game.switchPlayer();
        game.placeAtBoard("5");
        game.switchPlayer();
        game.placeAtBoard("8");
        game.switchPlayer();
        game.placeAtBoard("7");

        game.checkWinner();
        assertEquals("O", game.getWinner());
    }

    @Test
    @DisplayName("Should Draw when out of moves")
    void checkDraw() {
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