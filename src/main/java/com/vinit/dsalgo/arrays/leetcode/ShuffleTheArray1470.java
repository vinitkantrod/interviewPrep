package com.vinit.dsalgo.arrays.leetcode;

public class ShuffleTheArray1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int k = 0;
        int i = 0;
        int j = n;
        Boolean switchToSecond = false;
        while (k < 2*n) {
            if (switchToSecond) {
                res[k++] = nums[j++];
            } else {
                res[k++] = nums[i++];
            }
            switchToSecond = !switchToSecond;
        }
        return res;

        //
//        int[] a = new int[2*n];
//        int i=0,j;
//        for(j=0; j<2*n; j+=2){
//            a[j] = nums[i];
//            a[j+1] = nums[i+n];
//            i++;
//        }
//        return a;
    }
}
