package com.vinit.dsalgo.trees.algoexpert;

import java.util.*;

public class FindNodesAtDistanceK {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair<U, V> {
        public final U value;
        public final V distance;
        public Pair(U value, V distance) {
            this.value = value;
            this.distance = distance;
        }
    }

    public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        Map<Integer, BinaryTree> parentNodes = new HashMap<>();
        findAllParentNodes(parentNodes, tree, null);
        BinaryTree targetNode = findTargetNode(parentNodes, target);
        targetNode = targetNode != null ? targetNode : tree;
        return breadthFirstSearch(parentNodes, targetNode, k);
    }

    public static ArrayList<Integer> breadthFirstSearch(Map<Integer, BinaryTree> parentNodes, BinaryTree targetNode, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair<BinaryTree, Integer>> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        q.offer(new Pair<>(targetNode, 0));
        int c = 0;
        while (!q.isEmpty()) {
            Pair<BinaryTree, Integer> pair = q.poll();
            BinaryTree currentNode = pair.value;
            int distanceNodesToK = pair.distance;
            seen.add(pair.value.value);
            System.out.println(currentNode.value);
            if (pair.distance == k) {
                while (!q.isEmpty()) {
                    Pair<BinaryTree, Integer> foundPair = q.poll();
                    res.add(foundPair.value.value);
                }
                res.add(pair.value.value);
                return res;
            }
            if (currentNode.left != null && !seen.contains(currentNode.left.value)) q.offer(new Pair<>(currentNode.left, distanceNodesToK + 1));
            if (currentNode.right != null && !seen.contains(currentNode.right.value)) q.offer(new Pair<>(currentNode.right, distanceNodesToK + 1));
            BinaryTree parent = parentNodes.get(currentNode.value);
            if (parent != null && !seen.contains(parent.value)) q.offer(new Pair<>(parent, distanceNodesToK + 1));
        }
        return res;
    }

    public static BinaryTree findTargetNode(Map<Integer, BinaryTree> parentNodes, int target) {
        if (parentNodes.containsKey(target)) {
            BinaryTree targetNodeParent = parentNodes.get(target);
            if (targetNodeParent != null)
            return (targetNodeParent.left != null && targetNodeParent.left.value == target) ? targetNodeParent.left : targetNodeParent.right;
        }
        return null;
    }

    public static void findAllParentNodes(Map<Integer, BinaryTree> parentNodes, BinaryTree node, BinaryTree parent) {
        if (node != null) {
            parentNodes.put(node.value, parent);
            findAllParentNodes(parentNodes, node.left, node);
            findAllParentNodes(parentNodes, node.right, node);
        }
    }

    public static void main(String args[]) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
//        BinaryTree b8 = new BinaryTree(8);
//        BinaryTree b9 = new BinaryTree(9);
//        BinaryTree b10 = new BinaryTree(10);
        b1.left= b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
//        b4.left = b8;
//        b4.right = b9;
//        b5.left = b10;
        System.out.println(Arrays.toString(findNodesDistanceK(b1, 1, 2).toArray()));
    }
}
