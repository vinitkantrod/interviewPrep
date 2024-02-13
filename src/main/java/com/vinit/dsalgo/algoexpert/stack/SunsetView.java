package com.vinit.dsalgo.algoexpert.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SunsetView {

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> sunsetView = new ArrayList<>();
        int startIdx = buildings.length - 1;
        int step = -1;
        if (direction.equals("WEST")) {
            startIdx = 0;
            step = 1;
        }
        int maxheight = 0;
        while (startIdx >= 0 && startIdx < buildings.length) {
            int buildingHeight = buildings[startIdx];
            if (buildingHeight > maxheight) {
                sunsetView.add(startIdx);
                maxheight = buildingHeight;
                System.out.println(Arrays.asList(sunsetView));
            }
            startIdx += step;
        }
        if (direction.equals("EAST")) Collections.reverse(sunsetView);
        return sunsetView;
    }

    public static void main(String[] args) {
        int[] b = new int[]{3,5,4,4,3,1,3,2};
        System.out.println(sunsetViews(b, "WEST"));
    }
}
