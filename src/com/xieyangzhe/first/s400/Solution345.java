package com.xieyangzhe.first.s400;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 3/1/20
 */
public class Solution345 {
    public static void main(String[] args) {
        System.out.println(new Solution345().reverseVowels("hello"));
    }

    //345. Reverse Vowels of a String
    //Write a function that takes a string as input and reverse only the vowels of a string.
    //
    //Example 1:
    //
    //Input: "hello"
    //Output: "holle"
    //Example 2:
    //
    //Input: "leetcode"
    //Output: "leotcede"
    //Note:
    //The vowels does not include the letter "y".
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) {
                i++;
            }
            while (i < j && !vowels.contains(chars[j])) {
                j--;
            }
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            i++;
            j--;
        }
        return new String(chars);
    }
}
