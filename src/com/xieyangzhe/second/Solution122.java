package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 23/6/20
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmpSell = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmpSell - prices[i]);
        }
        return sell;
    }
}
