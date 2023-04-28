package com.vinit.dsalgo.trees.leetcode;

public class MinimumDepthofBT111 {

    public static int minDepth(TreeNode root) {
//        if (root == null) return 0;
////        if (root.left == null && root.right == null) return 1;
////        if (root.left == null || root.right == null) return 0;
//        int l = minDepth(root.left);
//        int r = minDepth(root.right);
//        if ((l == 0 && r == 0) || (l != 0 && r != 0)) return 1 + Math.min(l, r);
//        return 1 + Math.max(minDepth(root.left), minDepth(root.right));

        // LC BFS iteration code
//        LinkedList<Pair<TreeNode, Integer>> queue = new Link<>();
//        if (root == null) {
//            return 0;
//        }
//        else {
//            queue.add(new Pair(root, 1));
//        }
//
//        int current_depth = 0;
//        while (!queue.isEmpty()) {
//            Pair<TreeNode, Integer> current = queue.poll();
//            root = current.getKey();
//            current_depth = current.getValue();
//            if ((root.left == null) && (root.right == null)) {
//                break;
//            }
//            if (root.left != null) {
//                queue.add(new Pair(root.left, current_depth + 1));
//            }
//            if (root.right != null) {
//                queue.add(new Pair(root.right, current_depth + 1));
//            }
//        }
//        return current_depth;

        // Recurssive
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.right = new TreeNode(9);
        n.right.right = new TreeNode(20);
        n.right.right.right = new TreeNode(15);
        n.right.right.right.right = new TreeNode(7);
        System.out.println(minDepth(n));
    }
}
