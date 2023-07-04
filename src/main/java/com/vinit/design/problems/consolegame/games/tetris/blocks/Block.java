package com.vinit.design.problems.consolegame.games.tetris.blocks;

public interface Block {
    public void setCell(Cell c1, Cell c2, Cell c3, Cell c4);
    public Cell[] getCell();
}
