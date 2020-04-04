package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 4/4/20
 */
public class Solution236 {
    //236. Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
