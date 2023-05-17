package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class CourseSchedule207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            List<Integer> list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            map.put(b, list);
            indegree[a]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int courseCount = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.poll();
            courseCount++;
            if (map.containsKey(node)) {
                for (int n : map.get(node)) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        queue.add(n);
                    }
                }
            }
        }
        return courseCount == numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,4}, {2,4}, {3,1}, {3,2}};
        System.out.println(canFinish(5, pre));
    }
}
