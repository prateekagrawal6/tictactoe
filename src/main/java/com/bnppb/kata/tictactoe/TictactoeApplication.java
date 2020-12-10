package com.bnppb.kata.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);
		//char[][] ticTacToe = new char[3][3];
		//ticTacToe = new char[][]{{'X', 'O', 'X'},{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}};
		Scanner scanner = new Scanner(System.in);
		TictactoeApplication.printMenu();
		String input = scanner.next();
//		while ( !input.equalsIgnoreCase("2")) {
//			switch ( input ) {
//				case "1":
					Game fresh = new Game();
					fresh.showBoard();
					fresh.run(scanner);
//			}
//			TictactoeApplication.printMenu();
//			input = scanner.next();
//		};


	}

	public static void printMenu( ) {
		System.out.println("Welcome to BNPPF KATA Tic Tac Toe");
		System.out.println("Rules for this game are as follows: ");
		System.out.println("1. Player 1: X always goes first");
		System.out.println("2. Players cannot play on a played position");
		System.out.println("3. Players can play alternatively until one of them WINS the game or it leads to a DRAW");
		System.out.println("4. A Player is said to WIN only if they have 3 X's or O's in a row completed");
		System.out.println("5. Game is said to be DRAW if the players exhausts all the 9 positions");
		System.out.println("6. You need to input your position starting from 1 till 9, where 1 is top left corner and 9 being bottom right corner");
		System.out.println("Please select from the below menu to proceed.");
		System.out.println("1. Start the game ");
		System.out.println("2. Exit ");
	}

}
