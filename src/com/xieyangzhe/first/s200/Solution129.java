package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {
    //129. Sum Root to Leaf Numbers
    //Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    //
    //An example is the root-to-leaf path 1->2->3 which represents the number 123.
    //
    //Find the total sum of all root-to-leaf numbers.
    //
    //Note: A leaf is a node with no children.
    //
    //Example:
    //
    //Input: [1,2,3]
    //    1
    //   / \
    //  2   3
    //Output: 25
    //Explanation:
    //The root-to-leaf path 1->2 represents the number 12.
    //The root-to-leaf path 1->3 represents the number 13.
    //Therefore, sum = 12 + 13 = 25.
    //Example 2:
    //
    //Input: [4,9,0,5,1]
    //    4
    //   / \
    //  9   0
    // / \
    //5   1
    //Output: 1026
    //Explanation:
    //The root-to-leaf path 4->9->5 represents the number 495.
    //The root-to-leaf path 4->9->1 represents the number 491.
    //The root-to-leaf path 4->0 represents the number 40.
    //Therefore, sum = 495 + 491 + 40 = 1026.

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree("4", "9", "0", "5", "1", "#", "#");
        System.out.println(new Solution129().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        getAns(root, result, new ArrayList<>());
        int sum = 0;
        for (List<Integer> list : result) {
            int tmp = 0;
            for (int i = 0; i < list.size(); i++) {
                tmp = tmp * 10 + list.get(i);
            }
            sum += tmp;
        }
        return sum;
    }

    //-----------------------------------------------------------------

    private void getAns(TreeNode node, List<List<Integer>> result, List<Integer> tmp) {
        if (node.left == null && node.right == null) {
            tmp.add(node.val);
            result.add(tmp);
            return;
        }
        if (node.left != null) {
            tmp.add(node.val);
            getAns(node.left, result, new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            tmp.add(node.val);
            getAns(node.right, result, new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getAns1(root, 0);
    }

    private int getAns1(TreeNode node, int cur) {
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }
        int ans = 0;
        if (node.left != null) {
            ans += getAns1(node.left, cur);
        }
        if (node.right != null) {
            ans += getAns1(node.right, cur);
        }
        return ans;
    }
}
