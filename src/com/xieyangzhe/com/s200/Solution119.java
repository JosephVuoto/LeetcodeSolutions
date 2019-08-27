package com.xieyangzhe.com.s200;

import java.util.Arrays;
import java.util.List;

//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//        Example:
//
//        Input: 3
//        Output: [1,3,3,1]
//        Follow up:
//
//        Could you optimize your algorithm to use only O(k) extra space?
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
}
