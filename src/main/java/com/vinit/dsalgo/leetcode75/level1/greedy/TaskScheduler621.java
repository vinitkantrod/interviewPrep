package com.vinit.dsalgo.leetcode75.level1.greedy;

import java.util.Arrays;

public class TaskScheduler621 {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        Arrays.sort(freq);
        int fMax = freq[25];
        int idleTime = (fMax - 1) * n;
        for (int i = freq.length - 2; i >= 0 && idleTime > 0; i--) {
            if (freq[i] == 0) continue;
            idleTime -= Math.min(fMax - 1, freq[i]);
            System.out.println(freq[i] + " - " + idleTime);
        }
        idleTime = Math.max(0, idleTime);
        return idleTime + tasks.length;
    }

    public static void main(String[] args) {
        char[] t = {'A','A','B','A','A','B','C','A','B'};
        System.out.println(leastInterval(t, 2));
    }
}
