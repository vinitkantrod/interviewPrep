package com.vinit.dsalgo.algoexpert.stack;

import java.util.*;

public class CollidingAsteroids {
    public static int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int ast = asteroids[i];
            if (ast > 0) {
                stack.push(ast);
                continue;
            }
            while (true) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast);
                    break;
                }
                int astSize = Math.abs(ast);
                if (stack.peek() > astSize) {
                    break;
                }
                if (stack.peek() == astSize) {
                    stack.pop();
                    break;
                }
                stack.pop();
            }
        }
        int stackSize = stack.size();
        Collections.reverse(stack);
        int[] res = new int[stackSize];
        for (int i = 0; i < stackSize; i++) res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{-3,5,-8,6,7,-4,-7};
        int[] a = new int[]{-70,100,23,42,-50,-75,1,-2,-3};
        System.out.println(Arrays.toString(collidingAsteroids(a)));
    }
}
