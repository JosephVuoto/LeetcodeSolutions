package com.xieyangzhe.first.s1000;

/**
 * @author Yangzhe Xie
 * @date 6/9/20
 */
public class Solution1349 {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] validity = new int[m]; // validity数组用于记录每一横排位置是否能做。
        int stateSize = 1 << n; // 每一横排可由学生排布的方式有2^n种。
        int[][] dp = new int[m][stateSize];
        int ans = 0;
        // 初始化validity数组
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                validity[i] = (validity[i] << 1) + (seats[i][j] == '.' ? 1 : 0);
            }
        }
        // 初始化dp数组
        for(int i = 0; i < m; i++){
            for(int j = 0; j < stateSize; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < stateSize; j++){
                // j & validity[i] == j 判断j的状态下能否坐下第i横排
                // (j & (j >> 1) == 0) 判断j模式左右是否没人
                if(((j & validity[i]) == j) && ((j & (j >> 1)) == 0)){
                    if(i == 0){ // 第一横排
                        dp[i][j] = Integer.bitCount(j);
                    }else{
                        // 不是第一排，就要遍历前一排，从而取得当前排的最大值。
                        for(int k = 0; k < stateSize; k++){
                            if((j & (k >> 1)) == 0 && ((j >> 1) & k) == 0 && (dp[i - 1][k] != -1)){
                                dp[i][j] = Math.max(dp[i - 1][k] + Integer.bitCount(j) , dp[i][j]);
                            }
                        }
                    }
                    ans = Math.max(ans , dp[i][j]);
                }
            }
        }
        return ans;
    }
}
