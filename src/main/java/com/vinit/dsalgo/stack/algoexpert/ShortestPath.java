package com.vinit.dsalgo.stack.algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortestPath {

    public static String shortenPath(String path) {
        Boolean tokenStartsWith = path.charAt(0) == '/';
        Stack<String> stack = new Stack<String>();
        String[] s = path.split("/");
        System.out.println(Arrays.toString(s));
        List<String> tokensArr = Arrays.asList(s);
        List<String> filteredTokensArr = tokensArr
                .stream()
                .filter(token -> isImportantToken(token))
                .collect(Collectors.toList());
        if (tokenStartsWith) stack.add("");
        System.out.println("F: " + Arrays.toString(filteredTokensArr.toArray()));
        for (String token: filteredTokensArr) {
            if (token.equals("..")) {
                System.out.println("ST: " + stack);
                if (stack.size() == 0 || stack.get(stack.size() - 1).equals("..")) {
                    stack.add(token);
                    System.out.println("SS:" + stack);
                } else if (!stack.get(stack.size() - 1).equals("")) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(token);
            }
        }
        System.out.println("S: " + Arrays.toString(stack.toArray()));
        if (stack.size() == 1 && stack.get(0).equals("")) return "/";
        return String.join("/", stack);
    }

    public static Boolean isImportantToken(String token) {
        return  token.length() > 0 && !token.equals(".");
    }
    public static void main(String args[]) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(shortenPath(".."));
    }
}
