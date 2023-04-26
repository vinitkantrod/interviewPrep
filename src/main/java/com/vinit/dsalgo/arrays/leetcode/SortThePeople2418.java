package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class SortThePeople2418 {

    public static String[] sortPeople(String[] names, int[] heights) {
        List<List<String>> joinData = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            List<String> r = new ArrayList<>();
            r.add(names[i]);
            r.add(String.valueOf(heights[i]));
            joinData.add(r);
        }
        Collections.sort(joinData, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int h1 = Integer.parseInt(o1.get(1));
                int h2 = Integer.parseInt(o2.get(1));
                return h2 - h1;
            }
        });
        System.out.println(Arrays.asList(joinData));
        String[] res = new String[names.length];
        for (int i = 0; i < joinData.size(); i++) {
            res[i] = joinData.get(i).get(0);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.asList(sortPeople(names, heights)));
    }
}
