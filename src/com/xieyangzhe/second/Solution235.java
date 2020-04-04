package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 4/4/20
 */
//Lowest Common Ancestor of a Binary Search Tree
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
