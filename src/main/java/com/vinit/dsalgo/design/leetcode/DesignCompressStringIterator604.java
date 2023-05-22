package com.vinit.dsalgo.design.leetcode;

class StringIterator {
//    StringBuilder res=new StringBuilder();
//    int ptr=0;
//    public StringIterator(String compressedString) {
//        int i = 0;
//        while (i < compressedString.length()) {
//            char ch = compressedString.charAt(i++);
//            int num = 0;
//            while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
//                num = num * 10 + compressedString.charAt(i) - '0';
//                i++;
//            }
//            for (int j = 0; j < num; j++)
//                res.append(ch);
//        }
//    }
//
//    public char next() {
//        if (!hasNext())
//            return ' ';
//        return res.charAt(ptr++);
//    }
//
//    public boolean hasNext() {
//        return ptr!=res.length();
//    }

    int count = 0;
    char ch;
    int index = 0;
    char[] s;

    public StringIterator(String compressedString) {
        this.s = compressedString.toCharArray();
    }

    public char next() {
        if (count == 0 && index < s.length) {
            ch = s[index++];

            count = 0;
            while( index < s.length && s[index] >= 48 && s[index] <= 57) {
                count = count * 10 + (s[index] - 48);
                index++;
            }
        }

        char c = ' ';
        if (count > 0) {
            c = ch;
            count--;
        }

        return c;
    }

    public boolean hasNext() {
        return count > 0 || index < s.length;
    }
}
public class DesignCompressStringIterator604 {

    public static void main(String[] args) {
        String compressedString = "L1e2t1C1o1d1e1";
        StringIterator obj = new StringIterator(compressedString);
        char param_1 = obj.next();
        char param_2 = obj.next();
        char param_3 = obj.next();
        char param_4 = obj.next();
        boolean param_5 = obj.hasNext();
    }
}
