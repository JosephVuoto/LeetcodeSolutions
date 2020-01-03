package com.xieyangzhe.com.s400;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 3/1/20
 */
public class Solution313 {
    //313. Super Ugly Number
    //Write a program to find the nth super ugly number.
    //
    //Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
    //
    //Example:
    //
    //Input: n = 12, primes = [2,7,13,19]
    //Output: 32
    //Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
    //             super ugly numbers given primes = [2,7,13,19] of size 4.
    //Note:
    //
    //1 is a super ugly number for any given primes.
    //The given numbers in primes are in ascending order.
    //0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
    //The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        int[] result = new int[n];
        int[] flag = new int[length];
        result[0] = 1;

        int[] tmp = new int[length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                tmp[j] = primes[j] * result[flag[j]];
                min = Math.min(min, tmp[j]);
            }
            for (int k = 0; k < length; k++) {
                if (tmp[k] == min) {
                    flag[k]++;
                }
            }
            result[i] = min;
        }
        return result[n - 1];
    }
}
