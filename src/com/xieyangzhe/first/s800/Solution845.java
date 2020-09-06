package com.xieyangzhe.first.s800;

/**
 * @author Yangzhe Xie
 * @date 5/9/20
 */
public class Solution845 {
    //845. Longest Mountain in Array
    //Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
    //
    //B.length >= 3
    //There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    //(Note that B could be any subarray of A, including the entire array A.)
    //
    //Given an array A of integers, return the length of the longest mountain.
    //
    //Return 0 if there is no mountain.
    //
    //Example 1:
    //
    //Input: [2,1,4,7,3,2,5]
    //Output: 5
    //Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
    //Example 2:
    //
    //Input: [2,2,2]
    //Output: 0
    //Explanation: There is no mountain.
    //Note:
    //
    //0 <= A.length <= 10000
    //0 <= A[i] <= 10000
    //Follow up:
    //
    //Can you solve it using only one pass?
    //Can you solve it in O(1) space?
    public int longestMountain(int[] A) {
        int i = 0, j = 0, result = 0;
        while (i < A.length) {
            j = i;
            if (j + 1 < A.length && A[j + 1] > A[j]) {
                while (j + 1 < A.length && A[j + 1] > A[j]) {
                    j++;
                }
                if (j + 1 < A.length && A[j + 1] < A[j]) {
                    while (j + 1 < A.length && A[j + 1] < A[j]) {
                        j++;
                    }
                    result = Math.max(result, j - i + 1);
                }
            }
            i = Math.max(i + 1, j);
        }
        return result;
    }
}
