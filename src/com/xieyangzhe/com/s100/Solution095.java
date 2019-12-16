package com.xieyangzhe.com.s100;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution095 {
    //95. Unique Binary Search Trees II
    //Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
    //
    //Example:
    //
    //Input: 3
    //Output:
    //[
    //  [1,null,3,2],
    //  [3,2,null,1],
    //  [3,1,null,null,2],
    //  [2,1,3],
    //  [1,null,2,null,3]
    //]
    //Explanation:
    //The above output corresponds to the 5 unique BST's shown below:
    //
    //   1         3     3      2      1
    //    \       /     /      / \      \
    //     3     2     1      1   3      2
    //    /     /       \                 \
    //   2     1         2                 3
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n > 0) {
            result = getResult(1, n);
        }
        return result;
    }

    private List<TreeNode> getResult(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> resultLeft = getResult(start, i - 1);
            List<TreeNode> resultRight = getResult(i + 1, end);
            for (TreeNode nodeLeft : resultLeft) {
                for (TreeNode nodeRight : resultRight) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeLeft;
                    root.right = nodeRight;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
