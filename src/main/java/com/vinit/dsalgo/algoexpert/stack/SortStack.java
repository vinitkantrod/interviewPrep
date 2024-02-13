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
        return new ArrayList<>();
    }

    private static void sort(ArrayList<Integer> stack, Stack<Integer> tempStack) {
        if (!stack.isEmpty()) {
//            System.out.println(List.of(stack) + " | " + List.of(tempStack));
            Integer i = stack.remove(stack.size() - 1);
            tempStack.add(i);
            sort(stack, tempStack);
        } else {
            System.out.println("<<<<<<<<<<<<empty>>>>>>>>>>>>");
            if (stack.isEmpty() && !tempStack.isEmpty()) {
                Integer i = tempStack.pop();
                stack.add(i);
            } else {
                Stack<Integer> currHolding = new Stack<>();
                while (stack.get(stack.size() - 1) > tempStack.peek()) {
                    currHolding.push(stack.remove(stack.size() - 1));
                }
                stack.add(stack.size() - 1, tempStack.pop());
                System.out.println(List.of(stack) + " | " + List.of(tempStack));
                while (!currHolding.isEmpty()) {
                    stack.add(stack.size() - 1, currHolding.pop());
                }
                System.out.println(List.of(stack) + " | " + List.of(tempStack));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(-5,2,-2,4,3,1));
        System.out.println(List.of(sortStack(s)));
    }
}
