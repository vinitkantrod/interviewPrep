package com.vinit.dsalgo.machine_coding.tic_tac_toe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

    public static String[][] grid;
    public static final int gridLength = 3;

    public static void main(String args[]) {
        // Initialization of Grid
        grid = new String[3][3];
        getGrid();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            System.out.println("Enter the name of player 1. This player will start the game with X");
            String p1 = reader.readLine();
            System.out.println("Enter the name of player 2. This player will follow player 1 the game with O");
            String p2 = reader.readLine();
            System.out.println("2 players playing the game are " + p1 + " and " + p2 + ".");
            System.out.println("***************************************************");
            printGrid();
            System.out.println("\nEnter the number on grid to fill it with your mark\n");
            startGame(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startGame(BufferedReader reader) {
        boolean p1 = true;
        String val = "";
        while (true) {
            p1 = checkTurnAndUpdate(reader, val, p1);
            Boolean isGameWon = checkForGame(val);
            if (isGameWon) {
                System.out.println("Player "+ val + " has won the game.");
                break;
            }
            Boolean exit = checkForExit();
            if (exit) {
                System.out.println("Game Over with no Win");
                break;
            }
        }
    }
    public static boolean checkTurnAndUpdate(BufferedReader reader, String val, Boolean p1) {
        try {
            String in = "";
            if (p1) {
                System.out.print("P1: ");
                in = reader.readLine().trim();
                val = "X";
                Boolean isUpdateSuccesful = updateGrid(in, val);
                if (isUpdateSuccesful) {
                    p1 = false;
                    printGrid();
                }
            } else {
                System.out.print("P2: ");
                in = reader.readLine();
                val = "O";
                Boolean isUpdateSuccesful = updateGrid(in, val);
                if (isUpdateSuccesful) {
                    p1 = true;
                    printGrid();
                }
            }
        } catch (IOException e) {
            System.out.println("failed to read input." + e.getMessage());
        }
        return p1;
    }

    public static Boolean updateGrid(String in, String val) {
        int rInd = Integer.parseInt(String.valueOf(in.charAt(0))) - 1;
        int cInd = Integer.parseInt(String.valueOf(in.charAt(1))) - 1;
        if (grid[rInd][cInd].equalsIgnoreCase("X") || grid[rInd][cInd].equalsIgnoreCase("O")) {
            System.out.println("Please select another place as the current place is already filled.");
            return false;
        }
        if (val.equals("X") || val.equals("O"))
            grid[rInd][cInd] = val;
        return true;
    }

    public static Boolean checkForGame(String val) {
        if (val.equals("X")) {
            return isGameWon(val);
        } else if (val.equals("O")) {
            return isGameWon(val);
        }
        return false;
    }

    public static boolean isGameWon(String val) {
        // diagonal
        return (
                    isDiagonalEqual(val) ||
                    isReverseDiagonalEqual(val) ||
                    isFirstRowEqual(val) ||
                    isMiddleRowEqual(val) ||
                    isLastRowEqual(val) ||
                    isFirstColumnEqual(val) ||
                    isMiddleColumnEqual(val) ||
                    isLastColumnEqual(val)

                ) ? true : false;
    }

    public static Boolean checkForExit() {
        Boolean exit = true;
        List<String> inp = new ArrayList<String>(Arrays.asList(
                "11", "12", "13", "21", "22", "23", "31", "32", "33"
                ));
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                if (inp.contains(grid[i][j])) return false;
            }
        }
        return true;
    }
    public static void getGrid() {
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                grid[i][j] = String.valueOf(i+1) + "" + String.valueOf(j+1);
            }
        }
    }

    public static void printGrid() {
        System.out.println("Grid ::");
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                System.out.print(" " + grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Boolean isDiagonalEqual(String val) {
        return ( grid[0][0].equalsIgnoreCase(val) &&
                grid[0][0].equalsIgnoreCase(grid[1][1]) &&
                grid[1][1].equalsIgnoreCase(grid[2][2])
        ) ? true : false;
    }

    public static Boolean isReverseDiagonalEqual(String val) {
        return ( grid[0][2].equalsIgnoreCase(val) &&
                grid[0][2].equalsIgnoreCase(grid[1][1]) &&
                grid[1][1].equalsIgnoreCase(grid[2][0])
        ) ? true : false;
    }

    public static Boolean isFirstRowEqual(String val) {
        return ( grid[0][0].equalsIgnoreCase(val) &&
                grid[0][0].equalsIgnoreCase(grid[0][1]) &&
                grid[0][1].equalsIgnoreCase(grid[0][2])
        ) ? true : false;
    }

    public static Boolean isMiddleRowEqual(String val) {
        return ( grid[1][0].equalsIgnoreCase(val) &&
                grid[1][0].equalsIgnoreCase(grid[1][1]) &&
                grid[1][1].equalsIgnoreCase(grid[1][2])
        ) ? true : false;
    }

    public static Boolean isLastRowEqual(String val) {
        return ( grid[2][0].equalsIgnoreCase(val) &&
                grid[2][0].equalsIgnoreCase(grid[2][1]) &&
                grid[2][1].equalsIgnoreCase(grid[2][2])
        ) ? true : false;
    }

    public static Boolean isFirstColumnEqual(String val) {
        return ( grid[0][0].equalsIgnoreCase(val) &&
                grid[0][0].equalsIgnoreCase(grid[1][0]) &&
                grid[1][0].equalsIgnoreCase(grid[2][0])
        ) ? true : false;
    }

    public static Boolean isMiddleColumnEqual(String val) {
        return ( grid[1][1].equalsIgnoreCase(val) &&
                grid[1][1].equalsIgnoreCase(grid[1][1]) &&
                grid[1][1].equalsIgnoreCase(grid[2][1])
        ) ? true : false;
    }

    public static Boolean isLastColumnEqual(String val) {
        return ( grid[0][2].equalsIgnoreCase(val) &&
                grid[0][2].equalsIgnoreCase(grid[1][2]) &&
                grid[1][2].equalsIgnoreCase(grid[2][2])
        ) ? true : false;
    }
}
