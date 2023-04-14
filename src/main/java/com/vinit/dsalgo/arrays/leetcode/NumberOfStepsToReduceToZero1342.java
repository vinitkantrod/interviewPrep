package com.vinit.dsalgo.arrays.leetcode;

public class NumberOfStepsToReduceToZero1342 {

    public static int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) num = num / 2;
            else num -= 1;
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSteps(0));
    }
}
