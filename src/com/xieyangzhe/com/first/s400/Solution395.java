package com.xieyangzhe.com.first.s400;

/**
 * @author Yangzhe Xie
 * @date 6/1/20
 */
public class Solution395 {
    //395. Longest Substring with At Least K Repeating Characters
    //Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
    //
    //Example 1:
    //
    //Input:
    //s = "aaabb", k = 3
    //
    //Output:
    //3
    //
    //The longest substring is "aaa", as 'a' is repeated 3 times.
    //Example 2:
    //
    //Input:
    //s = "ababbc", k = 2
    //
    //Output:
    //5
    //
    //The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

    /**
     * TLE
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring1(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int[] note = new int[26];
                for (int m = i; m < j; m++) {
                    note[s.charAt(m) - 'a']++;
                }
                boolean flag = true;
                for (int a: note) {
                    if (a > 0 && a < k) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        if (k <= 1) {
            return s.length();
        }
        int[] note = new int[26];
        for (int i = 0; i < s.length(); i++) {
            note[s.charAt(i) - 'a']++;
        }
        int pivot = 0;
        while (pivot < s.length() && note[s.charAt(pivot) - 'a'] >= k) {
            pivot++;
        }
        if (pivot == s.length()) {
            return s.length();
        }
        int left = longestSubstring(s.substring(0, pivot), k);
        while (pivot < s.length() && note[s.charAt(pivot) - 'a'] < k) {
            pivot++;
        }
        int right = pivot == note.length ? 0 : longestSubstring(s.substring(pivot), k);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution395().longestSubstring("bbaaacbd", 3));
    }
}
