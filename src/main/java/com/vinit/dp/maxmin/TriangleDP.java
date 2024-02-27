package com.vinit.dp.maxmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TriangleDP {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        List<int[]> ways = new ArrayList<>();
        int capacity = 3;
        int[] temp = new int[]{Integer.MAX_VALUE, triangle.get(0).get(0), Integer.MAX_VALUE};
        ways.add(temp);
        for (int i = 1; i < N; i++) {
            capacity++;
            temp = new int[capacity];
            temp[0] = temp[temp.length - 1] = Integer.MAX_VALUE;
            for (int j = 1; j < capacity - 1; j++) {
                temp[j] = Math.min(ways.get(i - 1)[j - 1], ways.get(i - 1)[j]) + triangle.get(i).get(j - 1);
            }
            ways.add(temp);
        }
        int minValue = ways.get(ways.size() - 1)[1];
        for (int val : ways.get(ways.size() - 1)) {
            minValue = Math.min(minValue, val);
        }
        return minValue;
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(2)));
        t.add(new ArrayList<>(Arrays.asList(3,4)));
        t.add(new ArrayList<>(Arrays.asList(6,5,7)));
        t.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(minimumTotal(t));
    }
}
