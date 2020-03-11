package com.xieyangzhe.com.first.s600;

/**
 * @author Yangzhe Xie
 * @date 16/1/20
 */
public class Solution557 {
    //557. Reverse Words in a String III
    //Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    //
    //Example 1:
    //Input: "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"
    //Note: In the string, each word is separated by single space and there will not be any extra space in the string.
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words) {
            res.append(new StringBuffer(word).reverse().toString()).append(" ");
        }
        return res.toString().trim();
    }
}
