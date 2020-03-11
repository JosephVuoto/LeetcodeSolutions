package com.xieyangzhe.com.first.s200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 16/12/19
 */
public class Solution131 {
    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }

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
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1) && (len < 3 || dp[i + 1][i + len - 2]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>(), 0, dp);
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> tmp, int start, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(tmp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                tmp.add(s.substring(start, i + 1));
                helper(s, result, new ArrayList<>(tmp), i + 1, dp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
