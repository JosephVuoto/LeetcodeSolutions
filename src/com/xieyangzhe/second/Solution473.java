package com.xieyangzhe.second;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
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
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, 0, sum / 4, new int[4]);
    }

    private boolean dfs(int[] nums, int index, int target, int[] tmp) {
        if (index == nums.length) {
            return tmp[0] == target && tmp[1] == target &&
                    tmp[2] == target && tmp[3] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (tmp[i] + nums[index] > target) {
                continue;
            }
            tmp[i] += nums[index];
            if (dfs(nums, index + 1, target, tmp)) {
                return true;
            }
            tmp[i] -= nums[index];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
