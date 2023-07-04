package com.vinit.design.problems.consolegame.games.tetris.blocks;

public class Cell {
    public int x;
    public int  y;
    Cell() {}
    Cell(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
    public void setXAndY(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}
