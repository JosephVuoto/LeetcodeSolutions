package com.xieyangzhe.com.s600;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 18/1/20
 */
public class Solution576 {
    //576. Out of Boundary Paths
    //There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
    int M = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        for (int[][] l : memo) {
            for (int[] sl : l) {
                Arrays.fill(sl, -1);
            }
        }
        return findPaths(m, n, N, i, j, memo);
    }

    public int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
        if (i == m || j == n || i < 0 || j < 0) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[i][j][N] >= 0) {
            return memo[i][j][N];
        }
        memo[i][j][N] = ((findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M + (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M) % M;
        return memo[i][j][N];
    }
}
