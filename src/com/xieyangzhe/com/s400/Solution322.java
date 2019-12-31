package com.xieyangzhe.com.s400;

/**
 * @author Yangzhe Xie
 * @date 25/12/19
 */
public class Solution322 {
    public static void main(String[] args) {
        System.out.println(new Solution322().coinChange(new int[]{1, 2, 5}, 11));
    }

    //322. Coin Change
    //You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    //
    //Example 1:
    //
    //Input: coins = [1, 2, 5], amount = 11
    //Output: 3
    //Explanation: 11 = 5 + 5 + 1
    //Example 2:
    //
    //Input: coins = [2], amount = 3
    //Output: -1
    //Note:
    //You may assume that you have an infinite number of each kind of coin.
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    int temp = dp[i - coin] + 1;
                    min = min < 0 ? temp : (Math.min(temp, min));
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
