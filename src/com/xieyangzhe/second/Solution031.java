package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 13/3/20
 */
public class Solution031 {
    //31. Next Permutation
    //Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    //
    //If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    //
    //The replacement must be in-place and use only constant extra memory.
    //
    //Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    //
    //1,2,3 → 1,3,2
    //3,2,1 → 1,2,3
    //1,1,5 → 1,5,1
    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (j = nums.length - 1; j >= i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from++, to--);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,5,4,3};
        new Solution031().nextPermutation(test);
        for (int num : test) {
            System.out.println(num);
        }
//        System.out.println();
    }
}
