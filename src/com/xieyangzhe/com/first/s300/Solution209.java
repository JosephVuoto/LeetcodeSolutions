package com.xieyangzhe.com.first.s300;

/**
 * @author Yangzhe Xie
 * @date 28/12/19
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}