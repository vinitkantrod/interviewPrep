package com.vinit.dsalgo.algoexpert.dp;

import java.util.*;

public class DiskStacking {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        if (disks.size() == 1) return disks;
        disks.sort((disks1, disks2) -> disks1[2].compareTo(disks2[2]));
        int[] height = new int[disks.size()];
        int[] sequence = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) height[i] = disks.get(i)[2];
        Arrays.fill(sequence, Integer.MIN_VALUE);
        int maxHeightIdx = 0;
        for (int i = 1; i < disks.size(); i++) {
            Integer[] currDisk = disks.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] oldDisk = disks.get(j);
                if (oldDisk[0] < currDisk[0] && oldDisk[1] < currDisk[1] && oldDisk[2] < currDisk[2]) {
                    if (height[i] < (height[j] + currDisk[2])) {
                        height[i] = height[j] + currDisk[2];
                        sequence[i] = j;
                    }
                }
            }
            if (height[i] >= height[maxHeightIdx]) maxHeightIdx = i;
        }
        return buildSequence(disks, sequence, maxHeightIdx);
    }
    private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequence, int maxIdx) {
        List<Integer[]> result = new ArrayList<>();
        while (maxIdx != Integer.MIN_VALUE) {
            result.add(0, disks.get(maxIdx));
            maxIdx = sequence[maxIdx];
        }
        return result;
    }

    private static void print(List<Integer[]> disk) {
        System.out.println("=======");
        for (Integer[] i : disk) System.out.println(Arrays.toString(i));
    }
    private static Boolean compareDisk(Integer[] disk1, Integer[] disk2) {
        return disk1[0] < disk2[0] && disk1[1] < disk2[1] && disk1[2] < disk2[2];
    }
    public static void main(String[] args) {
        List<Integer[]> d = new ArrayList<>();
        d.add(new Integer[]{2,1,2});
        d.add(new Integer[]{3,2,3});
        d.add(new Integer[]{2,2,8});
        d.add(new Integer[]{2,3,4});
        d.add(new Integer[]{1,3,1});
        d.add(new Integer[]{4,4,5});
        System.out.println(diskStacking(d));
    }
}
