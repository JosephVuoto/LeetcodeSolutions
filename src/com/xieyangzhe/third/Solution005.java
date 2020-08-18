package com.xieyangzhe.third;

/**
 * @author Yangzhe Xie
 * @date 18/8/20
 */
public class Solution005 {
    //5. Longest Palindromic Substring
    //Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
    //
    //Example 1:
    //
    //Input: "babad"
    //Output: "bab"
    //Note: "aba" is also a valid answer.
    //Example 2:
    //
    //Input: "cbbd"
    //Output: "bb"
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0, start = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (j - i < 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution005().longestPalindrome("cbbd"));
    }
}
