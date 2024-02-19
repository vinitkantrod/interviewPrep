package com.vinit.dsalgo.algoexpert.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeNumberSort {
    public static int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) map.put(i, map.getOrDefault(i, 0) + 1);
        System.out.println(map);
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (!map.containsKey(order[j])) j++;
            if (map.containsKey(order[j]) && map.get(order[j]) <= 0) {
                map.remove(order[j]);
                j++;
                continue;
            }
            if (map.containsKey(order[j]) && map.get(order[j]) > 0) {
                array[i] = order[j];
                map.put(order[j], map.get(order[j]) - 1);
            }
            i++;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,0,0,-1,-1,0,1,1};
        int[] o = new int[]{0,1,-1};
        System.out.println(Arrays.toString(threeNumberSort(a, o)));
    }
}
