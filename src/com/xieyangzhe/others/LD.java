package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 22/4/20
 */

//Levenshtein Distance
//最短编辑距离
public class LD {
    private int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int insertion = dp[i][j - 1] + 1;
                int deletion = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dp[i][j] = Math.min(replace, Math.min(insertion, deletion));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LD().minDistance("abc", "ab"));
    }
}
