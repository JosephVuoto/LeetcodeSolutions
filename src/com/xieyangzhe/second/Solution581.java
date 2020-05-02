package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 2/5/20
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int left = 0, right = nums.length - 1; left < nums.length; left++, right--) {
            if (nums[left] >= max) {
                max = nums[left];
            } else {
                i = left;
            }
            if (nums[right] <= min) {
                min = nums[right];
            } else {
                j = right;
            }
        }
        return i - j + 1;
    }
}
