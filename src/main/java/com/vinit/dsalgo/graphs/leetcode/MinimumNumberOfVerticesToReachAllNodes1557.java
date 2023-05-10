package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes1557 {

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//        Set<Integer> allNodeSet = new HashSet<>();
//        Set<Integer> zeroInDegreeSet = new HashSet<>();
//        Map<Integer, List<Integer>> path = new HashMap<>();
//        for (int i = 0; i < edges.size(); i++) {
//            int u = edges.get(i).get(0);
//            int v = edges.get(i).get(1);
//            System.out.println("u: " + u + ", v: " + v);
//            if (!allNodeSet.contains(u)) allNodeSet.add(u);
//            if (!allNodeSet.contains(v)) allNodeSet.add(v);
//            zeroInDegreeSet.add(u);
//            if (!path.containsKey(u)) {
//                List<Integer> tempList = new ArrayList<>();
//                tempList.add(v);
//                path.put(u, tempList);
//            }
//            else {
//                List<Integer> uPathList = path.get(u);
//                uPathList.add(v);
//                path.put(u, uPathList);
//            }
//        }
//        System.out.println("path: " + path);
//        System.out.println("allNodeSet: " + allNodeSet);
//        for (int i = 0; i < edges.size(); i++) {
//            int v = edges.get(i).get(1);
//            zeroInDegreeSet.remove(v);
//        }
//        System.out.println("zeroInDegreeSet: " + zeroInDegreeSet);
//        List<Integer> result = new ArrayList<>();
//        for (int i : zeroInDegreeSet) {
//            result.add(i);
//            Queue<Integer> queue = new LinkedList<>();
//            queue.add(i);
//            while (!queue.isEmpty()) {
//                int x = queue.poll();
//                allNodeSet.remove(x);
//                if (path.containsKey(x)) {
//                    List<Integer> pathList = path.get(x);
//                    for (int y : pathList) queue.add(y);
//                }
//            }
//        }
//        if (allNodeSet.size() > 0) {
//            for (int i : allNodeSet) {
//                result.add(i);
//            }
//        }
//
//        return result;

        // LC code
        int indegree[]=new int[n];
        for(int i=0;i<edges.size();i++){
            indegree[edges.get(i).get(1)]++;
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)ans.add(i);
        }


        return ans;
    }

    public static void main(String[] args) {
//        List<List<Integer>> lst = new ArrayList<>();
//        lst.add(new ArrayList<>(Arrays.asList(0,1)));
//        lst.add(new ArrayList<>(Arrays.asList(0,2)));
//        lst.add(new ArrayList<>(Arrays.asList(2,5)));
//        lst.add(new ArrayList<>(Arrays.asList(3,4)));
//        lst.add(new ArrayList<>(Arrays.asList(4,2)));
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(new ArrayList<>(Arrays.asList(0,1)));
        lst.add(new ArrayList<>(Arrays.asList(2,1)));
        lst.add(new ArrayList<>(Arrays.asList(3,1)));
        lst.add(new ArrayList<>(Arrays.asList(1,4)));
        lst.add(new ArrayList<>(Arrays.asList(2,4)));
        System.out.println(Arrays.asList(findSmallestSetOfVertices(6, lst)));
    }
}
