package com.vinit.dsalgo.arrays.algoexpert;

public class ArraysOfProduct {

    public int[] arrayOfProducts(int[] array) {
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int productMultiply = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) productMultiply *= array[j];
            }
            res[i] = productMultiply;
        }
        return res;
    }
    public static void main(String args[]) {

    }
}
