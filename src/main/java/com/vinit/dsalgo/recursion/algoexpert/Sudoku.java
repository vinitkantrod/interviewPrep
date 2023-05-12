package com.vinit.dsalgo.recursion.algoexpert;

import java.util.ArrayList;

public class Sudoku {

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        solvePartialSudoku(0, 0, board);
        return board;
    }

    public static Boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row;
        int currentCol = col;

        if (currentCol == board.get(currentRow).size()) {
            currentRow += 1;
            currentCol = 0;
            if (currentRow == board.size())
                return true;
        }
        if (board.get(currentRow).get(currentCol) == 0) {
            return  ( tryDigitAtPosition(currentRow, currentCol, board) );
        }

        return solvePartialSudoku(currentRow, currentCol + 1, board);


    }
    public static Boolean tryDigitAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int digit = 1; digit < 10; digit++) {
            if (isValidAtPosition(digit, row, col, board)) {
                board.get(row).set(col, digit);
                if (solvePartialSudoku(row, col + 1, board)) return true;
            }
        }
        board.get(row).set(col, 0);
        return false;
    }

    public static Boolean isValidAtPosition(int value, int row, int column, ArrayList<ArrayList<Integer>> board) {
        Boolean isRowValid = !board.get(row).contains(value);
        Boolean isColumnValid = true;
        for (int r = 0; r < board.size(); r++)
            if (board.get(r).get(column) == value) isColumnValid = false;

        if (!isRowValid || !isColumnValid) return false;

        int subGridRow = ( row / 3 ) * 3;
        int subGridCol = ( column / 3 ) * 3;
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subGridRow + rowIdx;
                int colToCheck = subGridCol + colIdx;

                int existingEle = board.get(rowToCheck).get(colToCheck);

                if( existingEle == value) return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

    }
}
