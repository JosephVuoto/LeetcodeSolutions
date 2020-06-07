package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 7/6/20
 */
//698. Partition to K Equal Sum Subsets
//Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
//
//
//
//Example 1:
//
//Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//Output: True
//Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//
//
//Note:
//
//1 <= k <= len(nums) <= 16.
//0 < nums[i] < 10000.
public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target  = 0;
        for (int num: nums) {
            target += num;
        }
        if (target % k != 0) {
            return false;
        }
        target /= k;
        return dfs(nums, target, 0, new boolean[nums.length], k, 0);
    }

    private boolean dfs(int[] nums, int target, int start, boolean[] used, int kLeft, int tmp) {
        if (kLeft == 1) {
            return true;
        }
        if (tmp == target) {
            return dfs(nums, target, 0, used, kLeft - 1, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (dfs(nums, target, i + 1, used, kLeft, tmp + nums[i])) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
