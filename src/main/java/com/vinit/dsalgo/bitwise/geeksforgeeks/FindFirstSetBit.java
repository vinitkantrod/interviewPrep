package com.vinit.dsalgo.bitwise.geeksforgeeks;

public class FindFirstSetBit {

    public static int getFirstSetBit(int n) {

        // Your code here
        return (int)((Math.log10(n & -n)) / Math.log10(2))
                + 1;
    }
    public static void main(String[] args) {

    }

}
