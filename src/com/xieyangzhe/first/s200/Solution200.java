package com.xieyangzhe.first.s200;

/**
 * @author Yangzhe Xie
 * @date 24/12/19
 */
public class Solution200 {
    //200. Number of Islands
    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
    //
    //Example 1:
    //
    //Input:
    //11110
    //11010
    //11000
    //00000
    //
    //Output: 1
    //Example 2:
    //
    //Input:
    //11000
    //11000
    //00100
    //00011
    //
    //Output: 3
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    markHelper(grid, i, j);
                }
            }
        }
        return result;
    }

    private void markHelper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 2;
        markHelper(grid, i + 1, j);
        markHelper(grid, i - 1, j);
        markHelper(grid, i, j + 1);
        markHelper(grid, i, j - 1);
    }
}
