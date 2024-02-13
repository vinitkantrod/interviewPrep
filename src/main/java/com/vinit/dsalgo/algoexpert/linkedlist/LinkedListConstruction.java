package com.vinit.dsalgo.algoexpert.linkedlist;

public class LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void setTail(Node node) {
            // Write your code here.
            if (tail == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node node = head;
            int currentPosition = 1;
            while (node != null && currentPosition++ != position) node = node.next;
            if (node != null) insertBefore(node, nodeToInsert);
            else setTail(nodeToInsert);
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
