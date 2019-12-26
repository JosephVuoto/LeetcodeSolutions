package com.xieyangzhe.com.s300;

/**
 * @author Yangzhe Xie
 * @date 26/12/19
 */
public class Solution240 {
    //240. Search a 2D Matrix II
    //Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    //
    //Integers in each row are sorted in ascending from left to right.
    //Integers in each column are sorted in ascending from top to bottom.
    //Example:
    //
    //Consider the following matrix:
    //
    //[
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    //Given target = 5, return true.
    //
    //Given target = 20, return false.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
