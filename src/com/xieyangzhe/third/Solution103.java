package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 18/7/20
 */
public class Solution103 {
    //103. 二叉树的锯齿形层次遍历
    //给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    //
    //例如：
    //给定二叉树 [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回锯齿形层次遍历如下：
    //
    //[
    //  [3],
    //  [20,9],
    //  [15,7]
    //]
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 0, root);
        return result;
    }

    private void dfs(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new LinkedList<>());
        }
        if ((level & 1) == 1) {
            result.get(level).add(0, node.val);
        } else {
            result.get(level).add(node.val);
        }
        dfs(result, level + 1, node.left);
        dfs(result, level + 1, node.right);
    }
}
