package com.vinit.dsalgo.strings.leetcode;

import java.util.Arrays;

public class MinimiumSumOfFourDigitNum2160 {

    public int minimumSum(int num) {
        String s = String.valueOf(num);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String n1 = (ch[0] - '0') + "" + (ch[3] - '0');
        String n2 = (ch[1] - '0') + "" + (ch[2] - '0');
        System.out.println(n1 + " - " + n2);
        return Integer.valueOf(n1) + Integer.valueOf(n2);
    }

}
