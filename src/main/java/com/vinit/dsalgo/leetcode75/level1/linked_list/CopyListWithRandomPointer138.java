package com.vinit.dsalgo.leetcode75.level1.linked_list;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer138 {
    Map<Node, Node> visitedMap = new HashMap<>();

    public Node copyRandomNode(Node node) {
        if (node != null) {
            if (visitedMap.containsKey(node)) {
                return visitedMap.get(node);
            } else {
                visitedMap.put(node, new Node(node.val));
                return visitedMap.get(node);
            }
        }
        return null;
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node oldNode = head;

        Node newNode = new Node(oldNode.val);
        visitedMap.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.random = copyRandomNode(oldNode.random);
            newNode.next = copyRandomNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedMap.get(head);
    }
}
