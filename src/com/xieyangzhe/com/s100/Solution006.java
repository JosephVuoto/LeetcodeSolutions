package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.List;

public class Solution006 {
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
//    like this: (you may want to display this pattern in a fixed font for better legibility)
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    And then read line by line: "PAHNAPLSIIGYIR"

//    Input: s = "PAYPALISHIRING", numRows = 4
//    Output: "PINALSIGYAHRPI"
//    Explanation:
//
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I


    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int cur = 0;
        int direction = 1; // 1 - down; -1 - up
        for (char c : s.toCharArray()) {
            rows.get(cur).append(c);
            cur += direction;
            if (cur == 0 || cur == numRows - 1) {
                direction = -direction;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
