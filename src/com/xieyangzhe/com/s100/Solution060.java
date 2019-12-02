package com.xieyangzhe.com.s100;

import java.util.ArrayList;
import java.util.List;

public class Solution060 {
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

    public String getPermutation(int n, int k) {
        int[] factor = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for(int i = 1; i <= n; i++){
            int index = k / factor[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factor[n - i];
        }

        return String.valueOf(sb);
    }
}