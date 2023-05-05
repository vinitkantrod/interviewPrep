package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class KthDistinctStringInArray2053 {

    public static String kthDistinct(String[] arr, int k) {
        Set<String> set = new LinkedHashSet<>();
        Set<String> duplicateSet = new HashSet<>();
        for (String s : arr) {
            if (!set.contains(s) && !duplicateSet.contains(s)) set.add(s);
            else if (!set.contains(s) && duplicateSet.contains(s)) {
                continue;
            } else if (set.contains(s) && !duplicateSet.contains(s)) {
                set.remove(s);
                duplicateSet.add(s);
            }
        }
        System.out.println(set);
        System.out.println(duplicateSet);
        if (set.size() < k) return "";
        else {
            int count = 0;
            for (String s : set) {
                count++;
                if (count == k) return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        System.out.println(kthDistinct(arr, 2));
    }
}
