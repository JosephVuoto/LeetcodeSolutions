package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 2/6/20
 */
public class Solution678 {
    //678. Valid Parenthesis String
    //Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
    //
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    //An empty string is also valid.
    //Example 1:
    //Input: "()"
    //Output: True
    //Example 2:
    //Input: "(*)"
    //Output: True
    //Example 3:
    //Input: "(*))"
    //Output: True
    //Note:
    //The string size will be in the range [1, 100].
    public boolean checkValidString(String s) {
        int max = 0, min = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min--;
                if (max < 0) {
                    return false;
                }
                if (min < 0 && cnt + min >= 0) {
                    min = 0;
                    cnt -= min;
                }
            } else if (c == '*') {
                cnt++;
                max++;
                min--;
            }
        }
        return max == 0 || min == 0 ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution678().checkValidString("(*)))"));
    }
}
