package com.xieyangzhe.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 29/4/20
 */
public class Solution560 {
    //560. Subarray Sum Equals K
    //Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
    //
    //Example 1:
    //Input:nums = [1,1,1], k = 2
    //Output: 2
    //Note:
    //The length of the array is in range [1, 20,000].
    //The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        int sum = 0;
        memo.put(0, 1);
        int result = 0;
        for (int num: nums) {
            sum += num;
            if (memo.containsKey(sum - k)) {
                result += memo.get(sum - k);
            }
            memo.put(sum, memo.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
