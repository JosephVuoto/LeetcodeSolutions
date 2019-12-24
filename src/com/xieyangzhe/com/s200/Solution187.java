package com.xieyangzhe.com.s200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 24/12/19
 */
public class Solution187 {
    //187. Repeated DNA Sequences
    //All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
    //
    //Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
    //
    //Example:
    //
    //Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    //
    //Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp) && !result.contains(tmp)) {
                result.add(tmp);
            } else {
                set.add(tmp);
            }
        }
        return result;
    }
}
