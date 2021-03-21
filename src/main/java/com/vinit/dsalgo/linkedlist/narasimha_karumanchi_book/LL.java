package com.vinit.dsalgo.linkedlist.narasimha_karumanchi_book;

//import com.sun.istack.internal.NotNull;

public class LL {
    private Node head;
    private int length;

    public LL(Node h) {
        this.head = h;
        this.length = 1;
    }

    public void traverse() {
        System.out.println("Traversing a List");
        if (this.head == null) return;
        Node current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.print("Null");
        System.out.println();
    }

    public void insertAtBeginning(int d) {
        System.out.println("Inserting a node " + d + " at the beginning.");
        Node newNode = new Node(0);
        if (this.head == null) this.head = newNode;
        newNode.setNext(this.head);
        this.head = newNode;
        traverse();
        System.out.println();
    }

    public void insertAtEnd(int d) {
        System.out.println("Inserting a node " + d + " at the end.");
        Node newNode = new Node(d);
        if (this.head == null) this.head = newNode;
        Node current = this.head;
        while (current.hasNext()) {
            current = current.getNext();
        }
        current.setNext(newNode);
        traverse();
    }

    public void insertInBetweenWithPos(int d, int pos) {
        System.out.println("Inserting a node " + d + " at position " + pos);
        if (pos < 0) return;
        Node newNode = new Node(d);
        Node currentNode = this.head;
        int count = 1;
        while (count < pos - 1) {
            count = count + 1;
            currentNode = currentNode.getNext();
        }
        System.out.println(count);
        if (count + 1 < pos ) return;
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        traverse();
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.setNext(n2);
        Node n3 = new Node(3);
        n2.setNext(n3);
        Node n4 = new Node(4);
        n3.setNext(n4);
        Node n5 = new Node(44);
        n4.setNext(n5);
        Node n6 = new Node(6);
        n5.setNext(n6);
        Node n7 = new Node(7);
        n6.setNext(n7);
        LL l = new LL(n1);
        // Traverse LL
        l.traverse();
        // Insert at Beginning
        l.insertAtBeginning(0);
        // Insert at End
        l.insertAtEnd(8);
        // Insert in between
        l.insertInBetweenWithPos(5, 6);
    }
}

class Node {
    private int data;
    private Node next;
    public Node(int d) {
        this.data = d;
        this.next = null;
    }
    public int getData() {return this.data;}
    public void setData(int d) {this.data = d;}
    public Node getNext() {return this.next;}
    public void setNext(Node n) {this.next = n;}
    public boolean hasNext() {return this.next != null;}
}
