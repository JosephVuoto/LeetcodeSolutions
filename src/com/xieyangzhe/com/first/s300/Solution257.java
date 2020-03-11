package com.xieyangzhe.com.first.s300;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution257 {
    //257. Binary Tree Paths
    //Given a binary tree, return all root-to-leaf paths.
    //
    //Note: A leaf is a node with no children.
    //
    //Example:
    //
    //Input:
    //
    //   1
    // /   \
    //2     3
    // \
    //  5
    //
    //Output: ["1->2->5", "1->3"]
    //
    //Explanation: All root-to-leaf paths are: 1->2->5, 1->3

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode node, List<String> result, String tmp) {
        if (node.left == null && node.right == null) {
            result.add(tmp + node.val);
        }
        if (node.right != null) {
            dfs(node.right, result, tmp + node.val + "->");
        }
        if (node.left != null) {
            dfs(node.left, result, tmp + node.val + "->");
        }
    }
}
