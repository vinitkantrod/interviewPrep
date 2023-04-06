/**
 * Link: https://leetcode.com/problems/count-items-matching-a-rule/solutions/
 */
package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsMatchingRules {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int match = 0;
        for (int i = 0; i < items.size(); i++) {
            switch (ruleKey) {
                case "type":
                    if (items.get(i).get(0).equals(ruleValue)) {
                        match++;
                    }
                    break;
                case "color":
                    if (items.get(i).get(1).equals(ruleValue)) {
                        match++;
                    }
                    break;
                case "name":
                    if (items.get(i).get(2).equals(ruleValue)) {
                        match++;
                    }
                    break;
                default:
                    break;
            }
        }
        return match;
    }
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(new ArrayList<String>(Arrays.asList("phone", "blue", "pixel")));
        items.add(new ArrayList<String>(Arrays.asList("computer","silver","lenovo")));
        items.add(new ArrayList<String>(Arrays.asList("phone","gold","iphone")));
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));
    }
}
