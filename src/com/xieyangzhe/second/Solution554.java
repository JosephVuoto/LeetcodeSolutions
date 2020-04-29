package com.xieyangzhe.second;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 29/4/20
 */
public class Solution554 {
    //554. Brick Wall
    //There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
    //
    //The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
    //
    //If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
    //
    //You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
    //
    //
    //
    //Example:
    //
    //Input: [[1,2,2,1],
    //        [3,1,2],
    //        [1,3,2],
    //        [2,4],
    //        [3,1,2],
    //        [1,3,1,1]]
    //
    //Output: 2
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> memo = new HashMap<>();
        int result = 0;
        for (List<Integer> level: wall) {
            int slot = 0;
            for (int i = 0; i < level.size() - 1; i++) {
                slot += level.get(i);
                int tmp = memo.getOrDefault(slot, 0);
                result = Math.max(tmp + 1, result);
                memo.put(slot, tmp + 1);
            }
        }
        return wall.size() - result;
    }
}
