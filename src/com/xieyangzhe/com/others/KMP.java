package com.xieyangzhe.com.others;

/**
 * @author Yangzhe Xie
 * @date 1/4/20
 */
public class KMP {
    void getNext(String pattern, int[] next) {
        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

    }

    private int[] getNextTable(char[] pattern) {
        int[] result = new int[pattern.length];
        result[0] = 0;
        int curLen = 0, index = 1;
        while (index < pattern.length) {
            if (pattern[index] == pattern[curLen]) {
                curLen++;
                result[index] = curLen;
                index++;
            } else {
                if (curLen > 0) {
                    curLen = result[curLen - 1];
                } else {
                    result[index] = 0;
                    index++;
                }
            }
        }
        for (int i = pattern.length - 1; i > 0; i--) {
            result[i] = result[i - 1];
        }
        result[0] = -1;
        return result;
    }

    private void match(char[] target, char[] pattern) {
        int[] next = getNextTable(pattern);
        int i = 0, j = 0;
        while (i < target.length) {
            if (j == pattern.length - 1 && target[i] == pattern[j]) {
                System.out.println("Found: " + i) ;
                return;
            }
            if (target[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        char[] target = "abababbababaaa".toCharArray();
        char[] pattern = "abaa".toCharArray();
        kmp.match(target, pattern);
    }
}
