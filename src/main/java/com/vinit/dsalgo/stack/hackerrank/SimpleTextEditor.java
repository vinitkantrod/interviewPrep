package com.vinit.dsalgo.stack.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor {

    public static class Stack {
        public List<StackNode> stackData;
        public int top;
        public Stack() {
            this.stackData = new ArrayList<StackNode>();
            this.top = -1;
        }
        public void push(StackNode s) {
            stackData.add(s);
            top++;
        }
        public StackNode pop() {
            if (top >= 0) return stackData.remove(top--);
            return null;
        }
        public StackNode top() {
            if (top >= 0) return stackData.get(top);
            return null;
        }
        @Override
        public String toString() {
            String S = "";
            int temp = top;
            if (temp < 0) return "Empty Stack";
            while (temp >= 0 ) {
                S = S + " | " + stackData.get(temp).toString();
                temp--;
            }
            S += " | ";
            return S;
        }
    }

    public static class StackNode {
        public String op;
        public String data;
        public StackNode(String op, String data) {
            this.op = op;
            this.data = data;
        }
        @Override
        public String toString() {
            return "(" + op + " : " + data + ")";
        }
    }

    public static void fileEditor() {

        String S = "";
        Stack stack = new Stack();
        List<String> printRes = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int Q = Integer.parseInt(reader.readLine());
            while (Q-- > 0) {
                String[] s = reader.readLine().split(" ");
                String operation = s[0];
                String param = "";
                if (!operation.equals("4")) param = s[1];
                if (operation.equals("1")) {
                    S += param;
                    stack.push(new StackNode("+", param));
                } else if (operation.equals("2")) {
                    String sub = S.substring(S.length() - Integer.parseInt(param), S.length());
                    S = S.substring(0, S.length() - Integer.parseInt(param));
                    stack.push(new StackNode("-", sub));
                } else if (operation.equals("3")) {
                    printRes.add(String.valueOf(S.charAt(Integer.parseInt(param) - 1)));
                } else if (operation.equals("4")) {
                    StackNode stackNode = stack.pop();
                    if (stackNode != null) {
                        if (stackNode.op.equals("-")) {
                            S += stackNode.data;
                        } else {
                            int len = stackNode.data.length();
                            S = S.substring(0, S.length() - len);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (String s : printRes) {
            System.out.println(s);
        }
    }

    public static void main(String args[]) {
        fileEditor();
    }
}
