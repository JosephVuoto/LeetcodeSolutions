package com.xieyangzhe.third;

/**
 * @author Yangzhe Xie
 * @date 6/7/20
 */
public class Solution200 {
    //200. 岛屿数量
    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    //
    //岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
    //
    //此外，你可以假设该网格的四条边均被水包围。
    //
    //
    //
    //示例 1:
    //
    //输入:
    //[
    //['1','1','1','1','0'],
    //['1','1','0','1','0'],
    //['1','1','0','0','0'],
    //['0','0','0','0','0']
    //]
    //输出: 1
    //示例 2:
    //
    //输入:
    //[
    //['1','1','0','0','0'],
    //['1','1','0','0','0'],
    //['0','0','1','0','0'],
    //['0','0','0','1','1']
    //]
    //输出: 3
    //解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return false;
        }
        if (grid[i][j] == '2') {
            return false;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            return true;
        }
        return false;
    }
}
