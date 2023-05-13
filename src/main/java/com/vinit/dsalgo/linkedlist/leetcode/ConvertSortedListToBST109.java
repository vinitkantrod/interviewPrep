package com.vinit.dsalgo.linkedlist.leetcode;

public class ConvertSortedListToBST109 {

        public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
        }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = getMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (mid.val == head.val) {
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    public static ListNode getMiddleElement(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (prev != null) {
                prev.next = null;
            }
        }
        return slow;
    }
}
