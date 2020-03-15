package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 15/3/20
 */
public class Solution039 {
    //39. Combination Sum
    //Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    //
    //The same repeated number may be chosen from candidates unlimited number of times.
    //
    //Note:
    //
    //All numbers (including target) will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: candidates = [2,3,6,7], target = 7,
    //A solution set is:
    //[
    //  [7],
    //  [2,2,3]
    //]
    //Example 2:
    //
    //Input: candidates = [2,3,5], target = 8,
    //A solution set is:
    //[
    //  [2,2,2,2],
    //  [2,3,3],
    //  [3,5]
    //]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (!result.contains(tmp)) {
                result.add(new ArrayList<>(tmp));
            }
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(result, new ArrayList<>(tmp), candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution039().combinationSum(new int[]{2,3,5}, 8));
    }
}
