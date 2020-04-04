package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 17/3/20
 */
public class Solution062 {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[n - 1][m - 1];
    }
}
