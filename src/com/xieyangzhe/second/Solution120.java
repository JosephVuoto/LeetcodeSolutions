package com.xieyangzhe.second;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 25/3/20
 */
public class Solution120 {
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
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
