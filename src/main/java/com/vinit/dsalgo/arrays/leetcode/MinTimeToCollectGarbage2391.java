package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class MinTimeToCollectGarbage2391 {

    public static int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int M_index = 0;
        int P_index = 0;
        int G_index = 0;
        int timeToTravel = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (String.valueOf(garbage[i].charAt(j)).equals("M")) M_index = i;
                else if (String.valueOf(garbage[i].charAt(j)).equals("P")) P_index = i;
                else G_index = i;
                timeToTravel++;
            }
        }
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        timeToTravel += M_index > 0 ? travel[M_index - 1] : 0;
        timeToTravel += P_index > 0 ? travel[P_index - 1] : 0;
        timeToTravel += G_index > 0 ? travel[G_index - 1] : 0;
//        System.out.println(Arrays.toString(travel));
        return timeToTravel;
    }

    public static void main(String[] args) {
        String[] g = {"G","P","GP","GG"};
        int[] t = {2,4,3};
        System.out.println(garbageCollection(g, t));
    }
}
