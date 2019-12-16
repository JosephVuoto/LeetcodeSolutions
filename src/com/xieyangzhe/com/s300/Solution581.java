package com.xieyangzhe.com.s300;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 16/12/19
 */
public class Solution581 {
    //581. Shortest Unsorted Continuous Subarray
    //Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
    //
    //You need to find the shortest such subarray and output its length.
    //
    //Example 1:
    //Input: [2, 3, 6, 4, 8, 10, 9, 15]
    //Output: 5
    //Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    //Note:
    //Then length of the input array is in range [1, 10,000].
    //The input array may contain duplicates, so ascending order here means <=.
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    // Using Sorting
    public int findUnsortedSubarray1(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
