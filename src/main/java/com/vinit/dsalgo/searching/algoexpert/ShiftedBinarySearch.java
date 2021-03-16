package com.vinit.dsalgo.searching.algoexpert;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        return shift(array, target, 0, array.length - 1);
    }

    public static int shift(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int middle = (left + right ) / 2;
        int potentialMatch = array[middle];
        int leftNum = array[left];
        int rightNum = array[right];
        if (potentialMatch == target) return middle;
        else if (leftNum <= potentialMatch) {
            if (target < potentialMatch && target >= leftNum) {
                return shift(array, target, left, middle - 1);
            } else {
                return shift(array, target, middle + 1, right);
            }
        } else {
            if (target > potentialMatch && target <= rightNum) {
                return shift(array, target, middle + 1, right);
            } else {
                return shift(array, target, left, middle - 1);
            }
        }

    }

    public static void main(String args[]) {
        int[] p = new int[]{45, 61, 71, 73, 74, 0, 1, 21, 33, 37};
        System.out.println(shiftedBinarySearch(p, 33));
    }
}
