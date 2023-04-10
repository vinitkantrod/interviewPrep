package com.vinit.dsalgo.arrays.leetcode;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder row = new StringBuilder();
        while (columnNumber > 0)
        {
            columnNumber--;
            row.insert(0,(char)('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return row.toString();
    }

}
