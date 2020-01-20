package com.xieyangzhe.com.s700;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 20/1/20
 */
public class Solution652 {
    //652. Find Duplicate Subtrees
    //Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
    //
    //Two trees are duplicate if they have the same structure with same node values.
    //
    //Example 1:
    //
    //        1
    //       / \
    //      2   3
    //     /   / \
    //    4   2   4
    //       /
    //      4
    //The following are two duplicate subtrees:
    //
    //      2
    //     /
    //    4
    //and
    //
    //    4
    //Therefore, you need to return above trees' root in the form of a list.

    private List<TreeNode> result;
    private Map<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        map = new HashMap<>();
        dfs(root);
        return result;
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String data = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        map.put(data, map.getOrDefault(data, 0) + 1);
        if (map.get(data) == 2) {
            result.add(node);
        }
        return data;
    }
}
