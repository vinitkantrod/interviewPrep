package com.vinit.dsalgo.leetcode75.level1.binary_search;

public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int firstBadVersion = Integer.MAX_VALUE;
        return bnSearch(low, high, firstBadVersion);
    }

    public static int bnSearch(int low, int high, int firstBadVersion) {
        System.out.println(low + " - " + high);
        if (high >= low) {
            int mid = low + ((high - low) / 2);
            System.out.println("mid: " + mid + ", badVersion: " + firstBadVersion);
            if (isBadVersion(mid)) {
                if (mid < firstBadVersion) firstBadVersion = mid;
                return bnSearch(low, mid-1, firstBadVersion);
            }
            else return bnSearch(mid + 1, high, firstBadVersion);
        }
        return firstBadVersion;
    }

    public static Boolean isBadVersion(int n) {
        return false;
    }
}
