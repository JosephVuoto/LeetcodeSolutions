package com.xieyangzhe.com.first.s600;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 16/1/20
 */
public class Solution524 {
    //524. Longest Word in Dictionary through Deleting
    //Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
    //
    //Example 1:
    //Input:
    //s = "abpcplea", d = ["ale","apple","monkey","plea"]
    //
    //Output:
    //"apple"
    //Example 2:
    //Input:
    //s = "abpcplea", d = ["a","b","c"]
    //
    //Output:
    //"a"
    //Note:
    //All the strings in the input will only contain lower-case letters.
    //The size of the dictionary won't exceed 1,000.
    //The length of all the strings in the input won't exceed 1,000.
    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
        for (String word: d) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }
        return "";
    }

    private boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        return j == x.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution524().findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
}
