package com.vinit.dsalgo.strings.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidIpAddress {

    public static ArrayList<String> validIPAddresses(String string) {

        ArrayList<String> ipAddressesFound = new ArrayList<>();
        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] validCurrentIpPart = {"", "", "", ""};
            validCurrentIpPart[0] = string.substring(0, i);
            if (!isValidPart(validCurrentIpPart[0]) ) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min((string.length() - i), 4 ); j++) {
                validCurrentIpPart[1] = string.substring(i, j);
                if (!isValidPart(validCurrentIpPart[1]) ) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min((string.length() - j), 4 ); k++) {
                    validCurrentIpPart[2] = string.substring(j, k);
                    validCurrentIpPart[3] = string.substring(k, string.length());
                    if (isValidPart(validCurrentIpPart[2]) && isValidPart(validCurrentIpPart[3]) ) {
                        ipAddressesFound.add(String.join(".", validCurrentIpPart));
                    }

                }
            }
        }
        return ipAddressesFound;
    }

    public static Boolean isValidPart(String string) {
        Integer stringToInt = Integer.parseInt(string);
        if (stringToInt > 255) return false;

        return string.length() == String.valueOf(stringToInt).length();
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(validIPAddresses("1921680").toArray()));
    }
}
