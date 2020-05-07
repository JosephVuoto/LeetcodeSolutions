package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 7/5/20
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
    private int result = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            expandFromCenter(s, i, i);
            expandFromCenter(s, i, i + 1);
        }
        return result + 1;
    }

    private void expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution647().countSubstrings("abc"));
    }
}
