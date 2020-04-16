package com.xieyangzhe.second;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 16/4/20
 */
public class Solution416 {
    //416. Partition Equal Subset Sum
    //Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
    //
    //Note:
    //
    //Each of the array element will not exceed 100.
    //The array size will not exceed 200.
    // 
    //
    //Example 1:
    //
    //Input: [1, 5, 11, 5]
    //
    //Output: true
    //
    //Explanation: The array can be partitioned as [1, 5, 5] and [11].
    // 
    //
    //Example 2:
    //
    //Input: [1, 2, 3, 5]
    //
    //Output: false
    //
    //Explanation: The array cannot be partitioned into equal sum subsets.
    public boolean canPartition1(int[] nums) {
        int target = 0;
        for (int num: nums) {
            target += num;
        }
        if ((target & 1) == 1) {
            return false;
        }
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        Arrays.sort(nums);
        return dfs(nums, nums.length - 1, sum);
    }
    private boolean dfs(int[] nums, int index, int target) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        for (int i = index; i >= 0; i--) {
            if (dfs(nums, i - 1, target - nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution416().canPartition(new int[]{23,13,11,7,6,5,5}));
    }
}
