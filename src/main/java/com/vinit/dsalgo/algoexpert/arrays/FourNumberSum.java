package com.vinit.dsalgo.algoexpert.arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        List<Integer[]> result = new ArrayList<>();
//        for (int a = 0; a < array.length - 3; a++) {
//            for (int b = a + 1; b < array.length - 2; b++) {
//                int left = b + 1;
//                int right = array.length - 1;
//                System.out.println(left + ".." + right);
//                System.out.println(array[a] + "." + array[b] + "." + array[left] + "." + array[right]);
//                while (left < right) {
//                    if (array[a] + array[b] + array[left] + array[right] == targetSum) {
//                        Integer[] ints = new Integer[]{array[a], array[b], array[left], array[right]};
//                        System.out.println(Arrays.toString(ints));
//                        result.add(ints);
//                        left++;
//                        right--;
//                    } else if (array[left] + array[right] > targetSum) {
//                        left++;
//                    } else {
//                        right--;
//                    }
//                }
//            }
//        }
//        return result;

        // O(N^2longN)
        int length = array.length;
        int size = (length * (length - 1)) / 2;
        Integer[][] allPairSum = new Integer[size][3];
        int k = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                Integer[] ints = new Integer[3];
                ints[0] = array[i];
                ints[1] = array[j];
                ints[2] = array[i] + array[j];
                allPairSum[k++] = ints;
            }
        }
        Arrays.sort(allPairSum, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (Integer[] x : allPairSum) {
            System.out.println(Arrays.asList(x));
        }
        int i = 0;
        int j = allPairSum.length - 1;
        List<Integer[]> result = new ArrayList<>();
        while (i < j) {
            System.out.println(Arrays.asList(allPairSum[i]) + " - " +  Arrays.asList(allPairSum[j]));
            if (noEqual(allPairSum[i], allPairSum[j]) &&
                    allPairSum[i][2] + allPairSum[j][2] == targetSum) {
                System.out.println("----");
                Integer[] temp = new Integer[] {allPairSum[i][0], allPairSum[i][1], allPairSum[j][0], allPairSum[j][1]};
                System.out.println(Arrays.asList(temp));
                result.add(temp);
                i++;
                j--;
            } else if (allPairSum[i][2] + allPairSum[j][2] < targetSum) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static Boolean noEqual(Integer[] a, Integer[] b) {
        return a[0] != b[0] && a[0] != b[1] && a[1] != b[0] && a[1] != b[1];
    }

    public static void main(String[] args) {
        int[] array = new int[] {7,6,4,-1,1,2};
        List<Integer[]> lists = fourNumberSum(array, 16);
        System.out.println(lists.size());
        for (Integer[] i : lists) {
            System.out.println(Arrays.asList(i));
        }
    }
}
