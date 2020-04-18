package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 18/4/20
 */
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
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] required = new int[26];
        int[] current = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            required[p.charAt(i) - 'a']++;
            current[s.charAt(i) - 'a']++;
        }
        for (int i = p.length(); i <= s.length() - p.length(); i++) {
            if (Arrays.equals(required, current)) {
                result.add(i - p.length());
            }
            current[s.charAt(i - p.length()) - 'a']--;
            current[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(required, current)) {
            result.add(s.length() - p.length());
        }
        return result;
    }
}
