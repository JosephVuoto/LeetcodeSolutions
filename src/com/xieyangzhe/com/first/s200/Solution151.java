package com.xieyangzhe.com.first.s200;

/**
 * @author Yangzhe Xie
 * @date 19/12/19
 */
public class Solution151 {
    //151. Reverse Words in a String
    //Given an input string, reverse the string word by word.
    //
    //
    //
    //Example 1:
    //
    //Input: "the sky is blue"
    //Output: "blue is sky the"
    //Example 2:
    //
    //Input: "  hello world!  "
    //Output: "world! hello"
    //Explanation: Your reversed string should not contain leading or trailing spaces.
    //Example 3:
    //
    //Input: "a good   example"
    //Output: "example good a"
    //Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    //
    //
    //Note:
    //
    //A word is defined as a sequence of non-space characters.
    //Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    //You need to reduce multiple spaces between two words to a single space in the reversed string.
    //
    //
    //Follow up:
    //
    //For C programmers, try to solve it in-place in O(1) extra space.
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                sb.insert(0, words[i]);
                if (i < words.length - 1) {
                    sb.insert(0, " ");
                }
            }
        }
        return sb.toString();
    }
}
