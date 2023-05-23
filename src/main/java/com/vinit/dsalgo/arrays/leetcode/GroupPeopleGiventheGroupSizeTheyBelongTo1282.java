package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class GroupPeopleGiventheGroupSizeTheyBelongTo1282 {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0 ; i < groupSizes.length;i++) {
            if (!map.containsKey(groupSizes[i])) {
                List<List<Integer>> masterList = new ArrayList<>();
                List<Integer> slaveList = new ArrayList<>();
                slaveList.add(i);
                masterList.add(slaveList);
                map.put(groupSizes[i], masterList);
            } else {
                List<List<Integer>> masterList = map.get(groupSizes[i]);
                List<Integer> lastList = masterList.get(masterList.size() - 1);
                if (lastList.size() == groupSizes[i]) {
                    List<Integer> neww = new ArrayList<>();
                    neww.add(i);
                    masterList.add(neww);
                } else {
                    lastList.add(i);
                }
                map.put(groupSizes[i], masterList);
            }
        }
        System.out.println(map);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> m : map.entrySet()) {
            res.addAll(m.getValue());
        }
        System.out.println(Arrays.asList(res));
        return res;
    }

    public static void main(String[] args) {
        int[] n = {2,3,3,3,1,2};
        System.out.println(groupThePeople(n));
    }
}
