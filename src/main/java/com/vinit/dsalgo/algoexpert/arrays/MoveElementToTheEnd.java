package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToTheEnd {

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {
        int leftPtr = 0;
        int rightPtr = array.size() - 1;
        while (leftPtr < rightPtr) {
            while (rightPtr > leftPtr && array.get(rightPtr) == toMove) {
                rightPtr--;
            }
            if (array.get(leftPtr) == toMove) {
                int temp = array.get(leftPtr);
                array.set(leftPtr, array.get(rightPtr));
                array.set(rightPtr, temp);
            }
            leftPtr++;
        }
        return array;
    }
}
