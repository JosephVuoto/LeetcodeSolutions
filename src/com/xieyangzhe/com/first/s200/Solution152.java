package com.xieyangzhe.com.first.s200;

/**
 * @author Yangzhe Xie
 * @date 19/12/19
 */
public class Solution152 {
    //152. Maximum Product Subarray
    //Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
    //
    //Example 1:
    //
    //Input: [2,3,-2,4]
    //Output: 6
    //Explanation: [2,3] has the largest product 6.
    //Example 2:
    //
    //Input: [-2,0,-1]
    //Output: 0
    //Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int k = dpMax * nums[i];
            int m = dpMin * nums[i];
            dpMax = Math.max(nums[i], Math.max(k, m));
            dpMin = Math.min(nums[i], Math.min(k, m));

            max = Math.max(dpMax, max);
        }
        return max;
    }
}
