package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 9/7/20
 */
public class Solution124 {
    //124. 二叉树中的最大路径和
    //给定一个非空二叉树，返回其最大路径和。
    //
    //本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
    //
    //示例 1:
    //
    //输入: [1,2,3]
    //
    //       1
    //      / \
    //     2   3
    //
    //输出: 6
    //示例 2:
    //
    //输入: [-10,9,20,null,null,15,7]
    //
    //   -10
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //输出: 42
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxValue;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        int cur = root.val + Math.max(0, left) + Math.max(0, right);
        int res = root.val + Math.max(0, Math.max(left, right));
        maxValue = Math.max(maxValue, Math.max(cur, res));
        return res;
    }
}
