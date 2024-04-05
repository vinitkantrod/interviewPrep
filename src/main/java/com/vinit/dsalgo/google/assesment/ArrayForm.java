package com.vinit.dsalgo.google.assesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * The array-form of an integer num is an array representing its digits in left to right order.
 *
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 *
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 104
 * 0 <= num[i] <= 9
 * num does not contain any leading zeros except for the zero itself.
 * 1 <= k <= 104
 */
public class ArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int numIdx = num.length;
        String kk = String.valueOf(k);
        int kIdx = kk.length();
        int carry = 0;
        while (numIdx > 0 || kIdx > 0) {
            int temp = 0;
            if (numIdx > 0) {
                int numVal = num[numIdx - 1];
                numIdx--;
                temp += numVal;
            }
//            System.out.println("AfterNumVal : " + temp);
            if (kIdx > 0) {
                int kVal = kk.charAt(kIdx - 1) - 48;
                kIdx--;
                temp += kVal;
            }
//            System.out.println("After K Val: " + temp);
            temp += carry;
            if (temp > 9) {
                temp = temp % 10;
                carry = 1;
            } else {
                carry = 0;
            }
//            System.out.println("After rounding temp: " + temp);
            stack.push(temp);
//            System.out.println(stack);
        }
        if (carry == 1) stack.push(carry);
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(addToArrayForm(new int[]{2,7,4}, 181)));
        System.out.println(Arrays.asList(addToArrayForm(new int[]{1,2,0,0}, 34)));
        System.out.println(Arrays.asList(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1)));
    }
}
