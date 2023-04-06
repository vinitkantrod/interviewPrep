/**
 * Incomplete
 * Link: https://leetcode.com/problems/design-an-ordered-stream/
 */
package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    public static void main(String[] args) {
        OrderedStream1 os = new OrderedStream1(5);
        os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
        os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
        os.insert(4, "ddddd");
    }
}

class OrderedStream1 {

    ArrayList<String> stream;
    public OrderedStream1(int n) {
        stream = new ArrayList<>(n);
    }

    public List<String> insert(int idKey, String value) {
        return stream;
    }
}
