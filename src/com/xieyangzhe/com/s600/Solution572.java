package com.xieyangzhe.com.s600;

import com.xieyangzhe.com.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 17/1/20
 */
public class Solution572 {
    //572. Subtree of Another Tree
    //Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
    //
    //Example 1:
    //Given tree s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //Given tree t:
    //   4
    //  / \
    // 1   2
    //Return true, because t has the same structure and node values with a subtree of s.
    //Example 2:
    //Given tree s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //    /
    //   0
    //Given tree t:
    //   4
    //  / \
    // 1   2
    //Return false.
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }
}
