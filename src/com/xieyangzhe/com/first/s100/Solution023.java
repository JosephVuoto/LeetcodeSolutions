package com.xieyangzhe.com.first.s100;

import com.xieyangzhe.com.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Yangzhe Xie
 * @date 30/12/19
 */
public class Solution023 {
    public static void main(String[] args) {
        ListNode a = ListNode.fromList(1, 3, 5, 7);
        ListNode b = ListNode.fromList(4, 6);
        System.out.println(new Solution023().merge(a, b).toList());
    }

    //23. Merge k Sorted Lists
    //Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    //
    //Example:
    //
    //Input:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //Output: 1->1->2->3->4->4->5->6
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        } else if (node2 == null) {
            return node1;
        } else if (node1 == null) {
            return node2;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummyHead.next;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(),
                Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
