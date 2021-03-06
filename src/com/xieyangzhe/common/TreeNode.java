package com.xieyangzhe.common;

import java.util.*;

// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTree(String... nodes) {
        if (nodes.length == 0) {
            return null;
        }
        TreeNode[] nodeArray = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#")) {
                if (nodeArray[i] == null) {
                    nodeArray[i] = new TreeNode(Integer.parseInt(nodes[i]));
                }
                int index = 2 * i + 1;
                if (index < nodes.length && !nodes[index].equals("#")) {
                    nodeArray[index] = new TreeNode(Integer.parseInt(nodes[index]));
                    nodeArray[i].left = nodeArray[index];
                } else {
                    nodeArray[i].left = null;
                }
                index++;
                if (index < nodes.length && !nodes[index].equals("#")) {
                    nodeArray[index] = new TreeNode(Integer.parseInt(nodes[index]));
                    nodeArray[i].right = nodeArray[index];
                } else {
                    nodeArray[i].right = null;
                }
            }
        }
        return nodeArray[0];
    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrderWithLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderWithLevelRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderWithLevelRecursiveHelper(result, root, 0);
        return result;
    }

    public static void levelOrderWithLevelRecursiveHelper(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        levelOrderWithLevelRecursiveHelper(result, node.left, level + 1);
        levelOrderWithLevelRecursiveHelper(result, node.right, level + 1);
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop().right;
            }
        }
        return result;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
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

    public static List<Integer> postOrder1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;
        stack.push(root);
        while (!stack.empty()) {
            node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }

    public static void reverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree("1", "2", "3", "4", "5", "6", "7");
        reverse(node);
        System.out.println(levelOrder(node));
    }
}
