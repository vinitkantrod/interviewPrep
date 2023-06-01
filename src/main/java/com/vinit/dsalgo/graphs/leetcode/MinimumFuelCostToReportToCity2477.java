package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class MinimumFuelCostToReportToCity2477 {

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            if (!map.containsKey(road[0])) map.put(road[0], new ArrayList<>());
            if (!map.containsKey(road[1])) map.put(road[1], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        System.out.println(map);
        Queue<Integer> leafNodes = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            if (m.getValue().size() == 1) {
                leafNodes.add(m.getKey());
            }
        }
        System.out.println(leafNodes);
        Map<Integer, Long> leafToRootDistance = new HashMap<>();
        while (!leafNodes.isEmpty()) {
            // find the distance from leaf to root.
            int node = leafNodes.poll();
            Set<Integer> visited = new HashSet<>();
            leafToRootDistance.put(node, distanceToRoot(node, map));
        }
        long totalFuel = 0;
        for (Map.Entry<Integer, Long> m : leafToRootDistance.entrySet()) {
            totalFuel += Math.ceil( m.getValue() / (double) seats);
            System.out.println(m.getKey() + "-" + m.getValue() + "=" + totalFuel);
        }
        return totalFuel;
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
