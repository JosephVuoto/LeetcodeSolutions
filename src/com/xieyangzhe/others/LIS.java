package com.xieyangzhe.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 22/3/20
 */
public class LIS {
    public static void main(String[] args) {
        System.out.println(new LIS().lis(new int[]{1, 3, 2, 6, 7, 9, 4, 10, 5, 6}));
    }

    //Longest Increasing Subsequence
    private int lis(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    //Longest Increasing Subsequence
    private List<Integer> getLIS(int[] nums) {
        int max = 0;
        int start = -1;
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                start = i;
                max = dp[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        while (start != -1) {
            result.add(nums[start]);
            start = prev[start];
        }
        Collections.reverse(result);
        return result;
    }
}
