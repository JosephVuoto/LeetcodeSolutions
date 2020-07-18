package com.xieyangzhe.third;

import com.xieyangzhe.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yangzhe Xie
 * @date 10/7/20
 */
public class Solution023 {
    //23. 合并K个排序链表
    //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
    //
    //示例:
    //
    //输入:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //输出: 1->1->2->3->4->4->5->6
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                nodes.add(node);
            }
        }
        ListNode newHead = new ListNode(0), cur = newHead;
        while (!nodes.isEmpty()) {
            ListNode tmpNode = nodes.poll();
            cur.next = tmpNode;
            cur = cur.next;
            if (tmpNode.next != null) {
                nodes.add(tmpNode.next);
            }
        }
        return newHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid], right = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }
        for (int i = 0; i < lists.length - mid; i++) {
            right[i] = lists[i + mid];
        }
        return mergeTwoLists(mergeKLists(left), mergeKLists(right));
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.fromList(1,4,5);
        ListNode head2 = ListNode.fromList(1,3,4);
        ListNode head3 = ListNode.fromList(2,6);
//        System.out.println(new Solution023().mergeTwoLists(head1, head2).toList());
        System.out.println(new Solution023().mergeKLists(new ListNode[]{head1, head2, head3}).toList());
    }
}
