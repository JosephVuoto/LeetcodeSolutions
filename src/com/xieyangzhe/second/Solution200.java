package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 30/3/20
 */
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
public class Solution200 {
    private boolean visited[][];

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println(new Solution200().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                result++;
                dfs(grid, i, j);
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x == grid.length ||
                y < 0 || y == grid[0].length ||
                visited[x][y] || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = true;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
