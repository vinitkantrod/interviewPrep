package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class MinimumHeightTree310 {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<List<Integer>> adjacencyMap = new ArrayList<>();
//        for (int i = 0; i < n; i++) adjacencyMap.add(new ArrayList<>());
//        for (int[] e : edges) {
//            adjacencyMap.get(e[0]).add(e[1]);
//            adjacencyMap.get(e[1]).add(e[0]);
//        }
//        System.out.println(Arrays.asList(adjacencyMap));
//        int[][] heightArr = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int height = getHeight(i, n, adjacencyMap);
//            heightArr[i] = new int[]{i, height};
//        }
//        List<Integer> res = new ArrayList<>();
//        Arrays.sort(heightArr, (a, b) -> Integer.compare(a[1], b[1]));
//        int MinHeight = heightArr[0][1];
//        for (int i = 0; i < n; i++) {
//            if (heightArr[i][1] == MinHeight) {
//                System.out.println(Arrays.toString(heightArr[i]));
//                res.add(heightArr[i][0]);
//            }
//        }
//        System.out.println(Arrays.asList(res));
//        return res;

        // LC code
        List<Integer> result = new ArrayList();
        if (n < 2) {
            for (int i = 0; i < n; i++)
                result.add(i);

            return result;
        }

        int[] degree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            degree[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                queue.add(i);
        }

        int size = 0;
        while (!queue.isEmpty()) {
            result = new ArrayList();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                result.add(node);
                degree[node]--;

                for (int neighbor : graph.get(node)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1)
                        queue.add(neighbor);
                }
            }
            System.out.println(Arrays.asList(result));
        }
        return result;
    }

    public static int getHeight(int node, int n, List<List<Integer>> adjacencyMap) {
//        System.out.println("i: " + node);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        int height = -1;
        queue.add(-1);
        while (!queue.isEmpty()) {
            int aa = queue.peek();
            if (aa == -1) break;
            LinkedList<Integer> smallQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int a = queue.poll();
                if (a == -1) {
                    height++;
                } else {
                    smallQueue.add(a);
                }
            }
//            System.out.println("smallQueue: " + smallQueue);
            while (!smallQueue.isEmpty()) {
                int a = smallQueue.peek();
                smallQueue.poll();
                visited[a] = true;
                for (int nn : adjacencyMap.get(a)) {
                    if (!visited[nn]) {
                        queue.add(nn);
                    }
                    adjacencyMap.get(nn).remove(a);
                }
            }
            queue.add(-1);
        }
        System.out.println(node + ", height: " + height);
        return height;
    }

    public static void main(String[] args) {
//        int[][] e = {{1,0}, {1,2}, {1,3}};
        int[][] e = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(findMinHeightTrees(6, e));
    }
}
