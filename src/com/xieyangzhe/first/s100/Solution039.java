package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        The same repeated number may be chosen from candidates unlimited number of times.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//        [7],
//        [2,2,3]
//        ]
//        Example 2:
//
//        Input: candidates = [2,3,5], target = 8,
//        A solution set is:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]
public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doSomething(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void doSomething(List<List<Integer>> result, int[] candidates, int target, List<Integer> list, int index) {
        if (target >= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            } else {
                for (int i = index; i < candidates.length; i++) {
                    list.add(candidates[i]);
                    doSomething(result, candidates, target - candidates[i], list, i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
