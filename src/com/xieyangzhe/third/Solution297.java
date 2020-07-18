package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/7/20
 */
public class Solution297 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree("1", "2", "5","3","4","#","#");
        System.out.println(new Solution297().serialize(root));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder cur) {
        if (node == null) {
            cur.append("null,");
            return;
        }
        cur.append(node.val).append(",");
        serializeHelper(node.left, cur);
        serializeHelper(node.right, cur);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elems = data.split(",");
        Deque<String> elemList = new LinkedList<>(Arrays.asList(elems));
        return deserializeHelper(elemList);
    }

    private TreeNode deserializeHelper(Deque<String> elemList) {
        String elem = elemList.pop();
        if ("null".equals(elem)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(elem));
        root.left = deserializeHelper(elemList);
        root.right = deserializeHelper(elemList);
        return root;
    }
}
