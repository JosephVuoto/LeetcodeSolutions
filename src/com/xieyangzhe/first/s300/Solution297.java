package com.xieyangzhe.first.s300;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yangzhe Xie
 * @date 18/8/20
 */
public class Solution297 {
    //297. Serialize and Deserialize Binary Tree
    //Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
    //
    //Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
    //
    //Example:
    //
    //You may serialize the following tree:
    //
    //    1
    //   / \
    //  2   3
    //     / \
    //    4   5
    //
    //as "[1,2,3,null,null,4,5]"
    //Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
    //
    //Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
    // Encodes a tree to a single string.
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree("1", "2", "3", "4");
        System.out.println(new Solution297().serialize(tree));
    }
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Deque<String> queue) {
        String element = queue.poll();
        if ("#".equals(element)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(element));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

}
