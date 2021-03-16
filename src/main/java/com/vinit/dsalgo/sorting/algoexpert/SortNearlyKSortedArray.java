package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlyKSortedArray {

    public static int[] kSort(int[] array, int k) {
        int n = array.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++) {
            queue.add(array[i]);
        }
        System.out.println(queue);
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            array[index++] = queue.peek();
            queue.poll();
            queue.add(array[i]);
            System.out.println(queue);
        }
        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            array[index++] = queue.peek();
            queue.poll();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {8,5,2,9,5,6,3};
//        int[] arr = {2, 6, 3, 12, 56, 8};
        System.out.println(Arrays.toString(kSort(arr, 3)));
    }
}
