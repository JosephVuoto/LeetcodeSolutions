package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 16/3/20
 */
public class Solution055 {
    //55. Jump Game
    //Given an array of non-negative integers, you are initially positioned at the first index of the array.
    //
    //Each element in the array represents your maximum jump length at that position.
    //
    //Determine if you are able to reach the last index.
    //
    //Example 1:
    //
    //Input: [2,3,1,1,4]
    //Output: true
    //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    //Example 2:
    //
    //Input: [3,2,1,0,4]
    //Output: false
    //Explanation: You will always arrive at index 3 no matter what. Its maximum
    //             jump length is 0, which makes it impossible to reach the last index.

    //Greedy
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach < i || maxReach >= nums.length - 1) {
                break;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }

    //DP
    public boolean canJump1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
