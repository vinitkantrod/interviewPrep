package com.vinit.dsalgo.design.leetcode;

import java.util.HashMap;
import java.util.Map;

class Codec {
    Map<String, String> shortToLongMap;
    Map<String, String> longToShortMap;

    char[] charArr;

    public Codec() {
        shortToLongMap = new HashMap<>();
        shortToLongMap.put("", "");
        longToShortMap = new HashMap<>();
        longToShortMap.put("", "");
        charArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        StringBuilder sb = new StringBuilder();
        sb.append("");
        while (shortToLongMap.containsKey(sb.toString())) {
            sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(charArr[(int) Math.floor(Math.random() * charArr.length)]);
            }
        }
        shortToLongMap.put(sb.toString(), longUrl);
        longToShortMap.put(longUrl, sb.toString());
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.containsKey(shortUrl) ? shortToLongMap.get(shortUrl) : "";
    }

}
public class DesignTinyUrl {
}
