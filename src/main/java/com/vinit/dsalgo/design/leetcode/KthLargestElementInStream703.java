package com.vinit.dsalgo.design.leetcode;

import java.util.PriorityQueue;

class KthLargest {

    int k;
    PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        k = k;
        heap = new PriorityQueue<>();
        for (int i : nums) {
            heap.offer(i);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
public class KthLargestElementInStream703 {


}
