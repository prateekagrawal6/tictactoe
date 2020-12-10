package com.bnppb.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}