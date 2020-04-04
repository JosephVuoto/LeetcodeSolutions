package com.xieyangzhe.first.s100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution093 {
    public static void main(String[] args) {
        System.out.println(new Solution093().restoreIpAddresses("0279245587303"));
    }

    //93. Restore IP Addresses
    //Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    //
    //Example:
    //
    //Input: "25525511135"
    //Output: ["255.255.11.135", "255.255.111.35"]
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, new ArrayList<>(), 0);

        return result;
    }

    private void helper(List<String> result, String s, List<Integer> tmp, int start) {
        if (start >= s.length()) {
            return;
        }
        if (tmp.size() == 3) {
            if (s.length() - start > 3 || s.charAt(start) == '0' && start != s.length() - 1) {
                return;
            }
            int dig = Integer.parseInt(s.substring(start));
            if (dig < 256) {
                tmp.add(dig);
                result.add(tmp.get(0) + "." + tmp.get(1) + "." + tmp.get(2) + "." + tmp.get(3));
            }
            return;
        }
        for (int i = 1; i <= (s.charAt(start) == '0' ? 1 : 3) && start + i <= s.length(); i++) {
            Integer tmpDigit = Integer.parseInt(s.substring(start, start + i));
            if (tmpDigit < 256) {
                tmp.add(tmpDigit);
            } else {
                continue;
            }
            helper(result, s, new ArrayList<>(tmp), start + i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
