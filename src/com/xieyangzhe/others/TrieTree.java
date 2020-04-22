package com.xieyangzhe.others;

import java.lang.invoke.WrongMethodTypeException;
import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 22/4/20
 */
public class TrieTree {

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.addWord("wordd");
        tree.addWord("woree");
        tree.addWord("worcc");
        tree.addWord("word");
        tree.addWord("wor");
        tree.removeWord("word");
        tree.removeWord("wordd");
        System.out.println(tree.matchWord("wor"));
        System.out.println(tree.matchWord("word"));
        System.out.println(tree.matchWord("wordd"));
        System.out.println(tree);
        for (List<Character> level: tree.levelOrder()) {
            System.out.println(level);
        }
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        int level = 0;
        TrieNode cur = root;
        while (level < word.length()) {
            char c = word.charAt(level);
            TrieNode node;
            if ((node = cur.getChild(c)) == null ) {
                TrieNode newNode = new TrieNode(c);
                newNode.setParent(cur);
                newNode.setLevel(level + 1);
                cur.addChild(newNode);
                cur = newNode;
            } else {
                cur = node;
            }
            level++;
        }
        cur.setEnd(true);
    }

    public boolean matchWord(String word) {
        int level = 0;
        TrieNode cur = root;
        while (level < word.length()) {
            TrieNode node;
            if ((node = cur.getChild(word.charAt(level))) == null ) {
                return false;
            } else {
                cur = node;
                level++;
            }
        }

        return cur.isEnd();
    }

    public boolean removeWord(String word) {
        if (word == null || word.trim().equals("")) {
            return false;
        }
        if (!matchWord(word)) {
            return false;
        }
        int level = 0;
        TrieNode cur = root;
        while (level < word.length()) {
            cur = cur.getChild(word.charAt(level++));
        }
        System.out.println(cur);
        if (cur.hasChildren()) {
            cur.setEnd(false);
            return true;
        } else {
            TrieNode parent;
            while (true) {
                parent = cur.getParent();
                if (parent.getChildNum() == 1 && !parent.isEnd) {
                    parent.removeChild(cur);
                    cur = parent;
                } else {
                    break;
                }
            }
            parent.removeChild(cur);
        }
        return true;
    }
    
    public List<List<Character>> levelOrder() {
        List<List<Character>> data = new ArrayList<>();
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Character> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                queue.addAll(node.getChildren());
                tmp.add(node.getContent());
            }
            data.add(tmp);
        }

        return data;
    }

    static final class TrieNode {
        private char content;
        private boolean isEnd;
        private TrieNode parent;
        private int level;
        List<TrieNode> children;

        public TrieNode() {
            this(' ');
        }

        public TrieNode(char content) {
            this.content = content;
            isEnd = false;
            parent = null;
            level = 0;
            children = new LinkedList<>();
        }

        public void addChild(TrieNode node) {
            children.add(node);
        }

        public void removeChild(TrieNode child) {
            children.removeIf(trieNode -> child.getContent() == trieNode.getContent());
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public int getChildNum() {
            return children.size();
        }

        public List<TrieNode> getChildren() {
            return children;
        }

        public TrieNode getChild(char c) {
            for (TrieNode node: children) {
                if (node.getContent() == c) {
                    return node;
                }
            }
            return null;
        }

        public char getContent() {
            return content;
        }

        public TrieNode getParent() {
            return parent;
        }

        public void setParent(TrieNode parent) {
            this.parent = parent;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "content=" + content +
                    ", isEnd=" + isEnd +
                    ", level=" + level +
                    ", children=" + children +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TrieTree{" +
                "root=" + root +
                '}';
    }
}
