package com.vinit.dsalgo.strings.leetcode;

public class ReverseStringTwo541 {

    public static String reverseStr(String s, int k) {
//        if (s.length() == 1) return s;
//        int left = 0;
//        StringBuffer sb = new StringBuffer(s);
//        while (left < s.length()) {
//            int right = left + k - 1;
//            int newLeft = right + k;
////            System.out.println(left + " : " + right + " : " + newLeft);
//            while (left < right) {
//                if (right >= s.length()) right = s.length() - 1;
//                char temp = s.charAt(left);
//                sb.setCharAt(left, s.charAt(right));
//                sb.setCharAt(right, temp);
//                left++;
//                right--;
//            }
//            left = newLeft + 1;
////            System.out.println(sb.toString());
//        }
//        return sb.toString();

        // LC sol
        char[] str = s.toCharArray();
        int n = str.length;
        for(int i = 0 ; i <= n-1; i += 2*k){
            if(i+k-1 <= n-1){
                reverseK(i,i+k-1,str);
            }else{
                //for fewer than k characters left (edge case)
                reverseK(i,n-1,str);
            }
        }
        String ans = new String(str);
        return ans;
    }

    public static void reverseK(int i, int j, char[] str){
        while(i < j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        String s = "abcdefg";
//        String s = "abcdef";
        System.out.println(reverseStr(s, 2));
    }
}
