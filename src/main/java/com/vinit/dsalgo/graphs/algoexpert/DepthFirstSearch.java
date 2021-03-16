package com.vinit.dsalgo.graphs.algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    static class Node{
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            if (this.children.size() <= 0) {
                array.add(this.name);
                return array;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(this);
            while (!stack.empty()) {
                Node currentNode = stack.pop();
                array.add(currentNode.name);
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.push(currentNode.children.get(i));
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String args[]) {

    }
}
