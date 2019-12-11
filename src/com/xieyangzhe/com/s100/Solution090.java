package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/12/19
 */
public class Solution090 {
    //90. Subsets II
    //Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
    //
    //Note: The solution set must not contain duplicate subsets.
    //
    //Example:
    //
    //Input: [1,2,2]
    //Output:
    //[
    //  [2],
    //  [1],
    //  [1,2,2],
    //  [2,2],
    //  [1,2],
    //  []
    //]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        if (pos <= nums.length) {
            res.add(new ArrayList<>(tmpRes));
        }
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            tmpRes.add(nums[i]);
            backtrack(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
