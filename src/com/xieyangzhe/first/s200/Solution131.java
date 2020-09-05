package com.xieyangzhe.first.s200;

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
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> tmp, int start) {
        if (start >= s.length()) {
//            result.add(tmp);
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                tmp.add(s.substring(start, i + 1));
                helper(s, result, tmp, i + 1);
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
