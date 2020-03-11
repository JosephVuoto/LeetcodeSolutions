package com.xieyangzhe.com.first.s300;

/**
 * @author Yangzhe Xie
 * @date 28/12/19
 */
public class Solution204 {
    //204. Count Primes
    //Count the number of prime numbers less than a non-negative number, n.
    //
    //Example:
    //
    //Input: 10
    //Output: 4
    //Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                cnt++;
                for (int j = 2; j * i < n; j++) {
                    isNotPrime[j * i] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(10));
    }
}
