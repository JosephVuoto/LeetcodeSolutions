package com.xieyangzhe.first.s300;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution264 {
    //264. Ugly Number II
    //Write a program to find the n-th ugly number.
    //
    //Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
    //
    //Example:
    //
    //Input: n = 10
    //Output: 12
    //Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
    //Note:
    //
    //1 is typically treated as an ugly number.
    //n does not exceed 1690.
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int currMin = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (currMin == result[p2] * 2) {
                p2++;
            }
            if (currMin == result[p3] * 3) {
                p3++;
            }
            if (currMin == result[p5] * 5) {
                p5++;
            }
            result[i] = currMin;
        }
        return result[n - 1];
    }
}
