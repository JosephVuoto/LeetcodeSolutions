package com.xieyangzhe.com.s200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 31/12/19
 */
public class Solution146 {
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

    public static class LRUCache {
        DLinkNode tail = null;
        DLinkNode head = null;
        int capacity;
        private Map<Integer, DLinkNode> cache;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                int value = target.value;
                target.update();
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                target.value = value;
                target.update();
            } else {
                if (capacity == 0) {
                    return;
                }
                if (cache.size() == capacity) {
                    cache.remove(head.key);
                    head.removeFromHead();
                }
                DLinkNode newNode = new DLinkNode(key, value);
                newNode.append();
                cache.put(key, newNode);
            }
        }

        class DLinkNode {
            int key;
            int value;
            DLinkNode left = null;
            DLinkNode right = null;

            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            // remove head from list and update head reference.
            private void removeFromHead() {
                // if 'this' is the only node, set both head and tail to null.
                if (tail == this) {
                    head = null;
                    tail = null;
                } else {
                    head = this.right;
                    head.left = null;
                }
            }

            private void update() {
                // no need to update if accessing the most revently used value.
                if (tail != this) {
                    // remove from current postion and update nodes (if any) on both sides.
                    if (this != head) {
                        this.left.right = this.right;
                    } else {
                        head = this.right;
                    }
                    this.right.left = this.left;
                    // append to tail.
                    this.append();
                }
            }

            private void append() {
                // inserting the first node.
                if (tail == null) {
                    head = this;
                    tail = this;
                    // append as tail and update tail reference.
                } else {
                    this.right = null;
                    this.left = tail;
                    tail.right = this;
                    tail = this;
                }
            }
        }
    }
}
