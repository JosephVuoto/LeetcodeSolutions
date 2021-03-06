package com.xieyangzhe.second;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yangzhe Xie
 * @date 7/5/20
 */
public class Solution646 {
    //646. Maximum Length of Pair Chain
    //You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
    //
    //Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
    //
    //Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
    //
    //Example 1:
    //Input: [[1,2], [2,3], [3,4]]
    //Output: 2
    //Explanation: The longest chain is [1,2] -> [3,4]
    //Note:
    //The number of given pairs will be in the range [1, 1000].
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int cur = Integer.MIN_VALUE, result = 0;
        for (int[] pair: pairs) {
            if (pair[0] > cur) {
                result++;
                cur = pair[1];
            }
        }
        return result;
    }
}
