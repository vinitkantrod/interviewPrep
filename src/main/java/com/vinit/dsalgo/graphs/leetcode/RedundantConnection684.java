package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class RedundantConnection684 {

    public static int[] findRedundantConnection(int[][] edges) {
        // find n
        int n = Integer.MIN_VALUE;
        for (int[] i : edges) {
            if (i[0] > n) n = i[0];
            if (i[1] > n) n = i[1];
        }
        System.out.println(n);
        List<int[]> tempRes = new ArrayList<>();
        Boolean[] visited = new Boolean[n + 1];
        Arrays.fill(visited, false);
        for (int[] e : edges) {
            if (visited[e[0]] && visited[e[1]]) {
                tempRes.add(new int[]{e[0], e[1]});
            }
            visited[e[0]] = true;
            visited[e[1]] = true;
        }
//        System.out.println(Arrays.asList(tempRes));
        return tempRes.get(tempRes.size() - 1);
    }

    public static void main(String[] args) {
//        int[][] e = {{1,2}, {1,3}, {2,3}};
//        int[][] e = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[][] e = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        System.out.println(Arrays.toString(findRedundantConnection(e)));
    }
}
