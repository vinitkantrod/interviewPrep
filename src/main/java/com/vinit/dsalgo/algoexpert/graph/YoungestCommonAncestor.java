package com.vinit.dsalgo.algoexpert.graph;

import java.util.HashMap;
import java.util.Map;

public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        Map<Character, AncestralTree> map = new HashMap<>();
        AncestralTree t1 = descendantOne;
        AncestralTree t2 = descendantTwo;
        while (t1 != null || t2 != null) {
            if (t1 != null) {
                System.out.println("checking for : " + t1.name);
                if (map.containsKey(t1.name)) return map.get(t1.name);
                map.put(t1.name, t1);
                t1 = t1.ancestor;
            }
            if (t2 != null) {
            System.out.println("checking for : " + t2.name + " | " + map.containsKey(t2.name));
                if (map.containsKey(t2.name)) return map.get(t2.name);
                map.put(t2.name, t2);
                t2 = t2.ancestor;
            }
            System.out.println(map);
        }
        return topAncestor; // Replace this line
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

    public static void main(String[] args) {
        AncestralTree a = new AncestralTree('A');
        AncestralTree b = new AncestralTree('B');
        AncestralTree c = new AncestralTree('C');
        AncestralTree d = new AncestralTree('D');
        AncestralTree e = new AncestralTree('E');
        AncestralTree f = new AncestralTree('F');
        AncestralTree g = new AncestralTree('G');
        AncestralTree h = new AncestralTree('H');
        AncestralTree i = new AncestralTree('I');
        h.ancestor = d;
        i.ancestor = d;
        d.ancestor = b;
        e.ancestor = b;
        f.ancestor = c;
        g.ancestor = c;
        b.ancestor = a;
        c.ancestor = a;
        a.ancestor = null;
        System.out.println(getYoungestCommonAncestor(a, c, a).name);

    }
}
