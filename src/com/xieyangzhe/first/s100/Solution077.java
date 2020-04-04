package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.List;

public class Solution077 {
    public static void main(String[] args) {
        new Solution077().combine(4, 2);
    }

    //77. Combinations
    //Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    //
    //Example:
    //
    //Input: n = 4, k = 2
    //Output:
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int n, int k, int start) {
        if (tmpList.size() == k) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmpList.add(i);
            backtrack(result, tmpList, n, k, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
