package com.xieyangzhe.first.s800;

/**
 * @author Yangzhe Xie
 * @date 4/2/20
 */
public class Solution738 {
    //738. Monotone Increasing Digits
    //Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
    //
    //(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
    //
    //Example 1:
    //Input: N = 10
    //Output: 9
    //Example 2:
    //Input: N = 1234
    //Output: 1234
    //Example 3:
    //Input: N = 332
    //Output: 299
    //Note: N is an integer in the range [0, 10^9].
    public int monotoneIncreasingDigits(int N) {
        char[] ans = String.valueOf(N).toCharArray();
        int len = ans.length, idx = len;
        for (int i = len - 2; i >= 0; i--) {
            if (ans[i] > ans[i + 1]) {
                idx = i + 1;
                ans[i]--;
            }
        }
        for (int i = idx; i < len; ++i) {
            ans[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ans));
    }
}
