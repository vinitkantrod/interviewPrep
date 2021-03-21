package com.vinit.dsalgo.heap.algoexpert;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        int[] result = new int[array.length];
        List<Integer> heaps = new ArrayList<>();
        int i = 0;
        while (i < Math.min(k + 1, array.length)) {
            heaps.add(array[i]);
            i++;
        }
        MinHeapDataStructure minHeapDataStructure = new MinHeapDataStructure(heaps);
        int j = 0;
        while (i < array.length) {
            result[j] = minHeapDataStructure.peek();
            minHeapDataStructure.remove();
            minHeapDataStructure.insert(array[i]);
            i++;
            j++;
        }
        System.out.println(Arrays.toString(result));
        System.out.println(minHeapDataStructure.heap.size() + " " + j);
        while (minHeapDataStructure.heap.size() > 0) {
            result[j] = minHeapDataStructure.peek();
            minHeapDataStructure.remove();
            j++;
        }
        System.out.printf("heap: " + Arrays.toString(result));
        return result;
    }

    static class MinHeapDataStructure {
        List<Integer> heap = new ArrayList<>();

        public MinHeapDataStructure(List<Integer> array) {
            this.heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            Integer firstParentIdx = (array.size() - 2) / 2;
//            System.out.println("buildHeap: " + firstParentIdx);
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                this.shiftDown(currentIdx, array.size() - 1, array);
//                System.out.println(currentIdx + " - " + Arrays.toString(array.toArray()));
            }
            return array;
        }

        public void shiftDown(Integer currentIdx, Integer endIdx, List<Integer> array) {
            Integer childrenOneIdx = currentIdx * 2 + 1;
            while (childrenOneIdx <= endIdx) {
                Integer childrenTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                Integer idxToSwap;
                if (childrenTwoIdx != -1 && array.get(childrenTwoIdx) < array.get(childrenOneIdx)) {
                    idxToSwap = childrenTwoIdx;
                } else {
                    idxToSwap = childrenOneIdx;
                }
                if (array.get(idxToSwap) < array.get(currentIdx)) {
                    this.swap(idxToSwap, currentIdx, array);
                    currentIdx = idxToSwap;
                    childrenOneIdx = currentIdx * 2 + 1;
                } else {
                    break;
                }
            }
        }

        public void shiftUp(Integer currentIdx, List<Integer> heap) {
            Integer parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                this.swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            }
        }

        public Integer peek() {
            return this.heap.get(0);
        }

        public void insert(Integer value) {
            this.heap.add(value);
            this.shiftUp(this.heap.size() - 1, this.heap);
        }

        public Integer remove() {
            this.swap(0, this.heap.size() - 1, this.heap);
            Integer valueToRemove = this.heap.get(this.heap.size() - 1);
            this.heap.remove(this.heap.size() - 1);
            this.shiftDown(0, this.heap.size() - 1, this.heap);
            return valueToRemove;
        }

        public void swap(int i, int j, List<Integer> array) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }

    public static void main(String args[]){
//        int[] arr = {3,2,1,5,4,7,6,5};
        int[] arr = {-1,-3,-4,2,1,3};
        sortKSortedArray(arr, 2);
    }
}
