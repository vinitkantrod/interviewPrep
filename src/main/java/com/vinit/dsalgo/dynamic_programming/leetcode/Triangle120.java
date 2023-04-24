package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Triangle120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow = triangle.get(0);
        int minPathSum = firstRow.get(0);
        dp.add(firstRow);
        for (int i = 1; i < triangle.size(); i++) {
            minPathSum = Integer.MAX_VALUE;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    temp.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                } else {
                    if (temp.size() == j) {
                        if (j < dp.get(i - 1).size() && j >= 0) {
                            temp.add(
                                    Math.min(
                                            dp.get(i - 1).get(j) + triangle.get(i).get(j),
                                            dp.get(i - 1).get(j - 1) + triangle.get(i).get(j)
                                    )
                            );
                        } else {
                            temp.add( dp.get(i - 1).get(j - 1) + triangle.get(i).get(j) );
                        }
                    }
                    else {
                        if (j < dp.get(i - 1).size() || j >= 0) {
                            temp.set(j,
                                    Math.min(
                                            dp.get(i - 1).get(j) + triangle.get(i).get(j),
                                            dp.get(i - 1).get(j - 1) + triangle.get(i).get(j)
                                    )
                            );
                        } else {
                            temp.set(j, dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                        }
                    }
                }
                System.out.println("dp[" + i + "][" + j + "] = " + temp.get(j));
                minPathSum = Math.min(minPathSum, temp.get(j));
                System.out.println(minPathSum);
            }
            System.out.println("temp: " + Arrays.asList(temp));
            dp.add(temp);
        }

        /**
         * LC code
         * List<int[]> ways = new ArrayList<>();
         *         int capacity = 3;
         *         int[] tmp;
         *         ways.add(new int[]{Integer.MAX_VALUE, triangle.get(0).get(0),Integer.MAX_VALUE});
         *         for (int i = 1; i < triangle.size(); i++)
         *         {
         *             capacity++;
         *             tmp = new int[capacity];
         *             tmp[0] = Integer.MAX_VALUE;
         *             tmp[capacity - 1] = Integer.MAX_VALUE;
         *             for (int j = 1; j < capacity - 1; j++)
         *                 tmp[j] = (Math.min(ways.get(i - 1)[j - 1], ways.get(i - 1)[j]) + triangle.get(i).get(j - 1));
         *             ways.add(tmp);
         *         }
         *         int min = ways.get(ways.size() - 1)[1];
         *         for (Integer num :ways.get(ways.size() - 1))
         *             min = Math.min(min, num);
         *         return min;
         */

        return minPathSum;
    }
    public static void main(String[] args) {
        List<List<Integer>> triangles = new ArrayList<>();
        triangles.add(new ArrayList<>(Arrays.asList(2)));
        triangles.add(new ArrayList<>(Arrays.asList(3,4)));
        triangles.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangles.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
//        triangles.add(new ArrayList<>(Arrays.asList(-1)));
//        triangles.add(new ArrayList<>(Arrays.asList(2,3)));
//        triangles.add(new ArrayList<>(Arrays.asList(1, -1, -3)));
//        triangles.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(minimumTotal(triangles));
    }
}
