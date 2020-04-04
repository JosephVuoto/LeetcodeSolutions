package com.xieyangzhe.first.s400;

/**
 * @author Yangzhe Xie
 * @date 4/1/20
 */
public class Solution397 {
    //397. Integer Replacement
    //Given a positive integer n and you can do operations as follow:
    //
    //If n is even, replace n with n/2.
    //If n is odd, you can replace n with either n + 1 or n - 1.
    //What is the minimum number of replacements needed for n to become 1?
    //
    //Example 1:
    //
    //Input:
    //8
    //
    //Output:
    //3
    //
    //Explanation:
    //8 -> 4 -> 2 -> 1
    //Example 2:
    //
    //Input:
    //7
    //
    //Output:
    //4
    //
    //Explanation:
    //7 -> 8 -> 4 -> 2 -> 1
    //or
    //7 -> 6 -> 3 -> 2 -> 1
    //MLE
    public int integerReplacement(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = Math.min(dp[(i - 1) / 2], dp[(i + 1) / 2]) + 2;
            }
        }
        return dp[n];
    }

    public int integerReplacement1(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int result = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if ((n + 1) % 4 == 0 && (n - 1 != 2)) {
                    n++;
                } else {
                    n--;
                }
            }
            result++;
        }
        return result;
    }
}
