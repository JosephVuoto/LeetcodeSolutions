package com.xieyangzhe.first.s100;

/**
 * @author Yangzhe Xie
 * @date 2019-08-28
 */

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//        Note: You can only move either down or right at any point in time.
//
//        Example:
//
//        Input:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        Output: 7
//        Explanation: Because the path 1→3→1→1→1 minimizes the sum.
public class Solution064 {
    public int minPathSum(int[][] grid) {
        int col = grid.length;
        if (col == 0) {
            return 0;
        }
        int row = grid[0].length;
        int[][] cost = new int[col][row];
        int sum = 0;
        for (int i = 0; i < col; i++) {
            sum += grid[i][0];
            cost[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < row; i++) {
            sum += grid[0][i];
            cost[0][i] = sum;
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                cost[i][j] = Math.min(cost[i - 1][j], cost[j][i - 1]) + grid[i][j];
            }
        }
        return cost[col - 1][row - 1];
    }
}
