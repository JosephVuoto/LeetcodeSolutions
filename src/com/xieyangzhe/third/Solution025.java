package com.xieyangzhe.third;

import com.xieyangzhe.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 7/7/20
 */
public class Solution025 {
    //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    //
    //k 是一个正整数，它的值小于或等于链表的长度。
    //
    //如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    //
    // 
    //
    //示例：
    //
    //给你这个链表：1->2->3->4->5
    //
    //当 k = 2 时，应当返回: 2->1->4->3->5
    //
    //当 k = 3 时，应当返回: 3->2->1->4->5
    //
    // 
    //
    //说明：
    //
    //你的算法只能使用常数的额外空间。
    //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
    private ListNode reverseRange(ListNode from, ListNode to) {
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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, to = head;
        int index = 0;
        while (index < k) {
            if (to == null) {
                return head;
            }
            to = to.next;
            index++;
        }
        ListNode newHead = reverseRange(cur, to);
        cur.next = reverseKGroup(to, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fromList(1,2,3,4,5);
        System.out.println(new Solution025().reverseKGroup(node, 2));
    }
}
