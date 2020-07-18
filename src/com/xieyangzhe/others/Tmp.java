package com.xieyangzhe.others;

import com.xieyangzhe.common.ListNode;
import com.xieyangzhe.common.TreeNode;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 25/6/20
 */
public class Tmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>(n);
        while (n-- > 0) {
            list.add(sc.nextLine());
        }
        for (String s : list) {
            for (int i = 0; i < s.length(); i += 8) {
                if (i + 8 < s.length()) {
                    System.out.println(s.substring(i, i + 8));
                } else {
                    int curLength = i + 8 - s.length();
                    StringBuilder sb = new StringBuilder(s.substring(i));
                    for (int j = 0; j < curLength; j++) {
                        sb.append(0);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }

    private static void doTask(List<String> strList) {
        for (String s : strList) {
            for (int i = 0; i < s.length(); i += 8) {
                if (i + 8 < s.length()) {
                    System.out.println(s.substring(i, i + 8));
                } else {
                    int curLength = i + 8 - s.length();
                    StringBuilder sb = new StringBuilder(s.substring(i));
                    for (int j = 0; j < curLength; j++) {
                        sb.append(0);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int calculate(String expression) {
        int index = 0;
        Deque<Character> operatorStack = new ArrayDeque<>();
        Deque<Integer> numberStack = new ArrayDeque<>();
        while (index < expression.length()) {
            if (expression.charAt(index) == 'A') {
                operatorStack.push('+');
                index += 3;
            } else if (expression.charAt(index) == 'S') {
                operatorStack.push('-');
                index += 3;
            } else if (Character.isDigit(expression.charAt(index))) {
                int number = 0;
                while (Character.isDigit(expression.charAt(index))) {
                    number = 10 * number + (expression.charAt(index) - '0');
                    index++;
                }
                numberStack.push(number);
            } else if (expression.charAt(index) == ')') {
                int numB = numberStack.pop(), numA = numberStack.pop();
                char operator = operatorStack.pop();
                if (operator == '+') {
                    numberStack.push(numA + numB);
                } else {
                    numberStack.push(numA - numB);
                }
                index++;
            } else {
                index++;
            }
        }
        return numberStack.pop();
    }
    private static List<Integer> preorder(TreeNode root) {
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop().right;
            }
        }
        return result;
    }

    private static List<Integer> inorder(TreeNode root) {
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    private static List<Integer> postOrder(TreeNode root) {
        TreeNode node = root, last = null;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == last) {
                result.add(node.val);
                stack.pop();
                last = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return result;
    }
}
