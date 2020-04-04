package com.xieyangzhe.first.s300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 28/12/19
 */
public class Solution205 {
    //205. Isomorphic Strings
    //Given two strings s and t, determine if they are isomorphic.
    //
    //Two strings are isomorphic if the characters in s can be replaced to get t.
    //
    //All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
    //
    //Example 1:
    //
    //Input: s = "egg", t = "add"
    //Output: true
    //Example 2:
    //
    //Input: s = "foo", t = "bar"
    //Output: false
    //Example 3:
    //
    //Input: s = "paper", t = "title"
    //Output: true
    //Note:
    //You may assume both s and t have the same length.
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 || t.length() == 0) {
            return true;
        }
        Map<Character, Character> corr = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (corr.containsKey(sc)) {
                if (corr.get(sc) != tc) {
                    return false;
                }
            } else {
                if (corr.containsValue(tc)) {
                    return false;
                } else {
                    corr.put(sc, tc);
                }
            }
        }
        return true;
    }
}
