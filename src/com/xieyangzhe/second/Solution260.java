package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 6/4/20
 */
public class Solution260 {
    //260. Single Number III
    //Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
    //
    //Example:
    //
    //Input:  [1,2,1,3,2,5]
    //Output: [3,5]
    //Note:
    //
    //The order of the result is not important. So in the above example, [5, 3] is also correct.
    //Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
    public int[] singleNumber(int[] nums) {
        int allXor = 0;
        for (int num: nums) {
            allXor ^= num;
        }
        allXor &= -allXor;
        int[] result = new int[] {0, 0};
        for (int num: nums) {
            if ((allXor & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
