package com.vinit.dsalgo.assessment.facebook;

import java.util.Arrays;

public class FileSystemPath {

    public static String simplifyPath(String path) {
        String[] pathArr = path.trim().split("/");
        System.out.println(Arrays.toString(pathArr));
        return "";
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/path"));
    }
}
