package com.vinit.dsalgo.arrays.leetcode;

public class ValueOfVariables {

    public static int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for (String ops : operations) {
            value = ops.charAt(1) == '+' ? value + 1 : value - 1;
        }
        return value;
    }

    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

}
