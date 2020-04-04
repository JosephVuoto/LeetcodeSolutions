package com.xieyangzhe.first.s200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 13/12/19
 */
public class Solution120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution120().minimumTotal(triangle));
    }

    //120. Triangle
    //Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    //
    //For example, given the following triangle
    //
    //[
    //     [2],
    //    [3,4],
    //   [6,5,7],
    //  [4,1,8,3]
    //]
    //The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    //
    //Note:
    //
    //Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
