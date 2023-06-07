package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class MinimumFuelCostToReportToCity2477 {

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = roads.length + 1;
        int[] degree = new int[n];
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            map.computeIfAbsent(road[0], k-> new ArrayList<>()).add(road[1]);
            map.computeIfAbsent(road[1], k-> new ArrayList<>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }

        return bfs(map, degree, n, seats);
    }

    public static long bfs(Map<Integer, List<Integer>> map, int[] degree, int n, int seat) {
        long fuel = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }
        int[] representative = new int[n];
        Arrays.fill(representative, 1);
        while (!q.isEmpty()) {
            int node = q.poll();
            fuel += Math.ceil((double) representative[node] / seat);
            for (int neighbour : map.get(node)) {
                degree[neighbour]--;
                representative[neighbour] += representative[node];
                if (degree[neighbour] == 1 && neighbour != 0) {
                    q.offer(neighbour);
                }
            }
        }
        return fuel;
    }
    public static long distanceToRoot(int node, Map<Integer, List<Integer>> map) {
        if (node == 0) return 0;
        long distance = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            visited.add(n);
            List<Integer> list = map.get(n);
            for (int l : list) {
                if (visited.contains(l)) continue;
                if (l == 0) return ++distance;
                queue.add(l);
            }
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
//        int[][] e = {{0,1},{0,2},{0,3}}; // 5
        int[][] e = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}; // 2
//        int[][] e = {}; // 1
        System.out.println(minimumFuelCost(e, 2));
    }
}
