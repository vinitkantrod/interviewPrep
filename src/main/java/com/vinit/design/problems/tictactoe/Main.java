package com.vinit.design.problems.tictactoe;

import com.vinit.design.problems.tictactoe.model.TicTacToeGame;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        System.out.println("Winner is " + ticTacToeGame.startGame());
    }
}
