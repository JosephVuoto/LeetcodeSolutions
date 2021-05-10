package com.xieyangzhe.first.s400;

//363. Max Sum of Rectangle No Larger Than K
//Hard
//
//1141
//
//80
//
//Add to List
//
//Share
//Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
//
//It is guaranteed that there will be a rectangle with a sum no larger than k.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2
//Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
//Example 2:
//
//Input: matrix = [[2,2,-1]], k = 3
//Output: 3
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 100
//-100 <= matrix[i][j] <= 100
//-105 <= k <= 105

import java.util.TreeSet;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            int[] currRectangle = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    currRectangle[i] += matrix[i][r];
                }
                result = Math.max(result, helper(currRectangle, k));
            }
        }
        return result;
    }

    private int helper(int[] arr, int k) {
        int result = Integer.MIN_VALUE;
        TreeSet<Integer> prevSubarraySums = new TreeSet<>();
        prevSubarraySums.add(0);
        int currSum = 0;
        for (int j : arr) {
            currSum += j;
            Integer temp = prevSubarraySums.ceiling(currSum - k);
            if (temp != null) {
                result = Math.max(result, currSum - temp);
            }
            prevSubarraySums.add(currSum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
