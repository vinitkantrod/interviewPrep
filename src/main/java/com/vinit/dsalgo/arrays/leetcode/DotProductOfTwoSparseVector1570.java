package com.vinit.dsalgo.arrays.leetcode;

public class DotProductOfTwoSparseVector1570 {

    class SparseVector {
        int[] num;
        SparseVector(int[] nums) {
            num = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int sum = 0;
            for (int i =0; i< num.length; i++) {
                if (num[i] != 0) sum += num[i] * vec.num[i];
            }
            return sum;
        }
    }

}
