package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 14/4/20
 */
public class Solution395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        return helper(s, k, 0, s.length() - 1);
    }

    private int helper(String s, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] counter = new int[26];
        for (int i = start; i <= end; i++) {
            counter[s.charAt(i) - 'a']++;
        }
        while (end - start + 1 >= k && counter[s.charAt(start) - 'a'] < k) {
            start++;
        }
        while (end - start + 1 >= k && counter[s.charAt(end) - 'a'] < k) {
            end--;
        }
        if (end - start + 1 < k) {
            return 0;
        }
        for (int i = start; i <= end; i++) {
            if (counter[s.charAt(i) - 'a'] < k) {
                return Math.max(helper(s, k, start, i - 1), helper(s, k, i + 1, end));
            }
        }
        return end - start + 1;
    }
}
