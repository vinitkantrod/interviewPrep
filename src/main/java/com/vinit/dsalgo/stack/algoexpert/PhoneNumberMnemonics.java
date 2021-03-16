package com.vinit.dsalgo.stack.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberMnemonics {

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, String[]> mapping = new HashMap<>();
        mapping.put('0', new String[]{"0"});
        mapping.put('1', new String[]{"1"});
        mapping.put('2', new String[]{"a", "b", "c"});
        mapping.put('3', new String[]{"d", "e", "f"});
        mapping.put('4', new String[]{"g", "h", "i"});
        mapping.put('5', new String[]{"j", "k", "l"});
        mapping.put('6', new String[]{"m", "n", "o"});
        mapping.put('7', new String[]{"p", "q", "r", "s"});
        mapping.put('8', new String[]{"t", "u", "v"});
        mapping.put('9', new String[]{"w", "x", "y", "z"});

        return new ArrayList<String>();
    }

    public static void main(String args[]) {
        phoneNumberMnemonics("1905");
    }
}
