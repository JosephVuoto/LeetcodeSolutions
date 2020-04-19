package com.xieyangzhe.second;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Yangzhe Xie
 * @date 19/4/20
 */
public class Solution451 {
    //451. Sort Characters By Frequency
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

}
