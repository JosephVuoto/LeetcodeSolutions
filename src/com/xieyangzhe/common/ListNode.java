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

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverseFromTo(ListNode from, ListNode to) {
        if (from == null || from.next == null) {
            return from;
        }
        ListNode cur = from, pre = null;
        while (cur != to) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, newHead = head.next, pre = null;
        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next, tmp = nxt.next;
            cur.next = tmp;
            nxt.next = cur;
            if (pre != null) {
                pre.next = nxt;
            }
            pre = cur;
            cur = tmp;
        }
        return newHead;
    }

    public static ListNode reverse2Recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse2Recursive(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = node;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fromList(1,2,3,4,5);
        System.out.println(reverseFromTo(node, node.next.next));
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}
