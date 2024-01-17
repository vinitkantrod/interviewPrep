package com.vinit.dsalgo.algoexpert.arrays;

public class MajorityElements {

    public static int majorityElement(int[] array) {
        // Write your code here.
        int lastEle = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (lastEle == array[i]) count++;
            else {
                count--;
                if (count == 0) {
                    count++;
                    lastEle = array[i];
                }
            }
        }
        return lastEle;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,2,2,1,2};
        int[] arr = new int[]{2,2,2,2,3,1,1};
        System.out.println(majorityElement(arr));
    }
}
