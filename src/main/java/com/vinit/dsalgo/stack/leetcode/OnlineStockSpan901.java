package com.vinit.dsalgo.stack.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan901 {

    class StockSpanner {
        List<Integer> stack;
        public StockSpanner() {
            stack = new ArrayList<>();
        }

        public int next(int price) {
            stack.add(price);
            int count = 0;
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (stack.get(i) <= price) count++;
                else break;
            }
            return count;
        }
    }
}
