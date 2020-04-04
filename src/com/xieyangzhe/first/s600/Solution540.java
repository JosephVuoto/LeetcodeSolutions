package com.xieyangzhe.first.s600;

/**
 * @author Yangzhe Xie
 * @date 16/1/20
 */
public class Solution540 {
    //540. Single Element in a Sorted Array
    //You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
    //
    //
    //
    //Example 1:
    //
    //Input: [1,1,2,3,3,4,4,8,8]
    //Output: 2
    //Example 2:
    //
    //Input: [3,3,7,7,10,11,11]
    //Output: 10
    //
    //
    //Note: Your solution should run in O(log n) time and O(1) space.
    public int singleNonDuplicate(int[] nums) {
        int high = nums.length - 1, low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid & 1) == 0) {
                mid--;
            }
            if (nums[mid] == nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
