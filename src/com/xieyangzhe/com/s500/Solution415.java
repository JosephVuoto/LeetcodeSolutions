package com.xieyangzhe.com.s500;

/**
 * @author Yangzhe Xie
 * @date 7/1/20
 */
public class Solution415 {
    //415. Add Strings
    //Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
    //
    //Note:
    //
    //The length of both num1 and num2 is < 5100.
    //Both num1 and num2 contains only digits 0-9.
    //Both num1 and num2 does not contain any leading zero.
    //You must not use any built-in BigInteger library or convert the inputs to integer directly.
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int tmp, flag = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            tmp = num1.charAt(i) + num2.charAt(j) - '0' * 2 + flag;
            flag = tmp > 9 ? 1 : 0;
            sb.append(tmp % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            tmp = num1.charAt(i) - '0' + flag;
            flag = tmp > 9 ? 1 : 0;
            sb.append(tmp % 10);
            i--;
        }
        while (j >= 0) {
            tmp = num2.charAt(j) - '0' + flag;
            flag = tmp > 9 ? 1 : 0;
            sb.append(tmp % 10);
            j--;
        }
        if (flag == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("6", "501"));
    }
}
