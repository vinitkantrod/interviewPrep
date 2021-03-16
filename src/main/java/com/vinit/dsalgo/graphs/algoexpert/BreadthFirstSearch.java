package com.vinit.dsalgo.graphs.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    static class Node{
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            if (this.children.size() == 0) {
                array.add(this.name);
                return array;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                array.add(currentNode.name);
                queue.addAll(currentNode.children);
            }
            return array;
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
