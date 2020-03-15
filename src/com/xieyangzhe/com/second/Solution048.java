package com.xieyangzhe.com.second;

/**
 * @author Yangzhe Xie
 * @date 15/3/20
 */
public class Solution048 {
    //Given input matrix =
    //[
    //  [1,2,3],
    //  [4,5,6],
    //  [7,8,9]
    //],
    //
    //rotate the input matrix in-place such that it becomes:
    //[
    //  [7,4,1],
    //  [8,5,2],
    //  [9,6,3]
    //]
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2; j++){
                swap(matrix, i, j, i, matrix.length - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}
