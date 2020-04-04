package com.xieyangzhe.first.s100;

import java.util.*;

//        Given an array of strings, group anagrams together.
//
//        Example:
//
//        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Output:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note:
//
//        All inputs will be in lowercase.
//        The order of your output does not matter.
public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String k = new String(charArray);
            if (!res.containsKey(k)) {
                res.put(k, new ArrayList<>());
            }
            res.get(k).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
