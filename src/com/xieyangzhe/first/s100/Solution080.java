package com.xieyangzhe.first.s100;

public class Solution080 {
    public static void main(String[] args) {
        int[] test = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        new Solution080().removeDuplicates(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

    //80. Remove Duplicates from Sorted Array II
    //Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
    //
    //Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    //
    //Example 1:
    //
    //Given nums = [1,1,1,2,2,3],
    //
    //Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    //
    //It doesn't matter what you leave beyond the returned length.
    //Example 2:
    //
    //Given nums = [0,0,1,1,1,1,2,3,3],
    //
    //Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
    //
    //It doesn't matter what values are set beyond the returned length.
    //Clarification:
    //
    //Confused why the returned value is an integer but your answer is an array?
    //
    //Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
    //
    //Internally you can think of this:
    //
    //// nums is passed in by reference. (i.e., without making a copy)
    //int len = removeDuplicates(nums);
    //
    //// any modification to nums in your function would be known by the caller.
    //// using the length returned by your function, it prints the first len elements.
    //for (int i = 0; i < len; i++) {
    //    print(nums[i]);
    //}
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int cur = nums[0];
        int cnt = 1;
        for (int i = 1; i < length; i++) {
            if (cur == nums[i]) {
                cnt++;
            } else {
                cur = nums[i];
                cnt = 1;
            }
            if (cnt > 2) {
                remove(nums, i);
                i--;
                cnt -= 1;
                length--;
            }
        }
        return length;
    }

    private void remove(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
