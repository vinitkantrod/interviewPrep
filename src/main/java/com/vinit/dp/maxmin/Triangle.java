package com.vinit.dp.maxmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Triangle {

    public static int minSum = Integer.MAX_VALUE;
    public static int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int returnValue = calculateSum(triangle, 0, 0, 0);
        System.out.println("returnValue: "+ returnValue);
        return minSum;
    }
    private static int calculateSum(List<List<Integer>> triangle, int i, int j, int sum) {
        if (i < 0 || j >= triangle.get(i).size()) return 0;
        sum += triangle.get(i).get(j);
        System.out.println(i + "-" + j + " = " + sum);
        if (i == triangle.size() - 1) {
            minSum = Math.min(minSum, sum);
            return sum;
        }
        return  sum + Math.min(calculateSum(triangle, i + 1, j, sum),
                calculateSum(triangle, i + 1, j + 1, sum)
        );
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
//        t.add(new ArrayList<>(Arrays.asList(2)));
//        t.add(new ArrayList<>(Arrays.asList(3,4)));
//        t.add(new ArrayList<>(Arrays.asList(6,5,7)));
//        t.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        t.add(new ArrayList<>(Arrays.asList(-10)));
        System.out.println(minimumTotal(t));
    }
}
