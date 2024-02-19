package com.vinit.dsalgo.algoexpert.graph;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int numElementVisited = 0;
        int currentIdx = 0;
        while (numElementVisited < array.length) {
            if (numElementVisited > 0 && currentIdx == 0) return false;
            numElementVisited++;
            currentIdx = getNext(currentIdx, array);
        }
        return currentIdx == 0;
    }

    private static int getNext(int currIdx,int[] array) {
        int jump = array[currIdx];
        int nextIdx = (currIdx + jump) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
    private static boolean traverse(int[] array, boolean[] visited, int currIdx) {
        int numElementVisited = 0;
        int currentIdx = 0;
        while (numElementVisited < array.length) {

        }
        return currIdx == 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,-4,-4,2};
        System.out.println(hasSingleCycle(a));
    }

}
