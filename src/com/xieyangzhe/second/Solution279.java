package com.xieyangzhe.second;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 7/4/20
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i + j * j <= n) {
                    dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(13));
    }
}
