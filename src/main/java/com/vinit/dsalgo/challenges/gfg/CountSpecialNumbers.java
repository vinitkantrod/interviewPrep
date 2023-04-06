package com.vinit.dsalgo.challenges.gfg;

import java.util.Arrays;

public class CountSpecialNumbers {

    public static int countSpecialNumbers(int N, int arr[]) {
        // Code here
        int maxNo = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxNo = arr[i] > maxNo ? arr[i] : maxNo;
        }
        int[] temp = new int[maxNo + 1];
        Arrays.fill(temp, 0);
        for (int i = 0; i < N; i++) {
            if (temp[arr[i]] <= 1) {
                for (int j = arr[i]; j <= maxNo; j+=arr[i]) {
                    temp[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (temp[arr[i]] > 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6};
        countSpecialNumbers(3,arr );
    }
}
