package com.xieyangzhe.com.s100;

public class Solution081 {
    //81. Search in Rotated Sorted Array II
    //Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    //
    //(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
    //
    //You are given a target value to search. If found in the array return true, otherwise return false.
    //
    //Example 1:
    //
    //Input: nums = [2,5,6,0,0,1,2], target = 0
    //Output: true
    //Example 2:
    //
    //Input: nums = [2,5,6,0,0,1,2], target = 3
    //Output: false
    //Follow up:
    //
    //This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    //Would this affect the run-time complexity? How and why?
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }
}
