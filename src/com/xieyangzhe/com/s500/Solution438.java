package com.xieyangzhe.com.s500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 19/12/19
 */
public class Solution438 {
    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("cbaebabacd", "abc"));
    }

    //438. Find All Anagrams in a String
    //Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
    //
    //Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
    //
    //The order of output does not matter.
    //
    //Example 1:
    //
    //Input:
    //s: "cbaebabacd" p: "abc"
    //
    //Output:
    //[0, 6]
    //
    //Explanation:
    //The substring with start index = 0 is "cba", which is an anagram of "abc".
    //The substring with start index = 6 is "bac", which is an anagram of "abc".
    //Example 2:
    //
    //Input:
    //s: "abab" p: "ab"
    //
    //Output:
    //[0, 1, 2]
    //
    //Explanation:
    //The substring with start index = 0 is "ab", which is an anagram of "ab".
    //The substring with start index = 1 is "ba", which is an anagram of "ab".
    //The substring with start index = 2 is "ab", which is an anagram of "ab".
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String temp = s.substring(i, p.length() + i);
            int[] arr1 = new int[26];
            for (int j = 0; j < p.length(); j++) {
                arr1[temp.charAt(j) - 'a']++;
            }
            if (Arrays.equals(arr, arr1)) {
                list.add(i);
            }
        }
        return list;
    }
}
