package com.vinit.dsalgo.hashtable.leetcode;

import java.util.*;

public class RemoveLetterToEqualiseFreq2423 {

    public static boolean equalFrequency(String word) {
        int[] al = new int[26];
        for (char c: word.toCharArray()) {
            int x = (int) c - 'a';
            al[x]++;
        }
        System.out.println(Arrays.toString(al));
        for (int i = 0; i < al.length; i++) {
            if (al[i] == 0) continue;
            al[i]--;
            if (isEqual(al)) return true;
            al[i]++;
        }
        return true;
    }

    public static Boolean isEqual(int[] al) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (al[i]!=0) {
                set.add(al[i]);
            }
        }
        return set.size() < 2;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("aaaabbbbccc"));
    }
}
