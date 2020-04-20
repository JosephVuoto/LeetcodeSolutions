package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
public class Solution459 {
    //459. Repeated Substring Pattern
    //Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
    //
    //
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
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                StringBuilder sb = new StringBuilder();
                String tmp = s.substring(0, i);
                for (int j = 0; j < s.length() / i; j++) {
                    sb.append(tmp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
