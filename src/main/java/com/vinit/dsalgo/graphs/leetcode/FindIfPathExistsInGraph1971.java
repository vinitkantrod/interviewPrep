package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class FindIfPathExistsInGraph1971 {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // iterative approach - queue
        if (source == destination) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (map.containsKey(u)) {
                List<Integer> lst = map.get(u);
                lst.add(v);
                map.put(u, lst);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(v);
                map.put(u, lst);
            }
            if (map.containsKey(v)) {
                List<Integer> lst = map.get(v);
                lst.add(u);
                map.put(v, lst);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(u);
                map.put(v, lst);
            }
        }
        System.out.println(map);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> uniqueVertices = new HashSet<>();
        queue.add(source);
        uniqueVertices.add(source);
        while (!queue.isEmpty()) {
            System.out.println("queue: " + queue);
            List<Integer> lst = map.getOrDefault(queue.poll(), new ArrayList<>());
            System.out.println(Arrays.asList(lst));
            if (lst.size() > 0) {
                for (int i : lst) {
                    if (!uniqueVertices.contains(i)) {
                        if (i == destination) return true;
                        queue.add(i);
                        uniqueVertices.add(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] e = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
//        System.out.println(validPath(1, e, 0, 5));
        int[][] e = {};
        System.out.println(validPath(1, e, 0, 0));
    }
}
