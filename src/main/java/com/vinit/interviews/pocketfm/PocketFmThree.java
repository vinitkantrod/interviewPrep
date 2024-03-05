package com.vinit.interviews.pocketfm;

public class PocketFmThree {

    static class LL {
        int data;
        LL next;
        public LL(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void sutractLinkedList(LL listOne, LL listTwo) {
        // Reverse the list
        // 100 - 75 = 001 - 57 = 25
        // 75 - 100 = 57 - 001 = -25
        // 987 - 20 = 789 - 02 = 967
        // 000 - 10 = 000 - 01 = 10
        // 55 - 555 = 55 - 555 = -500
        // 0001 - 985 = 1000 - 589 = 014
        Boolean isSmaller = false;
        LL l1 = reverseLL(listOne);
        LL l2 = reverseLL(listTwo);
        Boolean isNegative = false;
        printLL(l1, isNegative);
        printLL(l2, isNegative);
        // Subtract LL
        int borrower = 0;
        LL curr1 = l1, curr2 = l2;
        LL dummy = new LL(-1);
        LL nextResult = dummy;
        while (curr1 != null && curr2 != null) {
            if (borrower > 0) {
                int val = curr1.data - 1;
                if (val < 0) val = 10 - borrower;
                curr1.data = val;
            }
            int value = curr1.data - curr2.data;
            if (value < 0) {
                borrower = 1;
                value = Math.abs(value);
            }
            System.out.println("val: " + value);
            nextResult.next = new LL(value);
            nextResult = nextResult.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        System.out.println("borrower: " + borrower + ", isNegative: " + isNegative);
        while (curr1 != null) {
            if (borrower > 0) {
                int val = curr1.data - 1;
                if (val < 0) {
                    // Return the second LL as it is
                    isNegative = true;
////                    printLL(listTwo, true);
//                    return;
                } else {
                    nextResult.next = new LL(val);
                }
            } else {
                nextResult.next = new LL(curr1.data);
            }
            curr1 = curr1.next;
            nextResult = nextResult.next;
        }
        while (curr2 != null) {
            nextResult.next = new LL(curr2.data);
            curr2 = curr2.next;
            nextResult = nextResult.next;
            isNegative = true;
        }

//        printLL(dummy.next);
        LL res = reverseLL(dummy.next);
        printLL(res, isNegative);
    }
    private static LL reverseLL(LL list) {
        LL prev = null;
        LL current = list;
        LL next =null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    private static void printLL(LL list, boolean isNegative) {
        if (isNegative) System.out.print("-");
        LL  current = list;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        LL one = new LL(1);
//        one.next = new LL(0);
//        one.next.next = new LL(0);
//        LL two = new LL(7);
//        two.next = new LL(5);
//
//        LL one = new LL(9);
//        one.next = new LL(8);
//        one.next.next = new LL(7);
//        LL two = new LL(2);
//        two.next = new LL(0);

//        LL one = new LL(0);
//        one.next = new LL(0);
//        one.next.next = new LL(0);
//        LL two = new LL(2);
//        two.next = new LL(0);
//
//        LL one = new LL(5);
//        one.next = new LL(5);
//        LL two = new LL(5);
//        two.next = new LL(5);
//        two.next.next = new LL(5);

        LL one = new LL(0);
        one.next = new LL(0);
        one.next.next = new LL(0);
        one.next.next.next = new LL(1);
        LL two = new LL(9);
        two.next = new LL(8);
        two.next.next = new LL(5);
        sutractLinkedList(one, two);
    }
}
