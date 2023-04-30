package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignAOrderedStream1656 {

    public static void main(String[] args)  {
        OrderedStream od = new OrderedStream(5);
        od.insert(3, "ccc");
        od.insert(1, "aaa");
        od.insert(2, "bbb");
        od.insert(5, "eee");
        od.insert(4, "ddd");
    }
}

class OrderedStream {
    String[] res;
    int ptr;
    public OrderedStream(int n) {
        res = new String[n];
        ptr = 0;
        Arrays.fill(res, "");
    }

    public List<String> insert(int idKey, String value) {
        res[idKey - 1] = value;
        List<String> temp = new ArrayList<>();
        if (ptr == (idKey - 1)) {
            while (ptr < res.length && res[ptr] != "") {
                temp.add(res[ptr++]);
            }
        }
        return temp;
    }
}
