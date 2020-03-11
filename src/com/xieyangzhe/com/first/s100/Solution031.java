package com.xieyangzhe.com.first.s100;

//        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//        The replacement must be in-place and use only constant extra memory.
//
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1


import java.util.Arrays;

public class Solution031 {
    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; --j) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            } else if (i == 0) {
                Arrays.sort(nums);
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
