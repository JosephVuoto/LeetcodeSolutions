package com.xieyangzhe.second;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 31/5/20
 */
//673. Number of Longest Increasing Subsequence
//Given an unsorted array of integers, find the number of longest increasing subsequence.
//
//Example 1:
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
//Example 2:
//Input: [2,2,2,2,2]
//Output: 5
//Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
//Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
public class Solution673 {
    public static void main(String[] args) {
        System.out.println(new Solution673().findNumberOfLIS(new int[] {1,3,5,4,7}));
    }
    public int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] cnt = new int[nums.length];
        int maxLength = 1;
        Arrays.fill(length, 1);
        Arrays.fill(cnt, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 == length[i]) {
                        cnt[i] += cnt[j];
                    } else if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (length[i] == maxLength) {
                res += cnt[i];
            }
        }
        return res;
    }
}
