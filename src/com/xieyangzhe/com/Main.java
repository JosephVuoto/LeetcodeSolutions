package com.xieyangzhe.com;

import com.xieyangzhe.com.common.ListNode;
import com.xieyangzhe.com.s100.Solution061;

public class Main {

    public static void main(String[] args) {
        Solution061 solution061 = new Solution061();
        ListNode node = ListNode.fromList(1, 2, 3, 4, 5, 6);
        System.out.println(solution061.rotateRight(node, 2).toList());
    }
}
