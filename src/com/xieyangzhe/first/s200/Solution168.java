package com.xieyangzhe.first.s200;

/**
 * @author Yangzhe Xie
 * @date 23/12/19
 */
public class Solution168 {
    //168. Excel Sheet Column Title
    //Given a positive integer, return its corresponding column title as appear in an Excel sheet.
    //
    //For example:
    //
    //    1 -> A
    //    2 -> B
    //    3 -> C
    //    ...
    //    26 -> Z
    //    27 -> AA
    //    28 -> AB
    //    ...
    //Example 1:
    //
    //Input: 1
    //Output: "A"
    //Example 2:
    //
    //Input: 28
    //Output: "AB"
    //Example 3:
    //
    //Input: 701
    //Output: "ZY"
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}
