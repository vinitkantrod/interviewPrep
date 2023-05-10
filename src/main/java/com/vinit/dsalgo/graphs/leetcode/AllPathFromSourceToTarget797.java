package com.vinit.dsalgo.graphs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPathFromSourceToTarget797 {

    static int target;
    static int[][] g;
    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> temp = new LinkedList<>();
        g = graph;
        target = graph.length - 1;
        int currNode = 0;
        temp.add(currNode);
        allPathSource(currNode, temp);
        return list;
    }

    public static void allPathSource(int currNode, LinkedList<Integer> temp) {
        if (currNode == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i : g[currNode]) {
            temp.add(i);
            allPathSource(i, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] n = {{1,2}, {3}, {3}, {}};
        System.out.println(Arrays.asList(allPathsSourceTarget(n)));
    }
}
