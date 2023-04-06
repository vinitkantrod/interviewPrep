package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class DecodeXORedArray {

    public static int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < encoded.length + 1; i++) {
            res[i] = encoded[i-1] ^ res[i - 1];
        }
        return res;
    }
    public static void main(String[] args) {
//        int[] encoded = {1,0,2,1};
        int[] encoded = {6,2,7,3};
        int first = 4;
        System.out.println(Arrays.toString(decode(encoded, first)));
    }
}
