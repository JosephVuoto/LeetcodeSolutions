package com.xieyangzhe.com.first.s500;

/**
 * @author Yangzhe Xie
 * @date 19/12/19
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
    public boolean canPartition(int[] nums) {
        int sum = 0, target;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution416().canPartition(new int[]{1, 5, 11, 5}));
    }
}
