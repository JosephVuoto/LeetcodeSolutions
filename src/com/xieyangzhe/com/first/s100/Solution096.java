package com.xieyangzhe.com.first.s100;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution096 {
    //96. Unique Binary Search Trees
    //Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
    //
    //Example:
    //
    //Input: 3
    //Output: 5
    //Explanation:
    //Given n = 3, there are a total of 5 unique BST's:
    //
    //   1         3     3      2      1
    //    \       /     /      / \      \
    //     3     2     1      1   3      2
    //    /     /       \                 \
    //   2     1         2                 3
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return getAns(1, n);

    }

    private int getAns(int start, int end) {
        int ans = 0;
        if (start >= end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftTreesNum = getAns(start, i - 1);
            int rightTreesNum = getAns(i + 1, end);
            ans += leftTreesNum * rightTreesNum;
        }
        return ans;
    }
}
