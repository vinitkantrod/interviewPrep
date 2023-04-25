package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArray350 {

    public static int[] intersect(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        List<Integer> res = new ArrayList<>();
        int x = 0;
        int y = 0;
        while (x < num1.length && y < num2.length) {
            if (num1[x] == num2[y]) {
                res.add(num1[x]);
                x++;
                y++;
            } else if (num1[x] < num2[y]) x++;
            else y++;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,2,1,3,3,4,2};
        int[] n2 = {2,2};
        System.out.println(Arrays.toString(intersect(n1, n2)));

    }
}
