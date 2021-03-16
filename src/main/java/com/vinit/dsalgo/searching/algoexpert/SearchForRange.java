package com.vinit.dsalgo.searching.algoexpert;

public class SearchForRange {

    public static int[] searchForRange(int[] array, int target) {
        int[] finalRange = {-1, -1};
        finalRange = alteredBinarySearch(array, target, 0, array.length - 1, true, finalRange);
        finalRange = alteredBinarySearch(array, target, 0, array.length - 1, false, finalRange);
        return finalRange;
    }

    public static int[] alteredBinarySearch(int[] array, int target, int left, int right, boolean goLeft, int[] finalRange) {
        if (left > right) return finalRange;
        int mid = (left + right) / 2;
        if (array[mid] < target) {
            alteredBinarySearch(array, target, mid + 1, right, goLeft, finalRange);
        } else if (array[mid] > target) {
            alteredBinarySearch(array, target, left, mid - 1, goLeft, finalRange);
        } else {
            if (goLeft) {
                if (mid == 0 || array[mid - 1] != target) finalRange[0] = mid;
                else alteredBinarySearch(array, target, left, mid - 1, goLeft, finalRange);
            } else {
                if (mid == array.length - 1 || array[mid + 1] != target) finalRange[1] = mid;
                else alteredBinarySearch(array, target, mid + 1, right, goLeft, finalRange);
            }
        }
        System.out.println(finalRange[0] + "  " + finalRange[1]);
        return finalRange;
    }
    public static void main(String args[]) {
        int[] n = {0,1,21,31,45,45,45,45,45,45, 61,71,73};
        searchForRange(n, 45);
    }
}
