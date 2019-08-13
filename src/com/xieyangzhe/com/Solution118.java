package com.xieyangzhe.com;

import java.util.ArrayList;
import java.util.List;

//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//        Example:
//
//        Input: 5
//        Output:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i == 0) {
                res.add(list);
                continue;
            }
            List<Integer> last = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(last.get(j) + last.get(j - 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
