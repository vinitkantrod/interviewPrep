package com.vinit.dsalgo.algoexpert.stack;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // difficult to make solution
        // Write your code here.
        if (stack.size() == 0) return stack;
        int top = stack.remove(stack.size() - 1);
        System.out.println("top: " + top);
        sortStack(stack);
        insertInSortedStack(stack, top);
        return stack;
    }
    private static void insertInSortedStack(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            System.out.println("Return Stack: " + List.of(stack));
            return;
        }
        int top = stack.remove(stack.size() - 1);
        System.out.println("I top: " + top);
        insertInSortedStack(stack, value);
        stack.add(top);
        System.out.println("R: " + List.of(stack));
    }
    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(-5,2,-2,4,3,1));
        System.out.println(List.of(sortStack(s)));
    }
}
