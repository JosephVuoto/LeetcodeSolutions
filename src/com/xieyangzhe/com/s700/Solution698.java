package com.xieyangzhe.com.s700;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 31/1/20
 */
public class Solution698 {
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
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, 0, 0, sum, visited);
    }

    private boolean dfs(int[] nums, int k, int start, int tmp, int sum, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (tmp == sum) {
            return dfs(nums, k - 1, 0, 0, sum, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (dfs(nums, k, i + 1, tmp + nums[i], sum, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / k;
        if (target * k != sum) {
            return false;
        }
        int[] subset = new int[k];
        Arrays.sort(nums);
        return helper(nums, k, nums.length - 1, subset, target);
    }

    private boolean helper(int[] nums, int k, int start, int[] subset, int target) {
        if (start < 0) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (i > 0 && subset[i - 1] == 0) {
                return false;
            }
            if (subset[i] + nums[start] <= target) {
                subset[i] += nums[start];
                if (helper(nums, k, start - 1, subset, target)) {
                    return true;
                }
                subset[i] -= nums[start];
            }
        }
        return false;
    }
}
