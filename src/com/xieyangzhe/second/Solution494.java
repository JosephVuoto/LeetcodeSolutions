package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 23/4/20
 */
public class Solution494 {
    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    //494. Target Sum
    //You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
    //
    //Find out how many ways to assign symbols to make sum of integers equal to target S.
    //
    //Example 1:
    //Input: nums is [1, 1, 1, 1, 1], S is 3.
    //Output: 5
    //Explanation:
    //
    //-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3
    //
    //There are 5 ways to assign symbols to make the sum of nums be target 3.
    //Note:
    //The length of the given array is positive and will not exceed 20.
    //The sum of elements in the given array will not exceed 1000.
    //Your output answer is guaranteed to be fitted in a 32-bit integer.

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum < S || ((sum + S) & 1) == 1) {
            return 0;
        }
        sum = (S + sum) / 2;
        int [] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }

    public int findTargetSumWays1(int[] nums, int S) {
        return find(nums, S, 0);
    }

    public int find(int[] nums, int target, int from) {
        if (from == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return find(nums, target - nums[from], from + 1) +
                find(nums, target + nums[from], from + 1);
    }
}
