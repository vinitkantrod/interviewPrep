package com.vinit.dsalgo.algoexpert.linkedlist;

import com.sun.source.tree.Tree;

public class DesignHashSet {

    class MyHashSet {

        private Bucket[] bucketArray;
        private final int keyRange;
        public MyHashSet() {
            this.keyRange = 769; // prime number
            this.bucketArray = new Bucket[keyRange];
            for (int i = 0; i < keyRange; i++) {
                this.bucketArray[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return (key % this.keyRange);
        }
        public void add(int key) {
            int bucketIndex = _hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = _hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        public Boolean contains(int key) {
            int bucketIndex = _hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }

    class Bucket {
        private BSTTree tree;
        public Bucket() {
            this.tree = new BSTTree();
        }

        public Boolean exists(int val) {
            TreeNode node = this.tree.searchInBST(this.tree.root, val);
            return (node != null);
        }

        public void delete(int val) {
            this.tree.root = this.tree.deleteIntoBST(this.tree.root, val);
        }

        public void insert(int val) {
            this.tree.root = this.tree.insertIntoBST(this.tree.root, val);
        }
    }
    class BSTTree {
        TreeNode root = null;
        public TreeNode searchInBST(TreeNode root, int val) {
            if (root == null || root.val == val) return root;
            return val < root.val ? searchInBST(root.left, val) : searchInBST(root.right, val);
        }
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);
            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else if (root.val == val) {
                return root;
            } else {
                root.left = insertIntoBST(root.left, val);
            }
            return root;
        }

        protected int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }
        protected int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }
        public TreeNode deleteIntoBST(TreeNode root, int val) {
            if (root == null) return root;
            if (val > root.val) {
                root.right = deleteIntoBST(root.right, val);
            } else if (val < root.val) {
                root.left = deleteIntoBST(root.left, val);
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteIntoBST(root.right, root.val);
                } else {
                    root.val = predecessor(root);
                    root.left = deleteIntoBST(root.left, root.val);
                }
            }
            return root;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
