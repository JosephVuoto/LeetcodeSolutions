package com.xieyangzhe.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 6/7/20
 */
public class Solution056 {
    //56. 合并区间
    //给出一个区间的集合，请合并所有重叠的区间。
    //
    //示例 1:
    //
    //输入: [[1,3],[2,6],[8,10],[15,18]]
    //输出: [[1,6],[8,10],[15,18]]
    //解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2:
    //
    //输入: [[1,4],[4,5]]
    //输出: [[1,5]]
    //解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int first = intervals[0][0], second = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > second) {
                list.add(new int[]{first, second});
                first = intervals[i][0];
            }
            second = Math.max(intervals[i][1], second);
        }
        list.add(new int[]{first, second});
        return list.toArray(new int[0][0]);
    }
}
