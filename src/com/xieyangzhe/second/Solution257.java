package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 6/4/20
 */
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
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }

    private void dfs(TreeNode node, List<String> result, String current) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            current += node.val;
            result.add(current);
            return;
        }
        if (node.left != null) {
            dfs(node.left, result, current + node.val + "->");
        }
        if (node.right != null) {
            dfs(node.right, result, current + node.val + "->");
        }
    }
}
