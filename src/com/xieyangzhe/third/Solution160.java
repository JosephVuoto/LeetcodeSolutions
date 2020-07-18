package com.xieyangzhe.third;

import com.xieyangzhe.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 9/7/20
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        boolean secondRoundA = false, secondRoundB = false;
        if (headA == null || headB == null) {
            return null;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
            if (curA == null) {
                if (secondRoundA) {
                    return null;
                }
                curA = headB;
                secondRoundA = true;
            }
            if (curB == null) {
                if (secondRoundB) {
                    return null;
                }
                curB = headA;
                secondRoundB = true;
            }
        }
        return curA;
    }
}
