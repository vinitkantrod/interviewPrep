package com.vinit.dsalgo.algoexpert.arrays;

import java.util.*;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> arrayList = new ArrayList<>();
        for (int currNo = 0; currNo < array.length + 1; currNo++) {
            int leftPtr = currNo + 1;
            int rightPtr = array.length - 1;
            while (leftPtr < rightPtr) {
                int temp = array[currNo] + array[leftPtr] + array[rightPtr];
                if (temp == targetSum) {
                    Integer[] intergers = new Integer[]{array[currNo], array[leftPtr], array[rightPtr]};
                    arrayList.add(intergers);
                    leftPtr++;
                    rightPtr--;
                } else  if (temp > targetSum) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }
        }
        return arrayList.size() > 0 ? arrayList : new ArrayList<Integer[]>();
    }

    public static void main(String[] args) {
        int[] ar = new int[]{12,3,1,2,-6,5,-8,6};
        System.out.println(threeNumberSum(ar, 0));
    }
}
