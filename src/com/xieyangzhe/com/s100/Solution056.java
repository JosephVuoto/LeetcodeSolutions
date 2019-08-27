package com.xieyangzhe.com.s100;

import java.util.Arrays;
import java.util.Comparator;

//        Given a collection of intervals, merge all overlapping intervals.
//
//        Example 1:
//
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//        Example 2:
//
//        Input: [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
public class Solution056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int m = intervals.length;
        int[][] merged = new int[m][2];
        merged[0] = intervals[0];

        int pt = 0;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (merged[pt][1] < intervals[i][0]) {
                merged[++pt] = intervals[i];
                count++;
            } else {
                merged[pt][1] = Math.max(merged[pt][1], intervals[i][1]);
            }
        }
        int[][] res = new int[count][2];
        System.arraycopy(merged, 0, res, 0, count);
        return res;
    }
}

