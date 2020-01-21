package com.xieyangzhe.com.s700;

/**
 * @author Yangzhe Xie
 * @date 21/1/20
 */
public class Solution673 {

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
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        //以第i个数结尾的最大长度
        int[] length = new int[len];
        //以第i个数结尾最大长度的对应序列个数
        int[] cnt = new int[len];
        for (int i = 0; i < len; i++) {
            length[i] = 1;
            cnt[i] = 1;
        }
        int maxLength = 1;
        for (int i = 1; i < len; i++) {
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
        for (int i = 0; i < len; i++) {
            if (length[i] == maxLength) res += cnt[i];
        }
        return res;
    }
}
