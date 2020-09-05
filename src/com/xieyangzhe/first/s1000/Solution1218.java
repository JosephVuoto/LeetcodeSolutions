package com.xieyangzhe.first.s1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 19/8/20
 */
public class Solution1218 {
    //1218. Longest Arithmetic Subsequence of Given Difference
    //Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
    //
    //
    //
    //Example 1:
    //
    //Input: arr = [1,2,3,4], difference = 1
    //Output: 4
    //Explanation: The longest arithmetic subsequence is [1,2,3,4].
    //Example 2:
    //
    //Input: arr = [1,3,5,7], difference = 1
    //Output: 1
    //Explanation: The longest arithmetic subsequence is any single element.
    //Example 3:
    //
    //Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
    //Output: 4
    //Explanation: The longest arithmetic subsequence is [7,5,3,1].
    //
    //
    //Constraints:
    //
    //1 <= arr.length <= 10^5
    //-10^4 <= arr[i], difference <= 10^4
    public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : arr) {
            int here = memo.getOrDefault(num - difference, 0) + 1;
            result = Math.max(here, result);
            memo.put(num, here);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1218().longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }
}
