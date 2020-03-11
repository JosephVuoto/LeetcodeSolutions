package com.xieyangzhe.com.first.s300;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution227 {
    //227. Basic Calculator II
    //Implement a basic calculator to evaluate a simple expression string.
    //
    //The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
    //
    //Example 1:
    //
    //Input: "3+2*2"
    //Output: 7
    //Example 2:
    //
    //Input: " 3/2 "
    //Output: 1
    //Example 3:
    //
    //Input: " 3+5 / 2 "
    //Output: 5
    //Note:
    //
    //You may assume that the given expression is always valid.
    //Do not use the eval built-in library function.
    public int calculate(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                operator = c;
            }
        }
        num = 0;
        while (!stack.empty()) {
            num += stack.pop();
        }
        return num;
    }
}
