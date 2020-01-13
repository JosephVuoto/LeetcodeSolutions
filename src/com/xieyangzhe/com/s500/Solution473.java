package com.xieyangzhe.com.s500;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 13/1/20
 */
public class Solution473 {
    //473. Matchsticks to Square
    //Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
    //
    //Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
    //
    //Example 1:
    //Input: [1,1,2,2,2]
    //Output: true
    //
    //Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
    //Example 2:
    //Input: [3,3,3,3,4]
    //Output: false
    //
    //Explanation: You cannot find a way to form a square with all the matchsticks.
    //Note:
    //The length sum of the given matchsticks is in the range of 0 to 10^9.
    //The length of the given matchstick array will not exceed 15.
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return dfs(nums, new int[4], nums.length - 1, sum / 4);
    }

    boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if ((sums[i] + nums[index] > target) || (i > 0 && sums[i] == sums[i - 1])) {
                continue;
            }
            sums[i] += nums[index];
            if (dfs(nums, sums, index - 1, target)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }
}
