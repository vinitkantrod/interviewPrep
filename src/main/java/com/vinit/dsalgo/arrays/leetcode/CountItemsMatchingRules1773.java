package com.vinit.dsalgo.arrays.leetcode;

import java.util.List;

public class CountItemsMatchingRules1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) count += matchTypeAndValue(items.get(i), ruleKey, ruleValue);
        return count;
    }

    public int matchTypeAndValue(List<String> item, String ruleKey, String ruleValue) {
        switch (ruleKey) {
            case "type":
                if (item.get(0).equals(ruleValue)) return 1;
                return 0;
            case "color":
                if (item.get(1).equals(ruleValue)) return 1;
                return 0;
            case "name":
                if (item.get(2).equals(ruleValue)) return 1;
                return 0;
            default:
                return 0;
        }
    }
}
