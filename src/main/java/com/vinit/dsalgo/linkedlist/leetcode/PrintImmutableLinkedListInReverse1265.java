package com.vinit.dsalgo.linkedlist.leetcode;

 interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
  };
public class PrintImmutableLinkedListInReverse1265 {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
