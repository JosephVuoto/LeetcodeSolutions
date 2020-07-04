package com.xieyangzhe.others;

import com.xieyangzhe.common.TreeNode;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 25/6/20
 */
public class Tmp {
    private static List<Integer> preorder(TreeNode root) {
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop().right;
            }
        }
        return result;
    }

    private static List<Integer> inorder(TreeNode root) {
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    private static List<Integer> postOrder(TreeNode root) {
        TreeNode node = root, last = null;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == last) {
                result.add(node.val);
                stack.pop();
                last = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
