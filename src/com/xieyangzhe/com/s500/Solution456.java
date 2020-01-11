package com.xieyangzhe.com.s500;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 11/1/20
 */
public class Solution456 {
    //456. 132 Pattern
    //Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
    //
    //Note: n will be less than 15,000.
    //
    //Example 1:
    //Input: [1, 2, 3, 4]
    //
    //Output: False
    //
    //Explanation: There is no 132 pattern in the sequence.
    //Example 2:
    //Input: [3, 1, 4, 2]
    //
    //Output: True
    //
    //Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
    //Example 3:
    //Input: [-1, 3, 2, 0]
    //
    //Output: True
    //
    //Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.empty() && nums[i] > stack.peek()) {
                third = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min = Math.min(min, nums[j]);
            if (min == nums[j]) {
                continue;
            }
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
