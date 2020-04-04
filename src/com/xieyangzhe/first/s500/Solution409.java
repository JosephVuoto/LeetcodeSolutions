package com.xieyangzhe.first.s500;

/**
 * @author Yangzhe Xie
 * @date 7/1/20
 */
public class Solution409 {
    //409. Longest Palindrome
    //Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
    //
    //This is case sensitive, for example "Aa" is not considered a palindrome here.
    //
    //Note:
    //Assume the length of given string will not exceed 1,010.
    //
    //Example:
    //
    //Input:
    //"abccccdd"
    //
    //Output:
    //7
    //
    //Explanation:
    //One longest palindrome that can be built is "dccaccd", whose length is 7.
    public int longestPalindrome(String s) {
        int[] note = new int[128];
        int result = 0;
        for (char c : s.toCharArray()) {
            if (++note[c] == 2) {
                result += 2;
                note[c] = 0;
            }
        }
        return result == s.length() ? result : result + 1;
    }
}
