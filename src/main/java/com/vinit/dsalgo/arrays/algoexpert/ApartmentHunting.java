package com.vinit.dsalgo.arrays.algoexpert;

import java.util.*;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] blockDistance = new int[reqs.length][blocks.size()];
        for (int i = 0; i < reqs.length; i++) {
            blockDistance[i] = calculateMinDistance(blocks, reqs[i]);
        }
        int[] minDistancesAtBlock = getMaxDistanceAtBlock(blocks, blockDistance);
        System.out.println(Arrays.toString(minDistancesAtBlock));
        return minValueOfBlock(minDistancesAtBlock);
    }

    public static int[] calculateMinDistance(List<Map<String, Boolean>> blocks, String reg) {
        int[] array = new int[blocks.size()];
        calculateForwardDistance(blocks, reg, array);
        calculateBackwardDistance(blocks, reg, array);
        System.out.println("reg: " + reg + ", values:  " + Arrays.toString(array));
        return array;
    }

    public static void calculateForwardDistance(List<Map<String, Boolean>> blocks, String reg, int[] array) {
        Integer closestIdx = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(reg)) closestIdx = i;
            array[i] = Math.abs(i - closestIdx);
        }
    }

    public static void calculateBackwardDistance(List<Map<String, Boolean>> blocks, String reg, int[] array) {
        Integer closestIdx = Integer.MAX_VALUE;
        for (int i = blocks.size() - 1; i>=0; i--) {
            if (blocks.get(i).get(reg)) closestIdx = i;
            array[i] = Math.min(array[i], Math.abs(i - closestIdx));
        }
    }

    public static int[] getMaxDistanceAtBlock(List<Map<String, Boolean>> blocks, int[][] blockDistance) {
        int[] minDistances = new int[blocks.size()];

        for (int i = 0; i < blocks.size(); i++) {
            int[] regDistances = new int[blockDistance.length];
            for (int j = 0; j < blockDistance.length; j++) {
                regDistances[j] = blockDistance[j][i];
            }
            minDistances[i] = GetMaximumOfBlocks(regDistances);
        }
        return minDistances;
    }

    public static int GetMaximumOfBlocks(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) maxValue = arr[i];
        }
        return maxValue;
    }

    public static int minValueOfBlock(int[] maxBlockDistance) {
        int minValue = maxBlockDistance[0];
        for (int i = 0; i < maxBlockDistance.length; i++){
            if (maxBlockDistance[minValue] > maxBlockDistance[i]) minValue = i;
        }
        return minValue;
    }

    public static void main(String args[]) {
        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym", false);block1.put("school", true); block1.put("store", false);
        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", true);block2.put("school", false); block2.put("store", false);
        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", true);block3.put("school", true); block3.put("store", false);
        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym", false);block4.put("school", true); block4.put("store", false);
        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", false);block5.put("school", true); block5.put("store", true);
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);
        String[] regs = {"gym", "school", "store"};
        System.out.println(apartmentHunting(blocks, regs));
    }
}
