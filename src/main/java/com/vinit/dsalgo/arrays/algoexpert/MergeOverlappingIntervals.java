package com.vinit.dsalgo.arrays.algoexpert;

import java.util.*;

public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);
        for (int[] nextInterval : intervals) {
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
            System.out.println(Arrays.toString(mergedIntervals.get(i)));
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {4,7}, {6,8}, { 9,10}};
//        int[][] intervals = {{1,3}, {2,8}, {9,10}};
        System.out.println(Arrays.asList(mergeOverlappingIntervals(intervals)));
    }
}
