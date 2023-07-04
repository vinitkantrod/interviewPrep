package com.vinit.dsalgo.trees.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreOrder105 {

    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return ArrayToTree(preorder, 0, inorder.length - 1);
    }
    public TreeNode ArrayToTree(int[] preOrder, int start, int end) {
        if (start > end) return null;
        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = ArrayToTree(preOrder, start, inOrderIndexMap.get(rootValue) - 1);
        root.right = ArrayToTree(preOrder, inOrderIndexMap.get(rootValue) + 1, end);
        return root;
    }
}
