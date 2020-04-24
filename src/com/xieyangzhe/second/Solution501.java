package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 24/4/20
 */
public class Solution501 {
    //501. Find Mode in Binary Search Tree
    //Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
    //
    //Assume a BST is defined as follows:
    //
    //The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    //The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    //Both the left and right subtrees must also be binary search trees.
    //
    //
    //For example:
    //Given BST [1,null,2,2],
    //
    //   1
    //    \
    //     2
    //    /
    //   2
    //
    //
    //return [2].
    //
    //Note: If a tree has more than one mode, you can return them in any order.
    //
    //Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> elems = new ArrayList<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                TreeNode node = stack.pop();
                elems.add(node.val);
                root = node.right;
            }
        }
        int maxCnt = 1, lastNum = elems.get(0), cnt = 1;
        Set<Integer> result = new HashSet<>();
        result.add(elems.get(0));
        for (int i = 1; i < elems.size(); i++) {
            if (elems.get(i) == lastNum) {
                cnt++;
            } else {
                cnt = 1;
            }
            lastNum = elems.get(i);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                result.clear();
                result.add(elems.get(i));
            } else if (cnt == maxCnt) {
                result.add(elems.get(i));
            }
        }
        int[] ret = new int[result.size()];
        int index = 0;
        for (int num: result) {
            ret[index++] = num;
        }
        return ret;
    }
}
