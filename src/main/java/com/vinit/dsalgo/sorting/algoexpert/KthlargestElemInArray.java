package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthlargestElemInArray {

    public static void kthLargestElementOfArray(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(array[i]);
        }
        for (int i = k; i < array.length; i++) {
            if (minHeap.peek() > array[i]) continue;
            else {
                minHeap.poll();
                minHeap.add(array[i]);
            }
        }

        System.out.println(minHeap);
        Iterator<Integer> itr = minHeap.iterator();
        while (itr.hasNext()) System.out.print(itr.next() + " ");
    }

    public static void main(String args[]) {
        int[] array = {1, 23, 12, 9, 30, 2, 50};
        kthLargestElementOfArray(array, 3);
    }
}
