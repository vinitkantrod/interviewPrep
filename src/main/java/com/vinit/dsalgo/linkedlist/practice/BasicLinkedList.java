package com.vinit.dsalgo.linkedlist.practice;

import com.vinit.dsalgo.linkedlist.leetcode.AddTwoNumbers2;

public class BasicLinkedList {

    public static class  LinkedList {
        Node head;
        Node tail;

        public class Node {
            int val;
            Node next;

            Node() {}
            Node (int val) {
                val = val;
                next = null;
            }

        }
        LinkedList() {}

        public void setHead(Node node) {
            if (head != null) {
                node.next = head;
            }
            head = node;
        }

        public void setTail(Node node) {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode.next = currentNode;
            }
            currentNode.next = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            Node currentNode = head;
            while (currentNode.next.val != node.val) {
                currentNode = currentNode.next;
            }
            nodeToInsert.next = currentNode.next;
            currentNode.next = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            Node currentNode = head;
            while (currentNode.val != node.val) {
                currentNode = currentNode.next;
            }
            node.next = currentNode.next;
            currentNode.next = node;
        }

        public void insertAtPosition(int pos, Node nodeToInsert) {
            if (pos == 1) {
                nodeToInsert.next = head;
                head = nodeToInsert;
            }
            int i = 1;
            Node currentNode = head;
            while (i < pos - 1) {
                currentNode = currentNode.next;
                i++;
            }
            nodeToInsert.next = currentNode.next;
            currentNode.next = nodeToInsert;
        }

        public void removeNodeWithValue(int value) {
            if (head == null) return;
            if (head.next == null && head.val != value) return;
            if (head.val == value) head = head.next;
            Node currentNode = head.next;
            Node prevNode = head;
            while (currentNode != null) {
                if (currentNode.val == value) {
                    prevNode.next = currentNode.next;
                }
                currentNode = currentNode.next;
                prevNode = prevNode.next;
            }
        }

        public Boolean containsNodesWithValue(int value) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.val == value) return true;
                currentNode =currentNode.next;
            }
            return false;
        }
        public void remove(Node node) {
            if (head != null || head.val == node.val) {
                Node newHead = head.next;
                head.next = null;
                head = newHead;
                return;
            }
            Node nextNode = head.next;
            Node currentNode = head;
            while ((nextNode != null) && (nextNode.val != node.val)) {
                if (nextNode.val == node.val) {
                    currentNode.next = nextNode.next;
                }
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
        }

        public void printList(Node n)
        {
            while (n != null) {
                System.out.print(n.val + " -> ");
                n = n.next;
            }
            System.out.println("null");
        }

    }
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
//        l.setHead(new (1));
//        l.head.next = new Node(2);
//        l.head.next.next = new Node(3);
//        l.head.next.next.next = new Node(4);
//        l.head.next.next.next.next = new Node(5);
        l.printList(l.head);
    }
}
