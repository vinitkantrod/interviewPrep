package com.vinit.dsalgo.mathematics.leetcode;

public class AddDigits258 {

    public static int addDigits(int num) {
//        int sum = 0;
//        while (num > 9) {
//            int sum = 0;
//            System.out.println(num);
//            while (num > 0) {
//                sum += num % 10;
//                num /= 10;
//            }
//            num = sum;
//        }
//        return num;
//
        // LC code
//        O(1)
        if (num == 0) return 0;
        else if (num % 9 == 0) {
            return 9;
        } else return num % 9;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(21));
    }
}
