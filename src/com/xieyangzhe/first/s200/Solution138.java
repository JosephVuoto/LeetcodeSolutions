package com.xieyangzhe.first.s200;

/**
 * @author Yangzhe Xie
 * @date 17/12/19
 */
public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 1. Add cloned nodes next to the node
        Node nodePtr = head;
        while (nodePtr != null) {
            nodePtr.next = new Node(nodePtr.val, nodePtr.next, null);
            nodePtr = nodePtr.next.next;
        }
        // 2. Set the random pointer of the cloned node to the corresponding one
        Node newNodePtr = head.next;
        nodePtr = head;
        while (nodePtr != null) {
            if (nodePtr.random != null) {
                nodePtr.next.random = nodePtr.random.next;
            }
            nodePtr = nodePtr.next.next;
        }
        // 3. Make all initial nodes point to their next and make all the cloned node point to their next cloned nodes
        nodePtr = head;
        while (nodePtr != null) {
            Node nextNode = nodePtr.next.next;
            if (nextNode != null) {
                nodePtr.next.next = nextNode.next;
            }
            nodePtr.next = nextNode;
            nodePtr = nextNode;
        }
        return newNodePtr;
    }

    //138. Copy List with Random Pointer
    //A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    //
    //Return a deep copy of the list.
    //
    //Example 1:
    //
    //Input:
    //{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
    //
    //Explanation:
    //Node 1's value is 1, both of its next and random pointer points to Node 2.
    //Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
    // Definition for a Node.
    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
