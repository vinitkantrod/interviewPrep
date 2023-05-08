package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagConversion6 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> lst = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < numRows;j++) {
            StringBuilder sb = new StringBuilder();
            lst.add(sb);
        }
        Boolean reverse = false;
        int k = 0;
        while (i < s.length()) {
            StringBuilder sb = lst.get(k);
            sb.append(s.charAt(i));
            if (!reverse) {
                if (k == numRows - 1) {
                    reverse = true;
                    k--;
                } else k++;
            } else {
                if (k == 0) {
                    reverse = false;
                    k++;
                } else k--;
            }
            i++;
        }
        StringBuilder master = new StringBuilder();
        for (i = 0; i < numRows; i++){
            master.append(lst.get(i));
        }
        return master.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("paypalishiring", 4));
    }
}
