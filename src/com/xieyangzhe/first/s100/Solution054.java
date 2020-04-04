package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.List;

//
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//        Example 1:
//
//        Input:
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        Output: [1,2,3,6,9,8,7,4,5]
//        Example 2:
//
//        Input:
//        [
//        [1, 2, 3, 4],
//        [5, 6, 7, 8],
//        [9,10,11,12]
//        ]
//        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
public class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int r = matrix.length, c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        int ri = 0, ci = 0, d = 0;

        for (int i = 0; i < r * c; i++) {
            res.add(matrix[ri][ci]);
            visited[ri][ci] = true;
            int rn = ri + rd[d];
            int cn = ci + cd[d];
            if (rn < 0 || cn < 0 || rn >= r || cn >= c || visited[rn][cn]) {
                d = (d + 1) % 4;
                ri += rd[d];
                ci += cd[d];
            } else {
                ri = rn;
                ci = cn;
            }
        }

        return res;
    }
}
