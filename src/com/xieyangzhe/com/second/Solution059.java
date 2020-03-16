package com.xieyangzhe.com.second;

/**
 * @author Yangzhe Xie
 * @date 17/3/20
 */
public class Solution059 {
    //Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    //
    //Example:
    //
    //Input: 3
    //Output:
    //[
    // [ 1, 2, 3 ],
    // [ 8, 9, 4 ],
    // [ 7, 6, 5 ]
    //]
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i;
            int tmpx = x + dx[di];
            int tmpy = y + dy[di];
            if (tmpx > n - 1 || tmpx < 0
                    || tmpy > n - 1 || tmpy < 0
                    || matrix[tmpx][tmpy] > 0) {
                di = (di + 1) % 4;
                x = x + dx[di];
                y = y + dy[di];
            } else {
                x = tmpx;
                y = tmpy;
            }
        }

        return matrix;
    }
}
