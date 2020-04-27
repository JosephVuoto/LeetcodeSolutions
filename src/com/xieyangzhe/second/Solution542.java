package com.xieyangzhe.second;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 27/4/20
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
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = pos[0] + directions[i][0];
                int newY = pos[1] + directions[i][1];
                if (newX >= 0 && newX < matrix.length
                        && newY >= 0 && newY < matrix[0].length
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[pos[0]][pos[1]] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        Solution542 solution = new Solution542();
        int[][] updateMatrix = solution.updateMatrix(matrix);
        for (int i = 0; i < updateMatrix.length; i++) {
            System.out.println(Arrays.toString(updateMatrix[i]));
        }
    }
}
