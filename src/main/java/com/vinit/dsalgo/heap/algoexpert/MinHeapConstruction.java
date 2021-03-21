package com.vinit.dsalgo.heap.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
//            System.out.printf("Building min heap...");
            Integer firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx-- ) {
                this.siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            Integer childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                Integer childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1 ;
                Integer idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    this.swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    break;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            Integer parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                this.swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            this.swap(0, this.heap.size() - 1, this.heap);
            Integer valueToRemove = this.heap.remove(this.heap.size() - 1);
            this.siftDown(0, this.heap.size() - 1, this.heap);
            return valueToRemove;
        }

        public void insert(int value) {
            // Write your code here.
            this.heap.add(value);
            this.siftUp(this.heap.size() - 1, this.heap);
        }

        public void swap(int i, int j, List<Integer> array) {
            Integer temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }

    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(40,12,24,7,8,-5,24,391,24,56,2,6,8,41));
        System.out.println("Input: " + Arrays.toString(arr.toArray()));
        MinHeap minHeap = new MinHeap(arr);
        minHeap.buildHeap(arr);
        System.out.println("heap: " + Arrays.toString(minHeap.heap.toArray()));
        minHeap.insert(76);
        System.out.println("heap: " + Arrays.toString(minHeap.heap.toArray()));
        minHeap.peek();
        minHeap.remove();
        System.out.println("heap: " + Arrays.toString(minHeap.heap.toArray()));
        minHeap.peek();
        minHeap.remove();
        minHeap.peek();
        System.out.println("heap: " + Arrays.toString(minHeap.heap.toArray()));
        minHeap.insert(87);
        System.out.println("heap: " + Arrays.toString(minHeap.heap.toArray()));
    }
}
