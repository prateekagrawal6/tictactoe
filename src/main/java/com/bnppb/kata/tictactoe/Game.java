package com.bnppb.kata.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    String[][] ticTacToe;


    private String currentPlayer = "X";
    Scanner input;
    int noOfMoves = 0;

    public Game() {
        ticTacToe = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                ticTacToe[i][j] = "_";
            }
        }
    }

    public void switchPlayer() {
        setCurrentPlayer("X".equals(currentPlayer) ? "O" : "X");
    }

    public void run( Scanner scan ) {
        input = scan ;
        while ( true ) {
            System.out.print("Enter the position (1-9)");
            String inputPosition = input.next();
            noOfMoves++;
            checkPosition(inputPosition);
            showBoard();
            switchPlayer();
            if (isGameOver()){
                System.out.println(checkWin()+" Wins");
                break;
            }
        }
    }

    private boolean isGameOver() {
        return checkWin()!= null || noOfMoves > 8 ;
    }

    private String checkWin() {
        if ( ticTacToe[0][0] != "_" ){
            if ( ticTacToe[0][0].equals(ticTacToe[0][1]) && ticTacToe[0][0].equals(ticTacToe[0][2]) ){
                return ticTacToe[0][0];
            }
        }
        return null;
    }

    private void checkPosition ( String inputPosition ){
        switch ( inputPosition ) {
            case "1": ticTacToe[0][0] = currentPlayer;
                      break;
            case "2": ticTacToe[0][1] = currentPlayer;
                      break;
            case "3": ticTacToe[0][2] = currentPlayer;
                      break;
            case "4": ticTacToe[1][0] = currentPlayer;
                break;
            case "5": ticTacToe[1][1] = currentPlayer;
                break;
            case "6": ticTacToe[1][2] = currentPlayer;
                break;
            case "7": ticTacToe[2][0] = currentPlayer;
                break;
            case "8": ticTacToe[2][1] = currentPlayer;
                break;
            case "9": ticTacToe[2][2] = currentPlayer;
                break;
            default: System.out.println(" Please enter valid input ");
        }
    }

    public void showBoard ( ){
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (j!=2)
                    System.out.print(ticTacToe[i][j]+" | ");
                else
                    System.out.print(ticTacToe[i][j]);
            }
            System.out.println();
        }
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

}
