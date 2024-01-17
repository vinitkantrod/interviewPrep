package com.vinit.dsalgo.algoexpert.arrays;

import java.util.*;

public class SweetAndSavory {

    public static int[] sweetAndSavory(int[] dishes, int target) {
        // working code
        int[] result = new int[2];
        List<Integer> sweetList = new ArrayList<>();
        List<Integer> savoryList = new ArrayList<>();
        for (int i : dishes) {
            if (i < 0) sweetList.add(i);
            if (i > 0) savoryList.add(i);
        }
        sweetList.sort(Comparator.comparingInt(Math::abs));
        savoryList.sort(Comparator.naturalOrder());
        int sweetIdx = 0;
        int savoryIdx = 0;
        int bestDiff = Integer.MAX_VALUE;
        while (sweetIdx < sweetList.size() && savoryIdx < savoryList.size()) {
            int currSum = sweetList.get(sweetIdx) + savoryList.get(savoryIdx);
            if (currSum <= target) {
                int currDiff = target - currSum;
                if (currDiff < bestDiff) {
                    bestDiff = currDiff;
                    result[0] = sweetList.get(sweetIdx);
                    result[1] = savoryList.get(savoryIdx);
                }
                savoryIdx++;
            } else {
                sweetIdx++;
            }
        }
        return result;
//        // Write your code here.
//        int[] result = new int[]{0,0};
//        Arrays.sort(dishes);
//        int left = 0;
//        int right = dishes.length - 1;
//        int maxTotal = Integer.MIN_VALUE;
//        while (dishes[left] < 0 && dishes[right] > 0) {
//            int total = dishes[left] + dishes[right];
//            if (total == target) {
//                result[0] = dishes[left];
//                result[1] = dishes[right];
//                return result;
//            }else if (total > target) right--;
//            else {
//                if (total > maxTotal) {
//                    result[0] = dishes[left];
//                    result[1] = dishes[right];
//                    left++;
//                    maxTotal = total;
//                }
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        int[] dishes = new int[]{-5,1,2,3,4,5,7,8,9,10,15};
        System.out.println(Arrays.toString(sweetAndSavory(dishes, 8)));
    }
}
