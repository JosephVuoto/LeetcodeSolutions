package com.xieyangzhe.second;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 14/4/20
 */
public class Solution402 {
    //402. Remove K Digits
    //Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
    //
    //Note:
    //The length of num is less than 10002 and will be ≥ k.
    //The given num does not contain any leading zero.
    //Example 1:
    //
    //Input: num = "1432219", k = 3
    //Output: "1219"
    //Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
    //Example 2:
    //
    //Input: num = "10200", k = 1
    //Output: "200"
    //Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
    //Example 3:
    //
    //Input: num = "10", k = 2
    //Output: "0"
    //Explanation: Remove all the digits from the number and it is left with nothing which is 0.
    public String removeKdigits(String num, int k) {
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c: num.toCharArray()) {
            int digit = c - '0';
            while (k > 0 && !numStack.empty() && digit < numStack.peek()) {
                numStack.pop();
                k--;
            }
            numStack.push(digit);
        }
        while (k-- > 0) {
            numStack.pop();
        }
        while (!numStack.empty()) {
            sb.append(numStack.pop());
        }
        sb.reverse();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        return index >= sb.length() ? "0" : sb.substring(index);
    }
}
