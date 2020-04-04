package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 4/4/20
 */
public class Solution238 {
    //238. Product of Array Except Self
    //Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    //
    //Example:
    //
    //Input:  [1,2,3,4]
    //Output: [24,12,8,6]
    //Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
    //
    //Note: Please solve it without division and in O(n).
    //
    //Follow up:
    //Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
