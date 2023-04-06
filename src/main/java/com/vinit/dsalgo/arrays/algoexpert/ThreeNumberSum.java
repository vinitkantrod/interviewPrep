package com.vinit.dsalgo.arrays.algoexpert;

import java.util.*;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // O(n^3)
        Arrays.sort(array);
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        Map<Integer, Integer[]> map = new HashMap<>();
        for (int currNo = 0; currNo < array.length; currNo++) {
            // Optimisation
            if (array[currNo] > targetSum) {
                break;
            }
            int leftPtr = currNo + 1;
            int rightPtr = array.length - 1;
            while (leftPtr < rightPtr) {
                int temp = array[currNo] + array[leftPtr] + array[rightPtr];
                if (temp == targetSum) {
                    Integer[] integers = {array[currNo], array[leftPtr], array[rightPtr]};
                    arrayList.add(integers);
                    leftPtr++;
                    rightPtr--;
                } else if (temp > targetSum) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }
         }
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(Arrays.asList(arrayList.get(i)));
//        }
        return arrayList.size() > 0 ? arrayList : new ArrayList<Integer[]>();
    }

    public static void main(String[] args) {
        int[] array = {12,3,1,2,-6,5,-8,6};
        System.out.println(Arrays.asList(threeNumberSum(array, 0)));
    }
}
