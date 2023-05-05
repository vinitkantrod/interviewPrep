package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity1436 {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < paths.size(); i++) {
            String s = paths.get(i).get(0);
            if (!map.containsKey(s)) map.put(s, 1);
            else map.put(s, 0);
            String e = paths.get(i).get(1);
            if (!map.containsKey(e)) map.put(e, 2);
            else map.put(e, 0);
        }
        String destination = "";
        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() == 2) destination = String.valueOf(m.getKey());
        }
        return destination;
    }
}
