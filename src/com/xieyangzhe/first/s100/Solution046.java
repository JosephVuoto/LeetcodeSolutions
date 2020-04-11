package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 27/12/19
 */
public class Solution046 {
    public static void main(String[] args) {
        new Solution046().permute();
    }

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

    private void permute() {
        long time = new Date().getTime();
        List<String> result = new ArrayList<>();
        dfs(9, result, "", new ArrayList<>(), Arrays.asList("1 2", "2 1"));
//        System.out.println(result);
        System.out.println(new Date().getTime() - time + "ms");
    }

    private void dfs(int n, List<String> result, String tmpString, List<Integer> tmpList, List<String> rules) {
        if (tmpList.size() == n) {
            result.add(tmpString);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!tmpList.contains(i)) {
                String newTmpString = tmpString.length() == 0 ? "" + i : tmpString + " " + i;
                boolean isValid = true;
                for (String rule: rules) {
                    if (newTmpString.contains(rule)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    tmpList.add(i);
                    dfs(n, result, newTmpString, new ArrayList<>(tmpList), rules);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }
}
