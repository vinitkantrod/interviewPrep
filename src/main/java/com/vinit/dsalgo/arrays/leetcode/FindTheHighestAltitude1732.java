package com.vinit.dsalgo.arrays.leetcode;

public class FindTheHighestAltitude1732 {
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            System.out.println(i + " " + altitude);
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
//        int[] gain = {-5,1,5,0,-7};
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }
}
