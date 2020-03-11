package com.xieyangzhe.com.first.s300;

/**
 * @author Yangzhe Xie
 * @date 27/12/19
 */
public class Solution283 {
    //283. Move Zeroes
    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //
    //Example:
    //
    //Input: [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Note:
    //
    //You must do this in-place without making a copy of the array.
    //Minimize the total number of operations.
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, lastNonZeroIndex);
                lastNonZeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
