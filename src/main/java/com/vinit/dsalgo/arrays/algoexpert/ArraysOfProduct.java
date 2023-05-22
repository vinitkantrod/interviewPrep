package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class ArraysOfProduct {

    public static int[] arrayOfProducts(int[] array) {
        // improved space complexity
        int[] product = new int[array.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for ( int i = 0; i < array.length; i++) {
            product[i] = leftProduct;
            leftProduct *= array[i];
        }
        System.out.println(Arrays.toString(product));
        for ( int i = array.length - 1; i >= 0; i--) {
            product[i] *= rightProduct;
            rightProduct *= array[i];
        }
        return product;
    }
    public static void main(String args[]) {
        int[] array = {5,1,4,2};
        System.out.println(Arrays.toString(arrayOfProducts(array)));
    }
}
