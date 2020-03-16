package com.xieyangzhe.com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 17/3/20
 */
//60. Permutation Sequence
//The set [1,2,3,...,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note:
//
//Given n will be between 1 and 9 inclusive.
//Given k will be between 1 and n! inclusive.
//Example 1:
//
//Input: n = 3, k = 3
//Output: "213"
//Example 2:
//
//Input: n = 4, k = 9
//Output: "2314"
public class Solution060 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numberList = new ArrayList<>();
        int[] factor = new int[n + 1];
        factor[0] = 1;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            cur *= i;
            factor[i] = cur;
            numberList.add(i);
        }
        k--; //This is because the index in numberList starts at 0
        for (int i = 1; i <= n; i++) {
            int index = k / factor[n - i];
            sb.append(numberList.get(index));
            numberList.remove(index);
            k -= factor[n - i] * index;
        }
        return sb.toString();
    }
}
