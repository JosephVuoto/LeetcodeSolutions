package com.xieyangzhe.com.first.s500;

/**
 * @author Yangzhe Xie
 * @date 11/1/20
 */
public class Solution459 {
    //459. Repeated Substring Pattern
    //Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
    //
    //Example 1:
    //
    //Input: "abab"
    //Output: True
    //Explanation: It's the substring "ab" twice.
    //Example 2:
    //
    //Input: "aba"
    //Output: False
    //Example 3:
    //
    //Input: "abcabcabcabc"
    //Output: True
    //Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = s.substring(0, i + 1);
            if ((s.length() % tmp.length()) != 0) {
                continue;
            }
            int flag = 0;
            for (int j = 0; j <= s.length() - tmp.length(); j = j + tmp.length()) {
                if (!(tmp.equals(s.substring(j, j + tmp.length())))) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return true;
            }
        }
        return false;
    }
}
