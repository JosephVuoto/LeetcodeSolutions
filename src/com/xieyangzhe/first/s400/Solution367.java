package com.xieyangzhe.first.s400;

/**
 * @author Yangzhe Xie
 * @date 4/1/20
 */
public class Solution367 {
    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(2147483647));
    }

    //367. Valid Perfect Square
    //Given a positive integer num, write a function which returns True if num is a perfect square else False.
    //
    //Note: Do not use any built-in library function such as sqrt.
    //
    //Example 1:
    //
    //Input: 16
    //Output: true
    //Example 2:
    //
    //Input: 14
    //Output: false
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }


}
