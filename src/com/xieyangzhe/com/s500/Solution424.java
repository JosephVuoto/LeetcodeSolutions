package com.xieyangzhe.com.s500;

/**
 * @author Yangzhe Xie
 * @date 8/1/20
 */
public class Solution424 {
    //424. Longest Repeating Character Replacement
    //Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
    //
    //In one operation, you can choose any character of the string and change it to any other uppercase English character.
    //
    //Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
    //
    //Note:
    //Both the string's length and k will not exceed 104.
    //
    //Example 1:
    //
    //Input:
    //s = "ABAB", k = 2
    //
    //Output:
    //4
    //
    //Explanation:
    //Replace the two 'A's with two 'B's or vice versa.
    //
    //
    //Example 2:
    //
    //Input:
    //s = "AABABBA", k = 1
    //
    //Output:
    //4
    //
    //Explanation:
    //Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    //The substring "BBBB" has the longest repeating letters, which is 4.
    public int characterReplacement(String s, int k) {
        int i = 0, j = 1, result = 0, maxTmp = 0;
        while (i <= s.length() && j <= s.length()) {
            int[] note = new int[26];
            for (int m = i; m < j; m++) {
                maxTmp = Math.max(++note[s.charAt(m) - 'A'], maxTmp);
            }
            if (j - i - maxTmp <= k) {
                result = Math.max(j - i, result);
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("ABAB", 2));
    }
}
