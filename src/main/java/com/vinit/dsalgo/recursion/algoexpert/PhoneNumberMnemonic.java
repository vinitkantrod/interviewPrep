package com.vinit.dsalgo.recursion.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberMnemonic {

    public static Map<Character, String[]> DIGITS_LETTER = new HashMap<>();

    static {
        DIGITS_LETTER.put('0', new String[]{"0"});
        DIGITS_LETTER.put('1', new String[]{"1"});
        DIGITS_LETTER.put('2', new String[]{"a", "b", "c"});
        DIGITS_LETTER.put('3', new String[]{"d", "e", "f"});
        DIGITS_LETTER.put('4', new String[]{"g", "h", "i"});
        DIGITS_LETTER.put('5', new String[]{"j", "k", "l"});
        DIGITS_LETTER.put('6', new String[]{"m", "n", "o"});
        DIGITS_LETTER.put('7', new String[]{"p", "q", "r", "s"});
        DIGITS_LETTER.put('8', new String[]{"t", "u", "v"});
        DIGITS_LETTER.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        String[] currentMnemonics = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonics, "0");
        ArrayList<String> mnenomics = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonics, mnenomics);
        return mnenomics;
    }

    public static void phoneNumberMnemonicsHelper(int idx,
                                               String phoneNumber,
                                               String[] currentMnemonics,
                                               ArrayList<String> mnenomics
    ) {
        if (idx == phoneNumber.length()) {
            String curr = String.join("", currentMnemonics);
            mnenomics.add(curr);
            return;
        }
        String[] letters = DIGITS_LETTER.get(phoneNumber.charAt(idx));
        for (String letter : letters) {
            currentMnemonics[idx] = letter;
            phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonics, mnenomics);
        }
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(phoneNumberMnemonics("1905").toArray()));
    }
}
