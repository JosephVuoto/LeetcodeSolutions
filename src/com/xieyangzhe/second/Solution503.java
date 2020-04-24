package com.xieyangzhe.second;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 24/4/20
 */
public class Solution503 {
    //503. Next Greater Element II
    //Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
    //
    //Example 1:
    //Input: [1,2,1]
    //Output: [2,-1,2]
    //Explanation: The first 1's next greater number is 2;
    //The number 2 can't find next greater number;
    //The second 1's next greater number needs to search circularly, which is also 2.

    public static void main(String[] args) {
        int[] res = new Solution503().nextGreaterElements(new int[]{3,8,4,1,2});
        for (int num: res) {
            System.out.println(num);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.empty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(nums[i]);
        }
        return result;
    }

    public int[] nextGreaterElements1(int[] nums) {
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
