package com.xieyangzhe.com.s300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 16/12/19
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
    private int result;

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[] {1, 2, 3}, 3));
    }
}
