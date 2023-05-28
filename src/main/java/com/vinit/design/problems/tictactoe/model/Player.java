package com.vinit.design.problems.tictactoe.model;

import com.vinit.design.problems.tictactoe.model.PeiceType;

public class Player {

    String name;
    PlayingPeice playingPeice;

    Player(String name, PlayingPeice peiceType) {
        this.name = name;
        this.playingPeice = peiceType;
    }
}
