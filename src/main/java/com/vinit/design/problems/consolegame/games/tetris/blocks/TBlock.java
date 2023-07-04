package com.vinit.design.problems.consolegame.games.tetris.blocks;

import com.vinit.design.problems.consolegame.games.tetris.enums.TetrominoType;

public class TBlock implements Block{
    TetrominoType type;
    Cell c1;
    Cell c2;
    Cell c3;
    Cell c4;
    public TBlock() {
        this.type = TetrominoType.T;
        // default position
        c1 = new Cell(0,0);
        c2 = new Cell(0,1);
        c3 = new Cell(0,2);
        c4 = new Cell(1,0);
    }
    public Cell[] getCell() {
        return new Cell[]{c1, c2, c3, c4};
    }
    public void setCell(Cell c1, Cell c2, Cell c3, Cell c4) {
        c1 = c1;
        c2 = c2;
        c3 = c3;
        c4 = c4;
    }
}
