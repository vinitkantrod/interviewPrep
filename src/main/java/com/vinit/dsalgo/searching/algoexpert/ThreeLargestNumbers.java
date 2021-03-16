package com.vinit.dsalgo.searching.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] res = new int[3];
        res[0] = array[0]; res[1] = array[1]; res[2] = array[2];
        Arrays.sort(res);
        int temp = array[2];
        for (int i = 3; i < array.length; i++) {
            int x = 2;
            temp = array[i];
            while (x >= 0) {
//                System.out.println(temp + " _ " + res[x]);
                if (temp > res[x]) {
                    int temp1 = res[x];
                    res[x] = temp;
                    temp = temp1;
                }
                x--;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        int[] arr = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(Arrays.toString(findThreeLargestNumbers(arr)));
    }
}
