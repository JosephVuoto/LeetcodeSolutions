package com.xieyangzhe.first.s100;

//        Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//        Example:
//
//        Input: 3
//        Output:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]

public class Solution059 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int r = 0, c = 0, di = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        for (int i = 1; i <= n * n; i++) {
            ans[r][c] = i;
            int tmpr = r + dr[di];
            int tmpc = c + dc[di];
            if (tmpr < 0 || tmpr >= n || tmpc < 0
                    || tmpc >= n || ans[tmpr][tmpc] > 0) {
                di = (di + 1) % 4;
                r = r + dr[di];
                c = c + +dc[di];
            } else {
                r = tmpr;
                c = tmpc;
            }
        }
        return ans;
    }
}
