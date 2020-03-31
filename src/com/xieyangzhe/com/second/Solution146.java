package com.xieyangzhe.com.second;

import java.util.HashMap;

/**
 * @author Yangzhe Xie
 * @date 28/3/20
 */
public class Solution146 {
    //146. LRU Cache
    //Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
    //
    //get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    //put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    //
    //The cache is initialized with a positive capacity.
    //
    //Follow up:
    //Could you do both operations in O(1) time complexity?
    //
    //Example:
    //
    //LRUCache cache = new LRUCache( 2 /* capacity */ );
    //
    //cache.put(1, 1);
    //cache.put(2, 2);
    //cache.get(1);       // returns 1
    //cache.put(3, 3);    // evicts key 2
    //cache.get(2);       // returns -1 (not found)
    //cache.put(4, 4);    // evicts key 1
    //cache.get(1);       // returns -1 (not found)
    //cache.get(3);       // returns 3
    //cache.get(4);       // returns 4
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
    public static class LRUCache {
        private LRUNode head;
        private LRUNode tail;

        private HashMap<Integer, LRUNode> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new LRUNode(null, null);
            tail = new LRUNode(null, null);
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LRUNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            appendTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            LRUNode node = map.get(key);
            if (node != null) {
                node.setValue(value);
                map.put(key, node);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                appendTail(node);
                return;
            }
            if (map.size() == capacity) {
                LRUNode nodeToDelete = head.next;
                map.remove(nodeToDelete.key);
                head.next = nodeToDelete.next;
                nodeToDelete.next.prev = head;
            }
            LRUNode newNode = new LRUNode(key, value);
            appendTail(newNode);
            map.put(key, newNode);
        }

        private void appendTail(LRUNode node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }
    }

    private static class LRUNode {
        private Integer key;
        private Integer value;
        private LRUNode prev;
        private LRUNode next;

        public LRUNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public LRUNode getPrev() {
            return prev;
        }

        public void setPrev(LRUNode prev) {
            this.prev = prev;
        }

        public LRUNode getNext() {
            return next;
        }

        public void setNext(LRUNode next) {
            this.next = next;
        }
    }
}
