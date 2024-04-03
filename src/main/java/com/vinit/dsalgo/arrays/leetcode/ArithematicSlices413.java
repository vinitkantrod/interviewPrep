package com.vinit.dsalgo.arrays.leetcode;

public class ArithematicSlices413 {

    public static int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[ i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
                result += count;
            } else
                count = 0;
        }
        return result;
//        int result = 0;
//        int lastDiff = -1;
//        int lastCount = 0;
//        int start = 0, end = 0;
//        if (nums.length < 3) return 0;
//        for (int i = 1; i < nums.length; i++) {
//            int diff = Math.abs(nums[i] - nums[i - 1]);
//            if (diff != lastDiff) {
//                if (lastCount >= 2) {
//                    result += calculateResult(end - start + 1);
//                }
//                System.out.println("Result: " + result);
//                lastDiff = diff;
//                lastCount = 1;
//                start = i - 1;
//                end = i;
//                System.out.println(i + " --BEFORE: " + lastDiff + " - " + lastCount + ", result: " +result );
//                continue;
//            }
//            end++;
//            lastCount += 1;
//            lastDiff = diff;
//            System.out.println(lastDiff + " - " + lastCount + ", end: " + end);
//        }
//        if (lastCount >= 2) result += calculateResult(end - start + 1);
//        return result;
    }

    private static int calculateResult(int NumOfElements) {
        int res = 0;
        for (int i = 1; i <= NumOfElements - 2; i++) {
            res += i;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,3,5,7,8,9}));
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
