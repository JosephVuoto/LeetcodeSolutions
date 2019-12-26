package com.xieyangzhe.com.s300;

/**
 * @author Yangzhe Xie
 * @date 26/12/19
 */
public class Solution238 {
    //238. Product of Array Except Self
    //Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    //
    //Example:
    //
    //Input:  [1,2,3,4]
    //Output: [24,12,8,6]
    //Note: Please solve it without division and in O(n).
    //
    //Follow up:
    //Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

    //TLE
    public int[] productExceptSelf0(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int k = 0; k < i; k++ ) {
                tmp *= nums[k];
            }
            for (int k = i + 1; k < nums.length; k++) {
                tmp *= nums[k];
            }
            result[i] = tmp;
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
