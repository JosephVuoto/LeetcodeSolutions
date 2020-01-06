package com.xieyangzhe.com.s400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 6/1/20
 */
public class Solution386 {
    //386. Lexicographical Numbers
    //Given an integer n, return 1 - n in lexicographical order.
    //
    //For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
    //
    //Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

    List<Integer> result;
    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(i, n);
        }
        return result;
    }

    private void helper(int current, int n) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (current * 10 + i <= n) {
                helper(current * 10 + i, n);
            } else {
                break;
            }
        }
    }
}
