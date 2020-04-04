package com.xieyangzhe.first.s200;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 24/12/19
 */
public class Solution179 {
    //179. Largest Number
    //Given a list of non negative integers, arrange them such that they form the largest number.
    //
    //Example 1:
    //
    //Input: [10,2]
    //Output: "210"
    //Example 2:
    //
    //Input: [3,30,34,5,9]
    //Output: "9534330"
    //Note: The result may be very large, so you need to return a string instead of an integer.
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String str : numsStr) {
            sb.append(str);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
