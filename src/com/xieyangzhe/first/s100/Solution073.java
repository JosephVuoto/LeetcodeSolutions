package com.xieyangzhe.first.s100;

import java.util.HashSet;
import java.util.Set;

public class Solution073 {
    //73. Set Matrix Zeroes
    //Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
    //
    //Example 1:
    //
    //Input:
    //[
    //  [1,1,1],
    //  [1,0,1],
    //  [1,1,1]
    //]
    //Output:
    //[
    //  [1,0,1],
    //  [0,0,0],
    //  [1,0,1]
    //]
    //Example 2:
    //
    //Input:
    //[
    //  [0,1,2,0],
    //  [3,4,5,2],
    //  [1,3,1,5]
    //]
    //Output:
    //[
    //  [0,0,0,0],
    //  [0,4,5,0],
    //  [0,3,1,0]
    //]
    //Follow up:
    //
    //A straight forward solution using O(mn) space is probably a bad idea.
    //A simple improvement uses O(m + n) space, but still not the best solution.
    //Could you devise a constant space solution?
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        if (matrix[0].length == 0) {
            return;
        }
        Set<Integer> zeroX = new HashSet<>();
        Set<Integer> zeroY = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroX.add(i);
                    zeroY.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroX.contains(i) || zeroY.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}