package com.vinit.dsalgo.arrays.leetcode;

public class CountGoodTriplets1534 {

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int tripletCount = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        System.out.println(i+"_"+j+"_"+k);
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            tripletCount++;
                            System.out.println(tripletCount);
                        }
                    }
                }
            }
        }
        return tripletCount;
    }
    public static void main(String[] args) {
        int[] arr = {3,0,1,1,9,7};
        System.out.println(countGoodTriplets(arr, 7,2,3));
    }
}
