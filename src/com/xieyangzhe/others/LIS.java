package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 22/3/20
 */
public class LIS {
    public static void main(String[] args) {
        System.out.println(new LIS().lis(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
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
}
