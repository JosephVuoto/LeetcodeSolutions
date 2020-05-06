package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 6/5/20
 */
public class Solution633 {
    //633. Sum of Square Numbers
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
            int b = c - (int)(a * a);
            if (binary_search(0, b, b)) {
                return true;
            }
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e) {
            return false;
        }
        long mid = s + (e - s) / 2;
        if (mid * mid == n) {
            return true;
        } else if (mid * mid > n) {
            return binary_search(s, mid - 1, n);
        }
        return binary_search(mid + 1, e, n);
    }
}
