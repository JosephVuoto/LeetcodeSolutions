package com.xieyangzhe.com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 12/3/20
 */
//22. Generate Parentheses
//Medium
//
//4226
//
//233
//
//Add to List
//
//Share
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, String current) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        dfs(result, left - 1, right, current + "(");
        dfs(result, left, right - 1, current + ")");
    }
}
