package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8,
//        A solution set is:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        Example 2:
//
//        Input: candidates = [2,5,2,1,2], target = 5,
//        A solution set is:
//        [
//        [1,2,2],
//        [5]
//        ]
public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doSomething(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void doSomething(List<List<Integer>> result, List<Integer> tmpList, int[] candidates, int target, int index) {
        if (target >= 0) {
            if (target == 0) {
                if (!result.contains(tmpList)) {
                    result.add(new ArrayList<>(tmpList));
                }
            } else {
                for (int i = index; i < candidates.length; i++) {
                    tmpList.add(candidates[i]);
                    doSomething(result, tmpList, candidates, target - candidates[i], i + 1);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }
}
