package com.xieyangzhe.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode fromList(int... nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode head = node;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}
