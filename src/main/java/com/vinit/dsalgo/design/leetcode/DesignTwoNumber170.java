package com.vinit.dsalgo.design.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    Map<Integer, Integer> frequency;
    public TwoSum() {
        frequency = new HashMap<>();
    }

    public void add(int number) {
        if (frequency.containsKey(number)) {
            frequency.replace(number, frequency.get(number) + 1);
        } else {
            frequency.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> m : frequency.entrySet()) {
            int complement = value - m.getKey();
            if (complement != m.getKey()) {
                if (frequency.containsKey(complement)) {
                    return true;
                }
            } else {
                if (m.getValue() > 1) return true;
            }
        }
        return false;
    }
}
public class DesignTwoNumber170 {

}
