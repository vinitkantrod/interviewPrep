package com.vinit.dsalgo.stack.algoexpert;

import java.util.*;

public class SunsetViews {

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        if (buildings.length == 0) return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (direction.equalsIgnoreCase("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (stack.empty()) {
                    stack.push(new ArrayList<Integer>(Arrays.asList(buildings[i], i)));
                } else {
                    ArrayList<Integer> top = stack.peek();
                    if (buildings[i] > top.get(0)) {
                        stack.push(new ArrayList<Integer>(Arrays.asList(buildings[i], i)));
                    }
                }
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (stack.empty()) {
                    stack.push(new ArrayList<Integer>(Arrays.asList(buildings[i], i)));
                } else {
                    ArrayList<Integer> top = stack.peek();
                    if (buildings[i] > top.get(0)) {
                        stack.push(new ArrayList<Integer>(Arrays.asList(buildings[i], i)));
                    }
                }
            }
        }
        while (!stack.empty()) {
            ArrayList<Integer> top = stack.pop();
            res.add(top.get(1));
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String args[]) {
        int[] buildings = new int[]{3,5,4,4,3,1,3,2};
        System.out.println( Arrays.toString(sunsetViews(buildings, "WEST").toArray() ));
    }
}
