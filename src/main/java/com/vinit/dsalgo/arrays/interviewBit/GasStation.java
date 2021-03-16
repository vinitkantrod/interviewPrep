package com.vinit.dsalgo.arrays.interviewBit;

public class GasStation {

    public static int traverseGasStation(int[] A, int[] B) {
        int n = A.length;
        if (A.length != B.length) return -1;
        for (int i = 0; i < n; i++) {
            System.out.println("i: " + i);
            Boolean isGasSufficient = true;
            int gas = A[i];
            for (int j = 0; j < n; j++) {
                System.out.println("j: " + j);
                int currentStation = (i + j) % n;
                int nextStation = (currentStation + 1) % n;
                gas = gas - B[currentStation];
                if (gas < 0) {
                    isGasSufficient = false;
                    break;
                }
                gas = gas + B[nextStation];
            }
            if (isGasSufficient) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean travel(int[] a, int[] b, int idx) {
        int currentIdx = idx;
        int gasVol = a[currentIdx];
        while (gasVol > 0) {
            int distance = b[currentIdx];
            System.out.println("gas: " + gasVol + ", distance: " + distance);
            gasVol = gasVol - distance;
            if (gasVol < 0) return false;
            currentIdx++;
            System.out.println("next idx: " + currentIdx + ", idx: " + idx);
            if (currentIdx >= a.length) {
                currentIdx = (currentIdx - a.length);
            }
            if (currentIdx == idx) return true;
            gasVol += b[currentIdx];
            System.out.println("new Gas vol: " + gasVol);
        }
        return true;
    }
    public static void main(String args[]) {
//        int[] a = {1, 2};
//        int[] b = {2, 1};
//        int[] a = {959,329,987,951,942,410,282,376,581,507,546,299,564,114,474,163,953,481,337,395,679,21,335,846,878,961,663,413,610,937,32,831,239,899,659,718,738,7,209};
//        int[] b = {862,783,134,441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884};
        int[] a = {1,2,3,4,5};
        int[] b = {3,4,5,1,2};
        System.out.println("final: " + traverseGasStation(a, b));
    }
}
