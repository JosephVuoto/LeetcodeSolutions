package com.xieyangzhe.com.first.s500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 10/1/20
 */
public class Solution447 {
    //447. Number of Boomerangs
    //Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
    //
    //Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
    //
    //Example:
    //
    //Input:
    //[[0,0],[1,0],[2,0]]
    //
    //Output:
    //2
    //
    //Explanation:
    //The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = (points[j][0] - points[i][0])*(points[j][0] - points[i][0])
                        + (points[j][1] - points[i][1])*(points[j][1] - points[i][1]);
                int size = map.getOrDefault(distance, 0);
                count += size++ * 2;
                map.put(distance, size);
            }
        }
        return count;
    }
}
