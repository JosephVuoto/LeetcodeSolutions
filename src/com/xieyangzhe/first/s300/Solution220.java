package com.xieyangzhe.first.s300;

import java.util.TreeSet;

/**
 * @author Yangzhe Xie
 * @date 30/12/19
 */
public class Solution220 {
    //220. Contains Duplicate III
    //Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
    //
    //Example 1:
    //
    //Input: nums = [1,2,3,1], k = 3, t = 0
    //Output: true
    //Example 2:
    //
    //Input: nums = [1,0,1,1], k = 1, t = 2
    //Output: true
    //Example 3:
    //
    //Input: nums = [1,5,9,1,5,9], k = 2, t = 3
    //Output: false
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k < 0 || t < 0)
            return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) {
                set.remove(nums[i - k - 1]);
            }
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
