package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        // Shortcut
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
        int[][] res = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) res[i] = mergedIntervals.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {4,7}, {6,8}, {9,10}, {3,5}};
        int[][] res = mergeOverlappingIntervals(intervals);
        for (int[] re : res) System.out.println(Arrays.toString(re));
    }
}
