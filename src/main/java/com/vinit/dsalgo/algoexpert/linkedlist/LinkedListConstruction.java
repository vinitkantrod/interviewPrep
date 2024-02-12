package com.vinit.dsalgo.algoexpert.linkedlist;

public class LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if (head == null) {
                head = node;
                head.prev = null;
                tail = node;
                tail.next = null;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public void setTail(Node node) {
            // Write your code here.
            if (head == null) {
                head = node;
                tail = node;
                tail.next = null;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
                tail.next = null;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if (head.value == node.value) {
                this.setHead(nodeToInsert);
            } else {
                Node current = head;
                while (current.next != null && current.next != node) {
                    current = current.next;
                }
                insertNodeBinding(nodeToInsert, current);
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if (tail == node) {
                this.setTail(nodeToInsert);
                return;
            }
            insertNodeBinding(nodeToInsert, node);
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            Node dummy = new Node(-1);
            dummy.next = head;
            Node current = dummy;
            while (position - 1 > 0 ) {
                current = current.next;
                position--;
            }
            insertNodeBinding(nodeToInsert, current);
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            if (head.value == value) {
                head = head.next;
                removeNodeBinding(head);
                return;
            }
            if (tail.value == value) {
                tail = tail.prev;
                removeNodeBinding(tail);
                return;
            }
            Node current = head;
            while (current.next.value != value) {
                current = current.next;
            }
            removeNodeBinding(current.next);
        }

        public void remove(Node node) {
            if (head == node) head = head.next;
            if (tail == node) tail = tail.prev;
            removeNodeBinding(node);
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node current = head;
            while (current != null) {
                if (current.value == value) return true;
                current = current.next;
            }
            return false;
        }

        protected void removeNodeBinding(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        protected void insertNodeBinding(Node nodeToBeInsert, Node node) {
            nodeToBeInsert.next = node.next;
            nodeToBeInsert.prev = node;
            node.next.prev = nodeToBeInsert;
            node.next = nodeToBeInsert;
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

    public static void iterate(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.setHead(new Node(2));
        dll.setTail(new Node(10));
        dll.insertBefore(dll.head, new Node(0));
        dll.insertBefore(dll.tail, new Node(3));
        dll.insertBefore(dll.head.next, new Node(1));
        dll.insertAfter(dll.head, new Node(11));
        dll.insertAfter(dll.tail, new Node(20));
        dll.insertAfter(dll.head.next.next, new Node(15));
        System.out.println(dll.containsNodeWithValue(0));
        dll.remove(dll.head);
        System.out.println(dll.containsNodeWithValue(0));
//        dll.remove(dll.head);
        dll.removeNodesWithValue(3);
        iterate(dll.head);
        dll.insertAtPosition(5, new Node(3));
        iterate(dll.head);
    }
}
