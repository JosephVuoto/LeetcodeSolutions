package com.xieyangzhe.com.first.s400;

import com.xieyangzhe.com.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 25/12/19
 */
public class Solution337 {
    //337. House Robber III
    //The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
    //
    //Determine the maximum amount of money the thief can rob tonight without alerting the police.
    //
    //Example 1:
    //
    //Input: [3,2,3,null,3,null,1]
    //
    //     3
    //    / \
    //   2   3
    //    \   \
    //     3   1
    //
    //Output: 7
    //Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    //Example 2:
    //
    //Input: [3,4,5,1,3,null,1]
    //
    //     3
    //    / \
    //   4   5
    //  / \   \
    // 1   3   1
    //
    //Output: 9
    //Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
    public int rob1(TreeNode root) {
        return Math.max(robInclude(root), robExclude(root));
    }

    private int robInclude(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + robExclude(node.left) + robExclude(node.right);
    }

    private int robExclude(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return robInclude(node.left) + robInclude(node.right);
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        //int[0] represents the largest num in current layer
        //int[1] represents the largest num in children layer
        if (node == null) return new int[2];

        if (node.left == null & node.right == null) {
            return new int[]{node.val, 0};
        }
        int[] leftResult = dfs(node.left);
        int[] rightResult = dfs(node.right);

        int[] res = new int[2];
        res[0] = leftResult[1] + rightResult[1] + node.val;
        res[1] = Math.max(leftResult[1], leftResult[0]) + Math.max(rightResult[1], rightResult[0]);
        return res;
    }
}
