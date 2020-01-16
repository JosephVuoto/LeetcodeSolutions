package com.xieyangzhe.com.s600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 16/1/20
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
    //
    //Explanation:
    //
    //
    //
    //Note:
    //
    //The width sum of bricks in different rows are the same and won't exceed INT_MAX.
    //The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = wall.size();
        for (int key : map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }

    //TLE
    public int leastBricks1(List<List<Integer>> wall) {
        int width = 0, result = wall.size();
        for (int brick : wall.get(0)) {
            width += brick;
        }
        for (int i = 1; i < width; i++) {
            int cnt = 0;
            for (List<Integer> level : wall) {
                int tmp = 0;
                for (int brick : level) {
                    tmp += brick;
                    if (tmp == i) {
                        break;
                    } else if (tmp > i) {
                        cnt++;
                        break;
                    }
                }
            }
            result = Math.min(result, cnt);
        }
        return result;
    }
}
