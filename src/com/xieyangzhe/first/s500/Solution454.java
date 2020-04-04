package com.xieyangzhe.first.s500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution454 {
    //454. 4Sum II
    //Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
    //
    //To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
    //
    //Example:
    //
    //Input:
    //A = [ 1, 2]
    //B = [-2,-1]
    //C = [-1, 2]
    //D = [ 0, 2]
    //
    //Output:
    //2
    //
    //Explanation:
    //The two tuples are:
    //1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    //2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int numA : A) {
            for (int numB : B) {
                map.put(numA + numB, map.getOrDefault(numA + numB, 0) + 1);
            }
        }
        for (int numC : C) {
            for (int numD : D) {
                cnt += map.getOrDefault(-(numC + numD), 0);
            }
        }
        return cnt;
    }
}
