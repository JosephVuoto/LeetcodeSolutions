package com.xieyangzhe.com.first.s400;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 5/1/20
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
    //
    //
    //Follow up:
    //What if negative numbers are allowed in the given array?
    //How does it change the problem?
    //What limitation we need to add to the question to allow negative numbers?
    //
    //Credits:
    //Special thanks to @pbrother for adding this problem and creating all test cases.
    int[] dp1;
    public int combinationSum4(int[] nums, int target) {
        dp1 = new int[target + 1];
        Arrays.fill(dp1, -1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (dp1[target] != -1) {
            return dp1[target];
        }
        if (target == 0) {
            return 1;
        }
        int result = 0;
        for (int num : nums) {
            result += dfs(nums, target - num);
        }
        dp1[target] = result;
        return result;
    }

    public int combinationSum4_1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution377().combinationSum4_1(new int[] {4, 2, 1}, 32));
    }
}
