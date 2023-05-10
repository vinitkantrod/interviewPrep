package com.vinit.dsalgo.graphs.leetcode;

import java.util.*;

public class KeysAndRooms841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        Stack<Integer> stack = new Stack<>();
//        Boolean[] seen = new Boolean[rooms.size()];
//        seen[0] = true;
//        stack.push(0);
//        while (!stack.empty()) {
//            int node = stack.pop();
//            for (int x : rooms.get(node)) {
//                if (!seen[x]) {
//                    stack.push(x);
//                    seen[x] = true;
//                }
//            }
//        }
//        for (Boolean b : seen) if (!b) return false;
//        return true;

        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }
    public static void main(String[] args) {

    }
}
