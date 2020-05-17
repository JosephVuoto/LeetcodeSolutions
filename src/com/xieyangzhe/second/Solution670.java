package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 17/5/20
 */
public class Solution670 {
    //670. Maximum Swap
    //Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
    //
    //Example 1:
    //Input: 2736
    //Output: 7236
    //Explanation: Swap the number 2 and the number 7.
    //Example 2:
    //Input: 9973
    //Output: 9973
    //Explanation: No swap.
    //Note:
    //The given number is in the range [0, 108]
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int digit = 9; digit > chars[i] - '0'; digit--) {
                if (lastIndex[digit] > i) {
                    char tmp = chars[i];
                    chars[i] = chars[lastIndex[digit]];
                    chars[lastIndex[digit]] = tmp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
