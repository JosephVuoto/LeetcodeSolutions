package com.xieyangzhe.com.first.s600;

/**
 * @author Yangzhe Xie
 * @date 15/1/20
 */
public class Solution518 {
    //518. Coin Change 2
    //You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
    //
    //Example 1:
    //
    //Input: amount = 5, coins = [1, 2, 5]
    //Output: 4
    //Explanation: there are four ways to make up the amount:
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    //Example 2:
    //
    //Input: amount = 3, coins = [2]
    //Output: 0
    //Explanation: the amount of 3 cannot be made up just with coins of 2.
    //Example 3:
    //
    //Input: amount = 10, coins = [10]
    //Output: 1
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return amount == 0? 1: 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
