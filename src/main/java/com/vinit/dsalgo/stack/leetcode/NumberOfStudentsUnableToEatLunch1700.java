package com.vinit.dsalgo.stack.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        for (int i : students) {
            queue.add(i);
        }
        int n = students.length;
        int check = n;
        while (!stack.empty()) {
            int student = queue.poll();
            int sandwich = stack.peek();
            if (student == sandwich) {
                stack.pop();
                n--;
                check = n;
            } else {
                queue.add(student);
                check--;
            }
            if (check == 0) break;
        }
        return (n > 0) ? n : 0;
    }
}
