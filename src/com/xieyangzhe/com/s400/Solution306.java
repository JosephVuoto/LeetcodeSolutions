package com.xieyangzhe.com.s400;

/**
 * @author Yangzhe Xie
 * @date 3/1/20
 */
public class Solution306 {
    //306. Additive Number
    //Additive number is a string whose digits can form additive sequence.
    //
    //A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
    //
    //Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
    //
    //Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
    //
    //Example 1:
    //
    //Input: "112358"
    //Output: true
    //Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
    //             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
    //Example 2:
    //
    //Input: "199100199"
    //Output: true
    //Explanation: The additive sequence is: 1, 99, 100, 199.
    //             1 + 99 = 100, 99 + 100 = 199
    //
    //
    //Constraints:
    //
    //num consists only of digits '0'-'9'.
    //1 <= num.length <= 35
    //Follow up:
    //How would you handle overflow for very large input integers?
    //
    //Accepted
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second + 1) {
                    break;
                }
                while (third < n) {
                    long result = (Long.parseLong(num.substring(first, second)) +
                            Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(Long.toString(result))) {
                        first = second;
                        second = third;
                        third += Long.toString(result).length();
                    } else {
                        break;
                    }
                }
                if (third == n) return true;
            }
        }
        return false;
    }
}
