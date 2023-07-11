package com.vinit.dsalgo.bitwise.leetcode;

public class MinimumFlipToMakeAOrBEqualC1318 {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
    }
}
