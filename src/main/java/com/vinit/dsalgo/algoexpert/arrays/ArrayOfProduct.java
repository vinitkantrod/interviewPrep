package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class ArrayOfProduct {

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int result[] = new int[array.length];
        int leftValue = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = leftValue;
            leftValue *= array[i];
        }
        int rightValue = 1;
        System.out.println(Arrays.toString(result));
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= rightValue;
            rightValue *= array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,4,2};
        System.out.println(Arrays.toString(arrayOfProducts(arr)));
    }
}
