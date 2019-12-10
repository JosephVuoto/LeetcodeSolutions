package com.xieyangzhe.com.s100;

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

//    4,5,6,7,8,1,2,3
}