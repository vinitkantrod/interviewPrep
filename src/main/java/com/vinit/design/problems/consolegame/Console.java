package com.vinit.design.problems.consolegame;

import com.vinit.design.problems.consolegame.games.tetris.blocks.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Console {
    Deque<Block> blockSequence;
    int currentIndex;
    int[][] matrix;

    Console() {
        blockSequence = new LinkedList<>();
        initialiseBlockSequence();
        matrix = new int[100][100];
    }

    private void initialiseBlockSequence() {
        blockSequence.add(new TBlock());
        blockSequence.add(new SkewBlock());
        blockSequence.add(new LBlock());
        blockSequence.add(new SquareBlock());
        blockSequence.add(new StraightBlock());
    }
}
