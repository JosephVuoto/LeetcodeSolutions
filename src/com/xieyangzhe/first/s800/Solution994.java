package com.xieyangzhe.first.s800;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 4/9/20
 */
public class Solution994 {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int total = 0, rot = 0, days = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            rot += size;
            while (size-- > 0) {
                int[] position = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = dx[i] + position[0];
                    int y = dy[i] + position[1];
                    if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
            if (!queue.isEmpty()) {
                days++;
            }
        }
        return total == rot ? days : -1;
    }
}
