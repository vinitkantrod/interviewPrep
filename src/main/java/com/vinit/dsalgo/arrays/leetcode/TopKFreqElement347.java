package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class TopKFreqElement347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : frequency.entrySet()) {
            heap.offer(new int[]{m.getValue(), m.getKey()});
        }
        while (heap.size() > k) {
            heap.poll();
        }
        int s= heap.size();
        int[] res = new int[heap.size()];
        for (int i = 0; i < s; i++) {
            int[] t = heap.poll();
            res[i] = t[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(n, 2)));
    }
}
