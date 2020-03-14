package com.xieyangzhe.com.second;

/**
 * @author Yangzhe Xie
 * @date 14/3/20
 */
//33. Search in Rotated Sorted Array
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
public class Solution033 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution033().search(new int[] {4,5,6,7,0,1,2}, 0));
    }
}
