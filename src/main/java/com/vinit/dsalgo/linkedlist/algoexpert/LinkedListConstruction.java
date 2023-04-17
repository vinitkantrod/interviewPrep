package com.vinit.dsalgo.linkedlist.algoexpert;

public class LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if (head != null) {
                head.prev = node;
                node.next = head;
                node.prev = null;
            }
            head = node;
        }

        public void setTail(Node node) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode.next.value != nodeToInsert.value) {
                currentNode = currentNode.next;
            }
            currentNode.next.prev = node;
            node.next = currentNode.next;
            node.prev = currentNode;
            currentNode.next = node;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode.value != node.value) {
                currentNode = currentNode.next;
            }
            currentNode.next.prev = node;
            node.next = currentNode.next;
            node.prev = currentNode;
            currentNode.next = node;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            if (position == 1) {
                head.prev = nodeToInsert;
                nodeToInsert.next = head;
                head = nodeToInsert;
            }
            int i = 1;
            Node currentNode = head;
            while (i < position - 1) {
                currentNode = currentNode.next;
                i++;
            }
            currentNode.next.prev = nodeToInsert;
            nodeToInsert.next = currentNode.next;
            nodeToInsert.prev = currentNode;
            currentNode.next = nodeToInsert;
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node node = head;
            while (node != null) {
                Node nodeToRemove = node;
                node = node.next;
                if (nodeToRemove.value == value) remove(nodeToRemove);
            }
        }

        public void remove(Node node) {
            // Write your code here.
            if (node == head) head = head.next;
            if (node == tail) tail = tail.prev;
            removeNodeBindings(node);
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node node = head;
            while (node != null && node.value != value) node.next = node;
            return node != null;
        }

        public void removeNodeBindings(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
