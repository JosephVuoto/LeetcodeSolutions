package com.xieyangzhe.com.s500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 14/1/20
 */
public class Solution491 {
    //491. Increasing Subsequences
    //Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
    //
    //Example:
    //
    //Input: [4, 6, 7, 7]
    //Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
    //
    //
    //Note:
    //
    //The length of the given array will not exceed 15.
    //The range of integer in the given array is [-100,100].
    //The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return new ArrayList<>(result);
    }
    
    private void dfs(Set<List<Integer>> result, List<Integer> tmp, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (tmp.isEmpty() || nums[i] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                if (tmp.size() > 1) {
                    result.add(new ArrayList<>(tmp));
                }
                dfs(result, new ArrayList<>(tmp), nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution491().findSubsequences(new int[] {4, 6, 7, 7}));
    }
}
