package com.xieyangzhe.first.s700;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 19/1/20
 */
public class Solution648 {
    //648. Replace Words
    //In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
    //
    //Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
    //
    //You need to output the sentence after the replacement.
    //
    //Example 1:
    //
    //Input: dict = ["cat", "bat", "rat"]
    //sentence = "the cattle was rattled by the battery"
    //Output: "the cat was rat by the bat"
    //
    //
    //Note:
    //
    //The input will only have lower-case letters.
    //1 <= dict words number <= 1000
    //1 <= sentence words number <= 1000
    //1 <= root length <= 100
    //1 <= sentence words length <= 1000
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> dictSet = new HashSet<>(dict);

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (dictSet.contains(prefix)) break;
            }
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(prefix);
        }
        return ans.toString();
    }
}
