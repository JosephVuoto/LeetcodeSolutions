package com.xieyangzhe.com;

public class Solution005 {

//    5. Longest Palindromic Substring
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.


    //Approach 1
    public String longestPalindrome1(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (reverseString(tmp).equals(tmp)) {
                    if (tmp.length() > s1.length()) {
                        s1 = tmp;
                    }
                }
            }
        }
        return s1;
    }

    public String reverseString(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }

    //Approach 2
    public String longestPalindrome2(String s) {
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (result.equals("") || j - i + 1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    //Approach 3
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome4(String s) {
        if (s == null || s.length() < 1) return "";
        if (s.length() == 1) return s;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = divide(s, i, i);
            String s2 = divide(s, i, i + 1);
            String ss = s1.length() > s2.length() ? s1 : s2;
            ans = ans.length() > ss.length() ? ans : ss;
        }
        return ans;
    }

    private String divide(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            R++;
            L--;
        }
        return s.substring(L + 1, R);
    }
}