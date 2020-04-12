package com.xieyangzhe.second;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 12/4/20
 */
public class Solution377 {
    //377. Combination Sum IV
    //Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
    //
    //Example:
    //
    //nums = [1, 2, 3]
    //target = 4
    //
    //The possible combination ways are:
    //(1, 1, 1, 1)
    //(1, 1, 2)
    //(1, 2, 1)
    //(1, 3)
    //(2, 1, 1)
    //(2, 2)
    //(3, 1)
    //
    //Note that different sequences are counted as different combinations.
    //
    //Therefore the output is 7.
    private int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int result = 0;
        for (int num: nums) {
            result += dfs(nums, target - num);
        }
        dp[target] = result;
        return result;
    }
}
