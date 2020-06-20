package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 20/6/20
 */
public class Solution131 {
    //131. Palindrome Partitioning
    //Given a string s, partition s such that every substring of the partition is a palindrome.
    //
    //Return all possible palindrome partitioning of s.
    //
    //Example:
    //
    //Input: "aab"
    //Output:
    //[
    //  ["aa","b"],
    //  ["a","a","b"]
    //]
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                dp[i][i + length - 1] = s.charAt(i) == s.charAt(i + length - 1) &&
                        (length < 3 || dp[i + 1][i + length - 2]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, dp, result, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int start, boolean[][] dp, List<List<String>> result, List<String> tmp) {
        if (start >= s.length()) {
            result.add(tmp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                tmp.add(s.substring(start, i + 1));
                dfs(s, i + 1, dp, result, new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution131().longestPalindrome("aaba"));
    }
}
