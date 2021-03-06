package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 17/4/20
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
        int left = 0, right = 0, result = 0;
        while (left < s.length() && right < s.length()) {
            int[] map = new int[26];
            int maxRepeat = 0;
            for (int i = left; i <= right; i++) {
                maxRepeat = Math.max(maxRepeat, ++map[s.charAt(i) - 'A']);
            }
            if (right - left + 1 <= k + maxRepeat) {
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("AABABBA", 1));
    }
}
