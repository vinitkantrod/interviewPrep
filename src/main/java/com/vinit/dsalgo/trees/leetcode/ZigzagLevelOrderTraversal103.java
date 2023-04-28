package com.vinit.dsalgo.trees.leetcode;

import java.util.*;

public class ZigzagLevelOrderTraversal103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//        q.add(root);
//        Boolean shouldIterateReverse = false;
//        while (!q.isEmpty()) {
//            List<Integer> tempRes = new ArrayList<>();
//            if (!shouldIterateReverse) {
//                Queue<TreeNode> tempQ = new LinkedList<>();
//                while (!q.isEmpty()) {
//                    TreeNode x = q.remove();
//                    if (x != null) tempQ.add(x);
//                }
//                while (!tempQ.isEmpty()) {
//                    TreeNode data = tempQ.remove();
//                    tempRes.add(data.val);
//                    q.add(data.left);
//                    q.add(data.right);
//                }
//                res.add(tempRes);
//            } else {
//                Stack<TreeNode> tempS = new Stack<>();
//                while (!q.isEmpty()) {
//                    TreeNode x = q.remove();
//                    if (x != null) tempS.push(x);
//                }
//                while (!tempS.empty()) {
//                    TreeNode data = tempS.pop();
//                    tempRes.add(data.val);
//                    q.add(data.left);
//                    q.add(data.right);
//                }
//                if (tempRes.size() > 0) res.add(tempRes);
//            }
//            shouldIterateReverse = !shouldIterateReverse;
//        }
//        return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        boolean flag=false;
        while(queue.size()>0)
        {
            int size = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i =0; i<size;i++)
            {
                TreeNode node = queue.poll();
                if(node.left !=null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(flag) subList.addFirst(node.val);//addFirst method adds the elements at the beginning of the list
                else subList.addLast(node.val);//the addLast method adds the elements at the end
            }
            flag=!flag;
            res.add(subList);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(Arrays.asList(zigzagLevelOrder(n)));
    }
}
