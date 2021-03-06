package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 31/3/20
 */
public class Solution209 {
    //209. Minimum Size Subarray Sum
    //Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
    //
    //Example:
    //
    //Input: s = 7, nums = [2,3,1,2,4,3]
    //Output: 2
    //Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    //Follow up:
    //If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curSum = 0, left = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= s) {
                result = Math.min(i - left + 1, result);
                curSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
