package com.xieyangzhe.second;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 28/3/20
 */
public class Solution139 {
    //139. Word Break
    //Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    //
    //Note:
    //
    //The same word in the dictionary may be reused multiple times in the segmentation.
    //You may assume the dictionary does not contain duplicate words.
    //Example 1:
    //
    //Input: s = "leetcode", wordDict = ["leet", "code"]
    //Output: true
    //Explanation: Return true because "leetcode" can be segmented as "leet code".
    //Example 2:
    //
    //Input: s = "applepenapple", wordDict = ["apple", "pen"]
    //Output: true
    //Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    //             Note that you are allowed to reuse a dictionary word.
    //Example 3:
    //
    //Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    //Output: false
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i, j)) && (i == 0 || dp[i - 1])) {
                    dp[j - 1] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
