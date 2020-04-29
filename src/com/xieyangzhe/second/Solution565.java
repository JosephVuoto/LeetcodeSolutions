package com.xieyangzhe.second;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 30/4/20
 */
public class Solution565 {
    //565. Array Nesting
    //A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
    //
    //Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
    //
    //
    //
    //Example 1:
    //
    //Input: A = [5,4,0,3,1,6,2]
    //Output: 4
    //Explanation:
    //A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
    //
    //One of the longest S[K]:
    //S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
    public int arrayNesting(int[] nums) {
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int index = nums[i];
            do {
                visited.add(index);
                set.add(index);
                index = nums[index];
            } while (!set.contains(index));
            result = Math.max(result, set.size());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution565().arrayNesting(new int[]{1,0,3,4,2}));
    }
}
