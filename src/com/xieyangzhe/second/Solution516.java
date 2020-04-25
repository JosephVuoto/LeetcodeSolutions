package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 25/4/20
 */
public class Solution516 {
    //516. Longest Palindromic Subsequence
    //Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
    //
    //Example 1:
    //Input:
    //
    //"bbbab"
    //Output:
    //4
    //One possible longest palindromic subsequence is "bbbb".
    //Example 2:
    //Input:
    //
    //"cbbd"
    //Output:
    //2
    //One possible longest palindromic subsequence is "bb".

    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    private int dfs(String s, int left, int right, Integer[][] memo) {
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        if (s.charAt(left) == s.charAt(right)) {
            memo[left][right] = dfs(s, left + 1, right - 1, memo) + 2;
        } else {
            memo[left][right] = Math.max(dfs(s, left + 1, right ,memo), dfs(s, left, right - 1, memo));
        }
        return memo[left][right];
    }


    public int longestPalindromeSubseq1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution516().longestPalindromeSubseq("cbbd"));
    }
}
