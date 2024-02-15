package com.vinit.dsalgo.algoexpert.stack;

import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] array) {
        Stack<Integer> tempStack = new Stack<>();
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * array.length; i++) {
            int circularIdx = i % array.length;
            while (!tempStack.empty() && array[tempStack.peek()] < array[circularIdx] ) {
                Integer idx = tempStack.pop();
                result[idx] = array[circularIdx];
            }
            tempStack.push(circularIdx);
            System.out.println(List.of(tempStack) + " | " + Arrays.toString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,-3,-4,6,7,2};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
