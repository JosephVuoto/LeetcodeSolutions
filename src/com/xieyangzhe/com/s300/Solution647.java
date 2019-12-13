package com.xieyangzhe.com.s300;

/**
 * @author Yangzhe Xie
 * @date 13/12/19
 */
public class Solution647 {
    //647. Palindromic Substrings
    //Given a string, your task is to count how many palindromic substrings in this string.
    //
    //The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
    //
    //Example 1:
    //
    //Input: "abc"
    //Output: 3
    //Explanation: Three palindromic strings: "a", "b", "c".
    //
    //
    //Example 2:
    //
    //Input: "aaa"
    //Output: 6
    //Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    //
    //
    //Note:
    //
    //The input string length won't exceed 1000.
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = new char[s.length() * 2 - 1];
        chars[0] = s.charAt(0);
        int tag = 1;

        for (int i = 1; i < s.length(); i++) {
            chars[tag++] = ' ';
            chars[tag++] = s.charAt(i);
        }

        int result = s.length();
        for (int i = 1; i < chars.length - 1; i++) {
            int m = i - 1, n = i + 1;
            while (m >= 0 && n < chars.length) {
                if (chars[m] == chars[n]) {
                    if (chars[m] != ' ') {
                        result++;
                    }
                    m--;
                    n++;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    private int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution647().dp("aaa"));
    }
}
