package com.xieyangzhe.second;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 10/3/20
 */
public class Solution003 {
    //    3. Longest Substring Without Repeating Characters
//    Given a string, find the length of the longest substring without repeating characters.
//
//    Example 1:
//
//    Input: "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//    Example 2:
//
//    Input: "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                result = Math.max(result, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring("abcabcbb"));
    }
}
