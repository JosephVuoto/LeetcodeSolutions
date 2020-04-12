package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 12/4/20
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
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] > mid) {
                    break;
                }
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
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
