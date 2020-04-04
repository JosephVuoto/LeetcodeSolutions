package com.xieyangzhe.first.s200;

/**
 * @author Yangzhe Xie
 * @date 23/12/19
 */
public class Solution169 {
    //169. Majority Element
    //Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    //
    //You may assume that the array is non-empty and the majority element always exist in the array.
    //
    //Example 1:
    //
    //Input: [3,2,3]
    //Output: 3
    //Example 2:
    //
    //Input: [2,2,1,1,1,2,2]
    //Output: 2
    public int majorityElement(int[] nums) {
        int cnt = 1, tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp) {
                cnt--;
                if (cnt == 0) {
                    tmp = nums[i];
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }
        return tmp;
    }
}
