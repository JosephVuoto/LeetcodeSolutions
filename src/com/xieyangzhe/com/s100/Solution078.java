package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.List;

public class Solution078 {
    //78. Subsets
    //Given a set of distinct integers, nums, return all possible subsets (the power set).
    //
    //Note: The solution set must not contain duplicate subsets.
    //
    //Example:
    //
    //Input: nums = [1,2,3]
    //Output:
    //[
    //  [3],
    //  [1],
    //  [2],
    //  [1,2,3],
    //  [1,3],
    //  [2,3],
    //  [1,2],
    //  []
    //]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int start, int[] nums) {
        if (tmpList.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            result.add(new ArrayList<>(tmpList));
            backtrack(result, tmpList, i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution078().subsets(new int[] {1,2,3}));
    }
}
