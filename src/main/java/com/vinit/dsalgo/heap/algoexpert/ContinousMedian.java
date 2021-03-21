package com.vinit.dsalgo.heap.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class ContinousMedian {

    static class ContinuousMedianHandler {
        Heap smaller = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<>());
        Heap greater = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<>());
        double median = 0;

        public void insert(int number) {
            // Write your code here.
            if (smaller.heapLength == 0 || number < smaller.peek()) {
                smaller.insert(number);
            } else {
                greater.insert(number);
            }
            rebalanceHeap();
            updateMedian();
        }

        public void rebalanceHeap() {
            if (greater.heapLength - smaller.heapLength == 2) {
                smaller.insert(greater.remove());
            } else if (smaller.heapLength - greater.heapLength == 2) {
                greater.insert(smaller.remove());
            }
        }

        public void updateMedian() {
            if (smaller.heapLength == greater.heapLength) {
                median = ( (double) smaller.peek() + (double) greater.peek() ) / 2;
            } else if (smaller.heapLength > greater.heapLength) {
                median = smaller.peek();
            } else {
                median = greater.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }

    public static class Heap {
        List<Integer> heap = new ArrayList<>();
        BiFunction<Integer, Integer, Boolean> currentFunc;
        int heapLength;

        public Heap(BiFunction<Integer, Integer, Boolean> func, List<Integer> heap) {
            heap = buildHeap(heap);
            currentFunc = func;
            heapLength = heap.size();
        }

        public List<Integer> buildHeap(List<Integer> heap) {
            int firstParentIdx = (int) Math.floor((heap.size() - 2) / 2);
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                shiftDown(currentIdx, heap.size() - 1, heap);
            }
            return heap;
        }

        public void shiftDown(int currentIdx, int endIdx, List<Integer> heap) {
            Integer childOneIdx = currentIdx * 2 + 1;
            System.out.println(currentIdx + ", end: " + endIdx + ", a: " + Arrays.toString(heap.toArray()));
            while (childOneIdx <= endIdx) {
                Integer childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                Integer idxToApply;
                System.out.println("childTwoIdx: " + childTwoIdx + ", 1: " + childOneIdx);
                if (childTwoIdx != - 1 && currentFunc.apply(heap.get(childTwoIdx), heap.get(childOneIdx))) {
                    idxToApply = childTwoIdx;
                } else {
                    idxToApply = childOneIdx;
                }
                System.out.println("idx: " + idxToApply + ", func: " + currentFunc.apply(heap.get(idxToApply), heap.get(currentIdx)));
                if (currentFunc.apply(heap.get(idxToApply), heap.get(currentIdx))) {
                    this.swap(idxToApply, currentIdx, heap);
                    currentIdx = idxToApply;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
                System.out.println("idx:" + idxToApply + ", cur: " + currentIdx + ", child: " + childOneIdx + ", end: " + endIdx );
            }
        }

        public void shiftUp(int currentIdx, List<Integer> heap) {
            Integer parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            while (currentIdx >= 0) {
                if (currentFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
                    this.swap(parentIdx, currentIdx, heap);
                    currentIdx = parentIdx;
                    parentIdx = (int) Math.floor((currentIdx - 1) / 2);
                } else break;
            }
        }

        public void insert(Integer value) {
            heap.add(value);
            shiftUp(heap.size() - 1, heap);
            heapLength++;
        }

        public Integer remove() {
            this.swap(0, heap.size() - 1, heap);
            Integer valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            heapLength--;
            shiftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public Integer peek() {
            return heap.get(0);
        }
        public void swap(int a, int b, List<Integer> array) {
            int temp = array.get(a);
            array.set(a, array.get(b));
            array.set(b, temp);
        }

        public static Boolean MAX_HEAP_FUNC(Integer a, Integer b) {
            return a > b;
        }

        public static Boolean MIN_HEAP_FUNC(Integer a, Integer b) {
            return a < b;
        }
    }

    public static void main(String args[]) {
        ContinuousMedianHandler continuousMedianHandler = new ContinuousMedianHandler();
        continuousMedianHandler.insert(5);
        continuousMedianHandler.insert(10);
        continuousMedianHandler.insert(100);
        System.out.println(continuousMedianHandler.getMedian());
        continuousMedianHandler.insert(200);
        System.out.println(continuousMedianHandler.getMedian());
    }
}
