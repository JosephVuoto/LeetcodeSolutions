package com.xieyangzhe.com.first.s700;

/**
 * @author Yangzhe Xie
 * @date 19/1/20
 */
public class Solution633 {
    //Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
    //
    //Example 1:
    //
    //Input: 5
    //Output: True
    //Explanation: 1 * 1 + 2 * 2 = 5
    //
    //
    //Example 2:
    //
    //Input: 3
    //Output: False
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
