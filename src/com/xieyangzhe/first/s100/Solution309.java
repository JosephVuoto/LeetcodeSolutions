package com.xieyangzhe.first.s100;

/**
 * @author Yangzhe Xie
 * @date 8/4/20
 */
//309. Best Time to Buy and Sell Stock with Cooldown
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//Example:
//
//Input: [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i - 1], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1]);
        }
        return sell[prices.length];
    }
}
