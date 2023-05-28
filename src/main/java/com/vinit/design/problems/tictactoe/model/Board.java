package com.vinit.design.problems.tictactoe.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    int size;
    PlayingPeice[][] board;

    Board(int size) {
        this.size = size;
        this.board = new PlayingPeice[size][size];
    }

    public Boolean addPeice(int row, int col, PlayingPeice p) {
        if (board[row][col] != null) return false;
        board[row][col] = p;
        printBoard();
        return true;
    }
    public Boolean isSpotAvailable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("TIC - TAC - TOE Board...");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print("  " + board[i][j].peiceType.name() + "  ");
                } else {
                    System.out.print("     ");

                }
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
