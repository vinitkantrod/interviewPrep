package com.vinit.dsalgo.design.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator284 {

    class PeekingIterator implements Iterator<Integer> {
        List<Integer> result = new ArrayList<>();
        int z = 0;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }
            System.out.println(Arrays.asList(result));
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return result.get(z);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return result.get(z++);
        }

        @Override
        public boolean hasNext() {
            return z < result.size();
        }
    }
    public static void main(String[] args) {

    }
}
