package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 22/4/20
 */
public class LCS {
    public static void main(String[] args) {
        System.out.println(new LCS().lcs("13456778", "357486782"));
    }
    private int lcs(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
