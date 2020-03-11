package com.xieyangzhe.com.first.s600;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 14/1/20
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len * 2 - 1; i >= 0; i--) {
            int index = i % len;
            while (!stack.isEmpty() && nums[index] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (i < len) {
                res[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
            }
            stack.push(index);
        }
        return res;
    }
}
