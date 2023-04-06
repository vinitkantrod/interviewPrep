package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementsToTheEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int leftPtr = 0;
        int rightPtr = array.size() - 1;
        while (leftPtr < rightPtr) {
            while (rightPtr > leftPtr && array.get(rightPtr) == toMove) {
                rightPtr--;
            }
            if (array.get(leftPtr) == toMove) {
                int temp = array.get(rightPtr);
                array.set(rightPtr, array.get(leftPtr));
                array.set(leftPtr, temp);
            }
            leftPtr++;
//            System.out.println(Arrays.asList(array));
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2,1,2,2,2,3,4,2));
        int toMove = 2;
        System.out.println(Arrays.asList(moveElementToEnd(array, toMove)));
    }
}
