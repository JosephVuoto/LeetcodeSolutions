package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/12/19
 */
public class Solution089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
