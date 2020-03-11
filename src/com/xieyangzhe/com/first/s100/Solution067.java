package com.xieyangzhe.com.first.s100;

//67. Add Binary
//        Given two binary strings, return their sum (also a binary string).
//
//        The input strings are both non-empty and contains only characters 1 or 0.
//
//        Example 1:
//        Input: a = "11", b = "1"
//        Output: "100"

//        Example 2:
//        Input: a = "1010", b = "1011"
//        Output: "10101"

public class Solution067 {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        char carry = '0';
        StringBuilder sb = new StringBuilder();
        while (lenA > 0 && lenB > 0) {
            char charA = a.charAt(--lenA);
            char charB = b.charAt(--lenB);
            if (charA + charB + carry == '0' + '0' + '0') {
                sb.append(0);
                carry = '0';
            } else if (charA + charB + carry == '0' + '0' + '1') {
                sb.append(1);
                carry = '0';
            } else if (charA + charB + carry == '0' + '1' + '1') {
                sb.append(0);
                carry = '1';
            } else if (charA + charB + carry == '1' + '1' + '1') {
                sb.append(1);
                carry = '1';
            }
        }
        while (lenA > 0) {
            char charA = a.charAt(--lenA);
            if (charA + carry == '0' + '0') {
                sb.append(0);
                carry = '0';
            } else if (charA + carry == '0' + '1') {
                sb.append(1);
                carry = '0';
            } else if (charA + carry == '1' + '1') {
                sb.append(0);
                carry = '1';
            }
        }
        while (lenB > 0) {
            char charB = b.charAt(--lenB);
            if (charB + carry == '0' + '0') {
                sb.append(0);
                carry = '0';
            } else if (charB + carry == '0' + '1') {
                sb.append(1);
                carry = '0';
            } else if (charB + carry == '1' + '1') {
                sb.append(0);
                carry = '1';
            }
        }
        if (carry == '1') {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        int sum;
        while (lenA > 0 || lenB > 0) {
            sum = carry;
            if (lenA > 0) {
                sum += (a.charAt(--lenA) - '0');
            }
            if (lenB > 0) {
                sum += (b.charAt(--lenB) - '0');
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
