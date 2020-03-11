package com.xieyangzhe.com.first.s300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 29/12/19
 */
public class Solution216 {
    //216. Combination Sum III
    //Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    //
    //Note:
    //
    //All numbers will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: k = 3, n = 7
    //Output: [[1,2,4]]
    //Example 2:
    //
    //Input: k = 3, n = 9
    //Output: [[1,2,6], [1,3,5], [2,3,4]]
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, result, new ArrayList<>(), n, 0);
        return result;
    }

    private void combinationSum3(int k, List<List<Integer>> result, List<Integer> tmp, int target, int start) {
        if (tmp.size() == k) {
            if (target == 0) {
                result.add(tmp);
            }
        }
        for (int i = start + 1; i <= 9; i++) {
            tmp.add(i);
            combinationSum3(k, result, new ArrayList<>(tmp), target - i, i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution216().combinationSum3(3, 9));
    }
}
