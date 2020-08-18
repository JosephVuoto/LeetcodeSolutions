package com.xieyangzhe.first.s800;

import com.xieyangzhe.common.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 13/8/20
 */
public class Solution890 {
    //890. Find and Replace Pattern
    //You have a list of words and a pattern, and you want to know which words in words matches the pattern.
    //
    //A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
    //
    //(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
    //
    //Return a list of the words in words that match the given pattern.
    //
    //You may return the answer in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    //Output: ["mee","aqq"]
    //Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    //"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
    //since a and b map to the same letter.
    //
    //
    //Note:
    //
    //1 <= words.length <= 50
    //1 <= pattern.length = words[i].length <= 20
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            int matched = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.length() != pattern.length()) {
                    continue;
                }
                if (map.containsKey(pattern.charAt(i))) {
                    if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                        break;
                    }
                    matched++;
                } else {
                    if (map.containsValue(word.charAt(i))) {
                        break;
                    }
                    map.put(pattern.charAt(i), word.charAt(i));
                    matched++;
                }
            }
            if (matched == word.length()) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution890().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
