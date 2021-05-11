package com.xieyangzhe.first.s1000;

//1124. Longest Well-Performing Interval
//Medium
//
//629
//
//74
//
//Add to List
//
//Share
//We are given hours, a list of the number of hours worked per day for a given employee.
//
//A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
//
//A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
//
//Return the length of the longest well-performing interval.
//
//
//
//Example 1:
//
//Input: hours = [9,9,6,0,6,6,9]
//Output: 3
//Explanation: The longest well-performing interval is [9,9,6].
//
//
//Constraints:
//
//1 <= hours.length <= 10000
//0 <= hours[i] <= 16

import java.util.HashMap;
import java.util.Map;

public class Solution1124 {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> memo = new HashMap<>();
        int cur = 0, result = 0;
        for (int i = 0; i < hours.length; i++) {
            cur += hours[i] > 8 ? 1 : -1;
            if (!memo.containsKey(cur)) {
                memo.put(cur, i);
            }
            if (cur > 0) {
                result = i + 1;
            } else if (memo.containsKey(cur - 1)) {
                result = Math.max(result, i - memo.get(cur - 1));
            }
        }
        return result;
    }
}
