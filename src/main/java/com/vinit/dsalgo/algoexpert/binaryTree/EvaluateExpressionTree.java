package com.vinit.dsalgo.algoexpert.binaryTree;

public class EvaluateExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int evaluateExpressionTree(BinaryTree tree) {
        // Write your code here.
        int result = evaluate(tree, 0);
        return result;
    }

    public static int evaluate(BinaryTree node, int result) {
        if (node.left == null && node.right == null) {
            return node.value;
        }
        int leftResult = evaluate(node.left, result);
        int rightResult = evaluate(node.right, result);
        int r = getResult(leftResult, rightResult, node.value);
        System.out.println(node.value+" :: "+leftResult+" " + rightResult+" == "+r);
        return r;
    }

    public static int getResult(int left, int right, int value) {
        switch (value) {
            case -1:
                return left + right;
            case -2:
                return left - right;
            case -3:
                return Math.round(left / right);
            case -4:
                return left * right;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        BinaryTree r = new BinaryTree(-1);
        r.left = new BinaryTree(-2);
        r.right = new BinaryTree(-3);
        r.left.left = new BinaryTree(-4);
        r.left.right = new BinaryTree(2);
        r.right.left = new BinaryTree(8);
        r.right.right = new BinaryTree(3);
        r.left.left.left = new BinaryTree(2);
        r.left.left.right = new BinaryTree(3);
        System.out.println(evaluateExpressionTree(r));

    }
}
