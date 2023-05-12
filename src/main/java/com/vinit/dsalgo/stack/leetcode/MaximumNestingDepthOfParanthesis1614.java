package com.vinit.dsalgo.stack.leetcode;

import java.util.Stack;

public class MaximumNestingDepthOfParanthesis1614 {

    public static int maxDepth(String s) {
//        if (s.equals("")) return 0;
//        Stack<Character> stack = new Stack<Character>();
//        int maxDepth = 0;
//        int depth = 0;
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                depth++;
//                if (depth > maxDepth) maxDepth = depth;
//                stack.push(c);
//            }
//            if (c == ')') {
//                depth--;
//                stack.pop();
//            }
//        }
//        return maxDepth;

        int count = 0;
        int max = 0;

        for(char c:s.toCharArray()){
            if(c=='('){
                count++;
            }else if(c==')'){
                max = Math.max(max,count--);
            }
        }

        return max;
    }
}
