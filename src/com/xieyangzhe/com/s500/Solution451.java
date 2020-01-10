package com.xieyangzhe.com.s500;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yangzhe Xie
 * @date 10/1/20
 */
public class Solution451 {
    //451. Sort Characters By Frequency
    //Given a string, sort it in decreasing order based on the frequency of characters.
    //
    //Example 1:
    //
    //Input:
    //"tree"
    //
    //Output:
    //"eert"
    //
    //Explanation:
    //'e' appears twice while 'r' and 't' both appear once.
    //So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
    //Example 2:
    //
    //Input:
    //"cccaaa"
    //
    //Output:
    //"cccaaa"
    //
    //Explanation:
    //Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    //Note that "cacaca" is incorrect, as the same characters must be together.
    //Example 3:
    //
    //Input:
    //"Aabb"
    //
    //Output:
    //"bbAa"
    //
    //Explanation:
    //"bbaA" is also a valid answer, but "Aabb" is incorrect.
    //Note that 'A' and 'a' are treated as two different characters.
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        Map<Character, Integer> sortedMap =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        Object[] arr = sortedMap.keySet().toArray();
        for (int i = arr.length-1; i >=0; i--) {
            int size = map.get(arr[i]);
            while(size>0) {
                res.append(arr[i]);
                size--;
            }
        }
        return res.toString();
    }
}
