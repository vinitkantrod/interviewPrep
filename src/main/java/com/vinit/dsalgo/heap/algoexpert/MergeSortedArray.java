package com.vinit.dsalgo.heap.algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeSortedArray {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        List<HeapDataNode> nodes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            HeapDataNode heapDataNode = new HeapDataNode(arrays.get(i).get(0), i);
            nodes.add(heapDataNode);
        }
        SortedHeap sortedHeap = new SortedHeap(nodes);
//        printData(sortedHeap);
        while (true) {
            if (sortedHeap.heap.size() == 0) break;
            HeapDataNode heapDataNode = sortedHeap.peek();
//            printData(sortedHeap);
            sortedHeap.remove();
//            printData(sortedHeap);
            int idx = heapDataNode.idx;
            result.add(heapDataNode.value);
            if (arrays.get(idx).size() > 0)
                arrays.get(idx).remove(0);
            if (arrays.get(idx).size() == 0) {
                continue;
            }
            HeapDataNode newDataNode = new HeapDataNode(arrays.get(heapDataNode.idx).get(0), heapDataNode.idx);
            sortedHeap.insert(newDataNode);
        }

//        System.out.println("final result: " + Arrays.toString(result.toArray()));

        return result;
    }

    public static void printData(SortedHeap sortedHeap) {
        for (int i = 0; i < sortedHeap.heap.size(); i++) {
            System.out.printf(sortedHeap.heap.get(i).value + " ");
        }
        System.out.println("");
    }

    static class HeapDataNode {
        public Integer value;
        public Integer idx;

        public HeapDataNode(Integer v, Integer id) {
            value = v;
            idx = id;
        }
    }

    static class SortedHeap {
        List<HeapDataNode> heap;

        public SortedHeap(List<HeapDataNode> d) {
            heap = buildHeap(d);
        }

        public List<HeapDataNode> buildHeap(List<HeapDataNode> array) {
            Integer parentIdx = (int) Math.floor((array.size() - 2) / 2);
            for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
                shiftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void shiftDown(Integer currentIdx, Integer endIdx, List<HeapDataNode> array) {
            Integer childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                Integer childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                Integer idxToSwap;
                if (childTwoIdx != -1 && array.get(childTwoIdx).value < array.get(childOneIdx).value) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (array.get(idxToSwap).value < array.get(currentIdx).value) {
                    swap(idxToSwap, currentIdx, array);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    break;
                }
            }
        }

        public void shiftUp(Integer currentIdx, List<HeapDataNode> array) {
            Integer parentIdx = (int) Math.floor((currentIdx - 1) / 2);
            while (currentIdx >= 0) {
                if (array.get(currentIdx).value < array.get(parentIdx).value) {
                    swap(currentIdx, parentIdx, array);
                    currentIdx = parentIdx;
                    parentIdx = (int) Math.floor((currentIdx - 1) / 2);
                } else {
                    break;
                }
            }
        }

        public HeapDataNode peek() {
            return heap.get(0);
        }

        public void insert(HeapDataNode node) {
            heap.add(node);
            shiftUp(heap.size() - 1, heap);
        }

        public HeapDataNode remove() {
            swap(0, heap.size() - 1, heap);
            HeapDataNode nodeToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            shiftDown(0, heap.size() - 1, heap);
            return nodeToRemove;
        }

        public void swap(Integer a, Integer b, List<HeapDataNode> array){
            HeapDataNode temp = array.get(a);
            array.set(a, array.get(b));
            array.set(b, temp);
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1,5,9,21)));
        arrays.add(new ArrayList<>(Arrays.asList(-1,0)));
        arrays.add(new ArrayList<>(Arrays.asList(-124,81,121)));
        arrays.add(new ArrayList<>(Arrays.asList(3,6,12,20,150)));
        mergeSortedArrays(arrays);
    }
}
