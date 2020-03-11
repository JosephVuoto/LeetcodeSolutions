package com.xieyangzhe.com.first.s400;

/**
 * @author Yangzhe Xie
 * @date 6/1/20
 */
public class Solution378 {
    //378. Kth Smallest Element in a Sorted Matrix
    //Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
    //
    //Note that it is the kth smallest element in the sorted order, not the kth distinct element.
    //
    //Example:
    //
    //matrix = [
    //   [ 1,  5,  9],
    //   [10, 11, 13],
    //   [12, 13, 15]
    //],
    //k = 8,
    //
    //return 13.
    //Note:
    //You may assume k is always valid, 1 ≤ k ≤ n2.
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int[] ints : matrix) {
                if (ints[0] > mid) {
                    break;
                }
                for (int j = 0; j < n; j++) {
                    if (ints[j] <= mid) {
                        cnt++;
                    }
                }
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
