package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class InsertInterval57 {

    // Returns true if the intervals a and b have a common element.
    static boolean doesIntervalsOverlap(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    // Return the interval having all the elements of intervals a and b.
    static int[] mergeIntervals(int[] a, int[] b) {
        int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return newInterval;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert
        Boolean isInsertedInterval = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < list.get(i)[0]) {
                list.add(i, newInterval);
                isInsertedInterval = true;
                break;
            }
        }
        if (!isInsertedInterval) {
            list.add(newInterval);
        }
        // Merge Intervals
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] currentInterval = {list.get(i)[0], list.get(i)[1]};
            while (i < list.size() && doesIntervalsOverlap(currentInterval, list.get(i))) {
                currentInterval = mergeIntervals(currentInterval, list.get(i));
                i++;
            }
            i--;
            res.add(currentInterval);
        }
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        return res.toArray(new int[res.size()][2]);
    }
    public static void main(String[] args) {
        int[][] i = {{1,3},{6,9}};
        int[] in = {2,5};
        for (int[] x : insert(i, in)) {
            System.out.println(Arrays.toString(x));
        }
    }
}
