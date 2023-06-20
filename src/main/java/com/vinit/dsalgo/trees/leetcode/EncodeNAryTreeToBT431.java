package com.vinit.dsalgo.trees.leetcode;

import java.util.ArrayList;

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;

        TreeNode node = new TreeNode(root.val);
        if(root.children == null || root.children.isEmpty()) return node;
        node.left = encode(root.children.get(0));
        TreeNode nodeLeft = node.left;
        for(int i=1;i<root.children.size();i++) {
            nodeLeft.right = encode(root.children.get(i));
            nodeLeft = nodeLeft.right;
        }
        return node;

    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node node = new Node(root.val,new ArrayList<>());
        if(root.left == null && root.right == null) return node;
        if(root.left != null) node.children.add(decode(root.left));

        TreeNode rootLeft = root.left;
        while(rootLeft != null && rootLeft.right != null) {
            TreeNode rootLeftRight = rootLeft.right;
            root.left.right = null;
            node.children.add(decode(rootLeftRight));
            rootLeft = rootLeftRight;
        }
        return node;
    }
}
public class EncodeNAryTreeToBT431 {
}
