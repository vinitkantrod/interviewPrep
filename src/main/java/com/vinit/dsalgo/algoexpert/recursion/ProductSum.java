package com.vinit.dsalgo.algoexpert.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        int depth = 1;
        return sumOfDepth(array, depth);
    }
    private static int sumOfDepth(List<Object> array, int depth) {
        int sum = 0;
        for (Object o : array) {
            if (o instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> al = (ArrayList<Object>) o;
                sum += sumOfDepth(al, depth + 1);
            } else {
                sum += (int) o;
            }
        }
        return sum * depth;
    }

    public static void main(String[] args) {
        List<Object> a = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Object> a1 = new ArrayList<>(Arrays.asList(5,5));
        List<Object> a2 = new ArrayList<>(Arrays.asList(10, 10));
        a1.add(a2);
        a.add(a1);
        System.out.println(productSum(a));
    }
}
