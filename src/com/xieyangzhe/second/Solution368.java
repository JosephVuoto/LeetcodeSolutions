package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/4/20
 */
public class Solution368 {
    //368. Largest Divisible Subset
    //Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
    //
    //Si % Sj = 0 or Sj % Si = 0.
    //
    //If there are multiple solutions, return any subset is fine.
    //
    //Example 1:
    //
    //Input: [1,2,3]
    //Output: [1,2] (of course, [1,3] will also be ok)
    //Example 2:
    //
    //Input: [1,2,4,8]
    //Output: [1,2,4,8]
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int max = 0;
        List<Integer> result = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }
}
