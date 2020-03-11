package com.xieyangzhe.com.first.s400;

/**
 * @author Yangzhe Xie
 * @date 6/1/20
 */
public class Solution383 {
    //383. Ransom Note
    //Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
    //
    //Each letter in the magazine string can only be used once in your ransom note.
    //
    //Note:
    //You may assume that both strings contain only lowercase letters.
    //
    //canConstruct("a", "b") -> false
    //canConstruct("aa", "ab") -> false
    //canConstruct("aa", "aab") -> true
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] note = new int[26];
        for (char c: magazine.toCharArray()) {
            note[c - 'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--note[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}