package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class CourseScheduleTwo210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] n = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                n[i] = i;
            }
            return n;
        }
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            indegree[a]++;
            map.put(b, list);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.poll();
            res.add(node);
            if (map.containsKey(node)) {
                for (int n : map.get(node)) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        queue.add(n);
                    }
                }
            }
        }
        int n = res.size();
        int[] result = new int[n];
        if (n != numCourses) return new int[0];
        for (int i = 0; i < n; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
