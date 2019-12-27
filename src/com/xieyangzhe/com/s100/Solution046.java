package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 27/12/19
 */
public class Solution046 {
    //46. Permutations
    //Given a collection of distinct integers, return all possible permutations.
    //
    //Example:
    //
    //Input: [1,2,3]
    //Output:
    //[
    //  [1,2,3],
    //  [1,3,2],
    //  [2,1,3],
    //  [2,3,1],
    //  [3,1,2],
    //  [3,2,1]
    //]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int num : nums) {
            if (!tmp.contains(num)) {
                tmp.add(num);
                dfs(nums, result, new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution046().permute(new int[] {1,2,3}));
    }
}
