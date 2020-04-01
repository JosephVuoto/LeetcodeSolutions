package com.xieyangzhe.com;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 31/3/20
 */
//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//输入: [1,2,0]
//输出: 3
//
//输入: [3,4,-1,1]
//输出: 2
//
//输入: [7,8,9,11,12]
//输出: 1
public class Main {
    private int findSmallestMissedInt(int[] nums) {
        Arrays.sort(nums);
        int expected = 1;
        for (int num: nums) {
            if (num < 0) {
                continue;
            }
            if (num > expected) {
                return expected;
            } else {
                expected = num + 1;
            }
        }
        return expected;
    }

    public static void main(String[] args) {
        System.out.println(new Main().findLongestCommonPre(new String[]{"flower","flow","floght"}));
    }
    
    //3.编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //输入: ["flower","flow","flight"]
    //输出: "fl"
    private String findLongestCommonPre(String[] words) {
        return helper(words, 0, words.length - 1);
    }
    
    private String helper(String[] words, int start, int end) {
        if (end == start) {
            return words[end];
        }
        if (end - start == 1) {
            return compareAndGet(words[start], words[end]);
        }
        int mid = (end + start) / 2;
        String left = helper(words, start, mid);
        String right = helper(words, mid + 1, end);
        return compareAndGet(left, right);
    }
    
    private String compareAndGet(String a, String b) {
        int k = 0;
        while (k < a.length() && k < b.length() && a.charAt(k) == b.charAt(k)) {
            k++;
        }
        return a.substring(0, k);
    }
}
