package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 27/4/20
 */
public class Solution540 {
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
