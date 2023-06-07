package com.vinit.dsalgo.strings.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList1313 {

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = 2 * i < nums.length ? nums[2 * i] : -1;
            if (freq == -1) break;
            int val = nums[2 * i + 1];
            int k = freq;
            while (k-- > 0) {
                res.add(val);
            }
        }
        System.out.println(Arrays.asList(res));
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n = {1,1,2,3,3,4,6,1};
        System.out.println(Arrays.toString(decompressRLElist(n)));
    }
}
