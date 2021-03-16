package com.vinit.dsalgo.graphs.algoexpert;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int elementCount = 0;
        int currentIndex = 0;
        while (elementCount != array.length) {
            if (elementCount > 0 && currentIndex == 0) return false;
            elementCount++;
            currentIndex = getNextPosition(currentIndex, array[currentIndex], array.length);
        }
        return currentIndex == 0;
    }

    public static int getNextPosition(int c, int e, int l) {
        int s = (c + e) % l;
        return s >= 0 ? s : s + l;
    }

    public static void main(String args[]) {

    }
}
