package com.vinit.dp.maxmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PerfectSquare {

    public static int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        List<Integer> squareNumbers = new ArrayList<>();
        int x = 1;
        int y = x * x;
        while (y <= n) {
            squareNumbers.add(y);
            x++;
            y = x * x;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(List.of(squareNumbers));
        arr[0] = 0;
        arr[1] = 1;
        for (int i : squareNumbers) {
            for (int j = 2; j <= n; j++) {
                if (j >= i) {
                    arr[j] = Math.min(arr[j], arr[j - i] + 1);
                    System.out.println(i + ", intermediate: " + Arrays.toString(arr));
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
