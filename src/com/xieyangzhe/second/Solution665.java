package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 12/5/20
 */
public class Solution665 {
    //665. Non-decreasing Array
    //Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
    //
    //We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [4,2,3]
    //Output: true
    //Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
    //Example 2:
    //
    //Input: nums = [4,2,1]
    //Output: false
    //Explanation: You can't get a non-decreasing array by modify at most one element.
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                } else  {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count < 2;
    }
}
