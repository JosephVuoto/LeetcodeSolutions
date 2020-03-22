package com.xieyangzhe.com.second;

/**
 * @author Yangzhe Xie
 * @date 22/3/20
 */
public class Solution096 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution096().numTrees(3));
    }
}
