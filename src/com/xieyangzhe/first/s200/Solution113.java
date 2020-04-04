package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 13/12/19
 */
public class Solution113 {
    //113. Path Sum II
    //Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    //
    //Note: A leaf is a node with no children.
    //
    //Example:
    //
    //Given the below binary tree and sum = 22,
    //
    //      5
    //     / \
    //    4   8
    //   /   / \
    //  11  13  4
    // /  \    / \
    //7    2  5   1
    //Return:
    //
    //[
    //   [5,4,11,2],
    //   [5,8,4,5]
    //]
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        getAns(root, sum, result, new ArrayList<>());
        return result;
    }

    private void getAns(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        if (targetSum == node.val && node.left == null && node.right == null) {
            tmp.add(node.val);
            result.add(tmp);
            return;
        }
        if (node.left != null) {
            tmp.add(node.val);
            getAns(node.left, targetSum - node.val, result, new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            tmp.add(node.val);
            getAns(node.right, targetSum - node.val, result, new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
    }

    /* --------------------------------------------------------------------------------------- */

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, ret);
        return ret;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret) {
        if (root != null) {
            path.add(root.val);
            if (root.left == null && root.right == null && root.val == sum) {
                ret.add(path);
            }
            dfs(root.left, sum - root.val, new ArrayList(path), ret);
            dfs(root.right, sum - root.val, new ArrayList(path), ret);
        }
    }
}
