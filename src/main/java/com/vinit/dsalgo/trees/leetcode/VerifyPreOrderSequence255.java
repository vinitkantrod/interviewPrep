package com.vinit.dsalgo.trees.leetcode;

public class VerifyPreOrderSequence255 {

    public static boolean verifyPreorder(int[] preorder) {
        int n = preorder.length;
        for (int i = 0; i < preorder.length; i++) {
            System.out.println(i);
            int leftChildIdx = (2 * i) + 1;
            int rightChildIdx = (2 * i) + 2;
            System.out.println("l: " + leftChildIdx + ", r: " + rightChildIdx);
            if ((leftChildIdx < n &&
                    (preorder[i] < preorder[leftChildIdx]) ) ||
                    ( rightChildIdx < n && (preorder[i] > preorder[rightChildIdx])) ) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] t = {5,2,1,3,6};
        System.out.println(verifyPreorder(t));
    }
}
