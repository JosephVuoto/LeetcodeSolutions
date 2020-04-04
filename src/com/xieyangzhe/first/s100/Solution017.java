package com.xieyangzhe.first.s100;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//Example:
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.util.ArrayList;
import java.util.List;

public class Solution017 {
    String[][] refer = {{}, {}, {"a", "c", "b"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (!digits.equals("")) {
            helper(list, digits, "");
        }
        return list;
    }

    private void helper(List<String> list, String digits, String s) {
        if (digits.length() == 0) {
            list.add(s);
            return;
        }
        int idx = Integer.parseInt(digits.substring(0, 1));
        for (String k : refer[idx]) {
            helper(list, digits.substring(1, digits.length()), s + k);
        }
    }
}
