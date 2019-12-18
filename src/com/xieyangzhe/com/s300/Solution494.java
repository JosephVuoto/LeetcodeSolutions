package com.xieyangzhe.com.s300;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 18/12/19
 */
public class Solution494 {
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
    private int result = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0);
        return result;
    }
    
    private void dfs(int[] nums, int target, int start) {
        if (start >= nums.length) {
            return;
        }
        if (start == nums.length - 1) {
            if (nums[start] == target) {
                result++;
            }
            if (nums[start] == 0 - target) {
                result++;
            }
            return;
        }
        dfs(nums, target - nums[start], start + 1);
        dfs(nums, target + nums[start], start + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
