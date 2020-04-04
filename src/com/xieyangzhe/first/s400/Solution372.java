package com.xieyangzhe.first.s400;

/**
 * @author Yangzhe Xie
 * @date 4/1/20
 */
public class Solution372 {
    //372. Super Pow
    //Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
    //
    //Example 1:
    //
    //Input: a = 2, b = [3]
    //Output: 8
    //Example 2:
    //
    //Input: a = 2, b = [1,0]
    //Output: 1024
    //Accepted
    //31,532
    //Submissions
    //87,282
    private static final int NUM = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        //not expecting to be a part of input
        if (b == null || b.length == 0)
            return 0;
        a = a % NUM;
        for (int value : b) {
            ans = ((pow(ans, 10) * pow(a, value)) % NUM);
        }
        return ans;
    }

    private int pow(int a, int b) {
        if (b == 1)
            return a;
        if (b == 0)
            return 1;
        int x = pow(a, b / 2);
        x = (x * x) % NUM;
        if ((b & 1) == 1)
            x = (x * a) % NUM;
        return x;
    }
}
