package com.xieyangzhe.first.s500;

/**
 * @author Yangzhe Xie
 * @date 13/1/20
 */
public class Solution485 {
    //485. Max Consecutive Ones
    //Given a binary array, find the maximum number of consecutive 1s in this array.
    //
    //Example 1:
    //Input: [1,1,0,1,1,1]
    //Output: 3
    //Explanation: The first two digits or the last three digits are consecutive 1s.
    //    The maximum number of consecutive 1s is 3.
    //Note:
    //
    //The input array will only contain 0 and 1.
    //The length of input array is a positive integer and will not exceed 10,000
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                result = Math.max(result, tmp);
                tmp = 0;
            }
        }
        result = Math.max(result, tmp);
        return result;
    }
}
