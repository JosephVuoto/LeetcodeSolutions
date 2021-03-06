package com.xieyangzhe.first.s100;

/**
 * @author Yangzhe Xie
 * @date 11/12/19
 */
public class Solution091 {
    public static void main(String[] args) {
        System.out.println(new Solution091().numDecodings("226"));
    }

    //91. Decode Ways
    //A message containing letters from A-Z is being encoded to numbers using the following mapping:
    //
    //'A' -> 1
    //'B' -> 2
    //...
    //'Z' -> 26
    //Given a non-empty string containing only digits, determine the total number of ways to decode it.
    //
    //Example 1:
    //
    //Input: "12"
    //Output: 2
    //Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    //Example 2:
    //
    //Input: "226"
    //Output: 3
    //Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                int tmpNum = Integer.parseInt(s.substring(i, i + 2));
                dp[i] = dp[i] + tmpNum < 27 && tmpNum > 9 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }
}
