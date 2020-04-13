package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 13/4/20
 */
public class Solution386 {
    //386. Lexicographical Numbers
    //Given an integer n, return 1 - n in lexicographical order.
    //
    //For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
    //
    //Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
    public static void main(String[] args) {
        System.out.println(new Solution386().lexicalOrder1(13));
    }

    public List<Integer> lexicalOrder1(int n) {
        int current = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else if (current % 10 != 9 && current + 1 <= n) {
                current++;
            } else {
                while ((current / 10) % 10 == 9) {
                    current /= 10;
                }
                current = current / 10 + 1;
            }
        }
        return result;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, result);
        }
        return result;
    }

    private void dfs(int n, int current, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (current * 10 + i <= n) {
                dfs(n, current * 10 + i, result);
            } else {
                break;
            }
        }
    }
}
