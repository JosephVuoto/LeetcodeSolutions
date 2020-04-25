package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 25/4/20
 */
public class Solution515 {
    //515. Find Largest Value in Each Tree Row
    //Medium
    //
    //719
    //
    //57
    //
    //Add to List
    //
    //Share
    //You need to find the largest value in each row of a binary tree.
    //
    //Example:
    //Input:
    //
    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //
    //Output: [1, 3, 9]
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 1, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (depth > result.size()) {
            result.add(node.val);
        } else {
            result.set(depth - 1, Math.max(result.get(depth - 1), node.val));
        }
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}
