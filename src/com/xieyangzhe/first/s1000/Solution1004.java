package com.xieyangzhe.first.s1000;

import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 13/8/20
 */
public class Solution1004 {
    //1004. Max Consecutive Ones III
    //Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
    //
    //Return the length of the longest (contiguous) subarray that contains only 1s.
    //
    //
    //
    //Example 1:
    //
    //Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    //Output: 6
    //Explanation:
    //[1,1,1,0,0,1,1,1,1,1,1]
    //Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
    //Example 2:
    //
    //Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    //Output: 10
    //Explanation:
    //[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    //Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
    //
    //
    //Note:
    //
    //1 <= A.length <= 20000
    //0 <= K <= A.length
    //A[i] is 0 or 1
    public int longestOnes(int[] A, int K) {
        int zeroCnt = 0, i = 0, result = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                zeroCnt++;
            }
            if (zeroCnt > K) {
                if (A[i] == 0) {
                    zeroCnt--;
                }
                i++;
            }
            result = Math.max(j - i + 1, result);
        }
        return result;
    }
}
