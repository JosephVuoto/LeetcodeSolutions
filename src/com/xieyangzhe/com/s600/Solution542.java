package com.xieyangzhe.com.s600;

/**
 * @author Yangzhe Xie
 * @date 16/1/20
 */
public class Solution542 {
    //542. 01 Matrix
    //Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
    //
    //The distance between two adjacent cells is 1.
    //
    //
    //
    //Example 1:
    //
    //Input:
    //[[0,0,0],
    // [0,1,0],
    // [0,0,0]]
    //
    //Output:
    //[[0,0,0],
    // [0,1,0],
    // [0,0,0]]
    //Example 2:
    //
    //Input:
    //[[0,0,0],
    // [0,1,0],
    // [1,1,1]]
    //
    //Output:
    //[[0,0,0],
    // [0,1,0],
    // [1,2,1]]
    //
    //
    //Note:
    //
    //The number of elements of the given matrix will not exceed 10,000.
    //There are at least one 0 in the given matrix.
    //The cells are adjacent in only four directions: up, down, left and right.
    //Accepted
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        int range = matrix.length * matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int upCell = (i > 0) ? result[i - 1][j] : range;
                    int leftCell = (j > 0) ? result[i][j - 1] : range;
                    result[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int downCell = (i < matrix.length - 1) ? result[i + 1][j] : range;
                    int rightCell = (j < matrix[0].length - 1) ? result[i][j + 1] : range;
                    result[i][j] = Math.min(Math.min(downCell, rightCell) + 1, result[i][j]);
                }
            }
        }
        return result;
    }
}
