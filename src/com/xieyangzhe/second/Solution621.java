package com.xieyangzhe.second;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 6/5/20
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) {
            i--;
        }
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + (25 - i));
    }
}
