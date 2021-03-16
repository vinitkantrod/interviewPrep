package com.vinit.dsalgo.greedy.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TaskAssignment {

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            s.add(new ArrayList<>(Arrays.asList(i, tasks.get(i))));
        }
        Collections.sort(s, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            a.add(new ArrayList<>(Arrays.asList(s.get(i++).get(0), s.get(j--).get(0))));
        }
        return a;
    }
    public static void main(String args[]) {
        System.out.println(Arrays.toString(taskAssignment(3, new ArrayList<>(Arrays.asList(1,3,5,3,1,4))).toArray()) );
    }
}
