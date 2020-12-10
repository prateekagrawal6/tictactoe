package com.bnppb.kata.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private String[][] ticTacToe;
    private String currentPlayer;
    private String winner;
    private ArrayList<String> moves;


    public void initializeGame() {
        // Filling board with Empty value (just to make it looks good)
        ticTacToe = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = "_";
            }
        }

        // assigning current player X as per rule
        currentPlayer = "X";

        // rest winner
        winner = null;

        // rest moves for a fresh start
        moves = new ArrayList();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the position(1-9) for " + currentPlayer + " : ");
            String inputPosition = scanner.next().trim();
            if (!isValidInput(inputPosition)) {
                System.out.println("Invalid value");
                continue;
            }
            if (moves.contains(inputPosition)) {
                System.out.println("Oops! Position " + inputPosition + " is already occupied..please select another");
                continue;
            }

            placeAtBoard(inputPosition);
            showBoard();
            switchPlayer();

            if (moves.size() > 4)
                checkWinner();

            if (winner != null) {
                System.out.println("Woohoo! " + winner + " Wins!!");
                break;
            }
            if (moves.size() > 8) {
                System.out.println("It's a DRAW!! Well played..");
                break;
            }
        }
    }

    public boolean isValidInput(String input) {
        return Arrays.stream(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}).anyMatch(x -> x.equals(input));
    }

    private void placeAtBoard(String inputPosition) {
        switch (inputPosition) {
            case "1":
                ticTacToe[0][0] = currentPlayer;
                moves.add("1");
                break;
            case "2":
                ticTacToe[0][1] = currentPlayer;
                moves.add("2");
                break;
            case "3":
                ticTacToe[0][2] = currentPlayer;
                moves.add("3");
                break;
            case "4":
                ticTacToe[1][0] = currentPlayer;
                moves.add("4");
                break;
            case "5":
                ticTacToe[1][1] = currentPlayer;
                moves.add("5");
                break;
            case "6":
                ticTacToe[1][2] = currentPlayer;
                moves.add("6");
                break;
            case "7":
                ticTacToe[2][0] = currentPlayer;
                moves.add("7");
                break;
            case "8":
                ticTacToe[2][1] = currentPlayer;
                moves.add("8");
                break;
            case "9":
                ticTacToe[2][2] = currentPlayer;
                moves.add("9");
                break;
        }
    }

    public void showBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTacToe[i][j] + (j != 2 ? " | " : ""));
            }
            System.out.println();
        }
    }

    public void switchPlayer() {
        setCurrentPlayer("X".equals(currentPlayer) ? "O" : "X");
    }

    private void checkWinner() {
        if (ticTacToe[0][0].equals(ticTacToe[0][1]) && ticTacToe[0][0].equals(ticTacToe[0][2])) {
            winner = ticTacToe[0][0];
        } else if (ticTacToe[0][2].equals(ticTacToe[1][2]) && ticTacToe[0][2].equals(ticTacToe[2][2])) {
            winner = ticTacToe[0][2];
        } else if (ticTacToe[2][0].equals(ticTacToe[2][1]) && ticTacToe[2][0].equals(ticTacToe[2][2])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[2][0].equals(ticTacToe[1][0]) && ticTacToe[2][0].equals(ticTacToe[0][0])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[2][0].equals(ticTacToe[1][1]) && ticTacToe[2][0].equals(ticTacToe[0][2])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[0][0].equals(ticTacToe[1][1]) && ticTacToe[0][0].equals(ticTacToe[2][2])) {
            winner = ticTacToe[0][0];
        } else if (ticTacToe[0][1].equals(ticTacToe[1][1]) && ticTacToe[0][1].equals(ticTacToe[2][1])) {
            winner = ticTacToe[0][1];
        } else if (ticTacToe[1][0].equals(ticTacToe[1][1]) && ticTacToe[1][0].equals(ticTacToe[1][2])) {
            winner = ticTacToe[1][0];
        }
        if (winner == "_")
            winner = null;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

}
