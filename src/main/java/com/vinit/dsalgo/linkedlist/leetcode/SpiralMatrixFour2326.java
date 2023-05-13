package com.vinit.dsalgo.linkedlist.leetcode;

import java.util.Arrays;

public class SpiralMatrixFour2326 {

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        int rowLength = m;
        int colLength = n;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;
        int insertNum = 1;
        // As we would be completing one round of the matrix in single loop,
        // hence divided the total by 4.
        // we would need to iterate only that no of times how much it takes from start to
        // the middle of the matrix hence we divided the num of elements in the
        // matrix by 2 and then by 4 to minimise the iterations
        for (int i = 0; i < (((rowLength * colLength) / 2) / 4) + 1; i++) {
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colStart; col <= colEnd; col++) {
                matrix[rowStart][col] = head != null ? head.val : -1;
                head = head != null ? head.next : null;
//                data.add(array[rowStart][col]);
            }
            // completed one top row and hence removed from the cal
            rowStart++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowStart; row <= rowEnd; row++) {
//                data.add(array[row][colEnd]);
                matrix[row][colEnd] = head != null ? head.val : -1;
                head = head != null ? head.next : null;
            }
            // completed last col and hence removed from the cal
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colEnd; col >= colStart; col--) {
//                data.add(array[rowEnd][col]);
                matrix[rowEnd][col] = head != null ? head.val : -1;
                head = head != null ? head.next : null;
            }
            // completed last row and hence removed from the cal
            rowEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowEnd; row >= rowStart; row--) {
//                data.add(array[row][colStart]);
                matrix[row][colStart] = head != null ? head.val : -1;
                head = head != null ? head.next : null;
            }
            // completed first col and hence removed from the cal
            colStart++;
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix;
    }

    public static ListNode constructLL(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for (int i : arr) {
            ListNode l = new ListNode(i);
            t.next = l;
            t = l;
        }
        return dummy.next;
    }

    public static void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null ");
    }
    public static void main(String[] args) {
        int[] n = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode l = constructLL(n);
        System.out.println(spiralMatrix(3, 5, l));
    }
}
