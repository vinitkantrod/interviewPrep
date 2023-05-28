package com.vinit.design.problems.tictactoe.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

    Board board;
    Deque<Player> queue;
    public TicTacToeGame() {
        initialiseGame();
    }

    public void initialiseGame() {
        board = new Board(3);
        PlayingPeice cross = new CrossPeice();
        Player p1 = new Player("1", cross);
        PlayingPeice round = new RoundPeice();
        Player p2 = new Player("2", round);
        queue = new LinkedList<>();
        queue.add(p1);
        queue.add(p2);
    }

    public String startGame() {
        Boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = queue.getFirst();
            queue.pollFirst();
            System.out.println("Player Turn: " + playerTurn.name);
            board.printBoard();
            if (!board.isSpotAvailable()) {
                noWinner = false;
                continue;
            }
            // read user input
            System.out.print("Player " + playerTurn.name + " Enter row, column(Comma seperated value): ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] val = s.trim().split(",");
            int row = Integer.valueOf(val[0]);
            int col = Integer.valueOf(val[1]);
            // Place the peice
            Boolean peiceAddedSuccessfully = board.addPeice(row, col, playerTurn.playingPeice);
            if (!peiceAddedSuccessfully) {
                System.out.println("Incorrect position. Try again");
                queue.addFirst(playerTurn);
                continue;
            }
            queue.addLast(playerTurn);
            Boolean winner = isThereAWinner(row, col, playerTurn.playingPeice);
            if (winner) {
                System.out.println("Winner is " + playerTurn.name);
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public Boolean isThereAWinner(int row, int col, PlayingPeice p) {
        // check row
        Boolean rowMatch = true;
        Boolean diagonalMatch = true;
        Boolean colMatch = true;
        Boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col] == null || board.board[i][col].peiceType != p.peiceType) {
                rowMatch = false;
            }
        }
        // Check Col
        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].peiceType != p.peiceType) {
                colMatch = false;
            }
        }
        // check diagonal
        for (int i = 0, j = 0; i < board.size; i++, j++) {
            if (board.board[i][j] == null || board.board[i][j].peiceType != p.peiceType) {
                diagonalMatch = false;
            }
        }
        // check anti-diagonal
        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].peiceType != p.peiceType) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
