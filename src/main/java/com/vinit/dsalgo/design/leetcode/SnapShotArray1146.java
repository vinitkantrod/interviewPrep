package com.vinit.dsalgo.design.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class SnapshotArray {

    int snapId = 0;
    TreeMap<Integer, Integer>[] historyRecords;

    public SnapshotArray(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}
public class SnapShotArray1146 {
    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(1);
        obj.set(0,15);
        int param_2 = obj.snap();
        int param_3 = obj.snap();
        int param_4 = obj.snap();
        int param_5 = obj.get(0,2);
        int param_6 = obj.snap();
        int param_7 = obj.snap();
        int param_8 = obj.get(0,0);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);
        System.out.println(param_8);

    }
}
