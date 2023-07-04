package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class FindKPairWithSmallestSum373 {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        HashMap<String, Boolean> visited = new HashMap<>();
        heap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.put("" + 0 + "_" + 0, true);
        while (k-- > 0 && !heap.isEmpty()) {
            int[] top = heap.poll();
            int i = top[1];
            int j = top[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < m && !visited.containsKey("" + (i + 1) + "_" + j)) {
                heap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.put("" + (i + 1) + "_" + j, true);
            }
            if (j + 1 < n && !visited.containsKey("" + i + "_" + (j + 1))) {
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.put("" + i + "_" + (j + 1), true);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] n1 = {1,7,11};
        int[] n2 = {2,4,6};
        System.out.println(Arrays.asList(kSmallestPairs(n1, n2, 3)));
    }
}
