package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class HighFive1086 {
    public static int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int idCount = 0;
        for (int i = 0; i < items.length; i++) {
            int[] x = items[i];
            if (map.containsKey(x[0])) {
                List<Integer> lst = map.get(x[0]);
                lst.add(x[1]);
                map.put(x[0], lst);
            } else {
                map.put(x[0], new ArrayList<>(Arrays.asList(x[1])));
                idCount++;
            }
        }
        System.out.println(map);
        int[] tempRes = new int[1001];
        for (Map.Entry m : map.entrySet()) {
            int id = (int) m.getKey();
            List<Integer> v = (List<Integer>) m.getValue();
            Collections.sort(v, Collections.reverseOrder());
            System.out.println(v);
            int avg = (v.get(0) + v.get(1) + v.get(2) + v.get(3) + v.get(4)) / 5;
            tempRes[id] = avg;
        }
        System.out.println(Arrays.toString(tempRes));
        int[][] res = new int[idCount][2];
        int c = 0;
        for (int i = 0; i < tempRes.length; i++) {
            if (tempRes[i] > 0) {
                res[c] = new int[]{i, tempRes[i]};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] i = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        System.out.println(highFive(i));
    }
}
