package com.xieyangzhe.com.common;

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

    public static void preOrderTravel(TreeNode node) {
        System.out.print(node.val + " ");
        if (node.left != null) {
            preOrderTravel(node.left);
        }
        if (node.right != null) {
            preOrderTravel(node.right);
        }
    }
}
