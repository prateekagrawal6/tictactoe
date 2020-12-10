package com.bnppb.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    @DisplayName("Should Switch the player")
    void switchPlayer() {
        Game fresh = new Game();
        fresh.setCurrentPlayer("X");
        assertEquals("X",fresh.getCurrentPlayer());
        fresh.switchPlayer();
        assertEquals("O",fresh.getCurrentPlayer());
        fresh.switchPlayer();
        assertEquals("X",fresh.getCurrentPlayer());
    }
}