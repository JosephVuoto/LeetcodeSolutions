package com.xieyangzhe.com.s700;

/**
 * @author Yangzhe Xie
 * @date 22/1/20
 */
public class Solution680 {
    //680. Valid Palindrome II
    //Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
    //
    //Example 1:
    //Input: "aba"
    //Output: True
    //Example 2:
    //Input: "abca"
    //Output: True
    //Explanation: You could delete the character 'c'.
    //Note:
    //The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return helper(s, left + 1, right) || helper(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution680().validPalindrome("abc"));
    }
}
