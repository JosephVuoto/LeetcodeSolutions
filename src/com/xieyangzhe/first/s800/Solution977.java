package com.xieyangzhe.first.s800;

import com.xieyangzhe.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 13/8/20
 */
public class Solution977 {
    //977. Squares of a Sorted Array
    //Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
    //
    //
    //
    //Example 1:
    //
    //Input: [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Example 2:
    //
    //Input: [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    //
    //
    //Note:
    //
    //1 <= A.length <= 10000
    //-10000 <= A[i] <= 10000
    //A is sorted in non-decreasing order.
    public int[] sortedSquares(int[] A) {
        int minAbs = Integer.MAX_VALUE, minAbsIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) < minAbs) {
                minAbs = Math.abs(A[i]);
                minAbsIndex = i;
            }
        }
        int[] result = new int[A.length];
        int index = 0;
        result[index++] = minAbs * minAbs;
        int l = minAbsIndex - 1, r = minAbsIndex + 1;
        while (l >= 0 && r < A.length) {
            if (Math.abs(A[l]) < Math.abs(A[r])) {
                result[index++] = A[l] * A[l];
                l--;
            } else {
                result[index++] = A[r] * A[r];
                r++;
            }
        }
        while (l >= 0) {
            result[index++] = A[l] * A[l];
            l--;
        }
        while (r < A.length) {
            result[index++] = A[r] * A[r];
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Solution977().sortedSquares(new int[]{-1,2,3,4,5})) {
            System.out.println(i);
        }
    }
}
