package com.xieyangzhe.second;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 22/6/20
 */
public class Solution155 {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static class MinStack {
        /** initialize your data structure here. */
        private Deque<Integer> stack;
        private int minValue;

        public MinStack() {
            stack = new LinkedList<>();
            minValue = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x < minValue) {
                stack.push(minValue);
                minValue = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == minValue) {
                minValue = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minValue;
        }
    }
}
