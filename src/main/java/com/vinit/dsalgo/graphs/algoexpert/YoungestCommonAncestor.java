package com.vinit.dsalgo.graphs.algoexpert;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);
        if (depthOne > depthTwo) return backtrackAncestoralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        else return backtrackAncestoralTree(descendantTwo, descendantOne, depthTwo - depthOne);
    }

    public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            depth += 1;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    public static AncestralTree backtrackAncestoralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
        while (diff > 0) {
            diff--;
            lowerDescendant = lowerDescendant.ancestor;
        }
        while (lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String args[]) {

    }
}
