package com.vinit.dsalgo.linkedlist.leetcode;

class PolyNode {
      int coefficient, power;
      PolyNode next = null;

      PolyNode() {}
      PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
      PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
  }
public class AddTwoPolynomialLL1634 {


    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(-1, -1);
        PolyNode current = dummy;
        PolyNode current1 = poly1;
        PolyNode current2 = poly2;
        while(current1 != null && current2 != null){
            if(current1.power > current2.power){
                current.next = current1;
                current1 = current1.next;
                current = current.next;
            }
            else if(current1.power < current2.power){
                current.next = current2;
                current2 = current2.next;
                current = current.next;
            }
            else{
                int nextCoefficient = current1.coefficient + current2.coefficient;
                int nextPower = current1.power;
                if(nextCoefficient != 0){
                    current.next = new PolyNode(nextCoefficient, nextPower);
                    current = current.next;
                }
                current1 = current1.next;
                current2 = current2.next;
                current.next = null;
            }
        }
        while(current1 != null){
            current.next = current1;
            current1 = current1.next;
            current = current.next;
        }
        while(current2 != null){
            current.next = current2;
            current2 = current2.next;
            current = current.next;
        }
        return dummy.next;
    }
}
