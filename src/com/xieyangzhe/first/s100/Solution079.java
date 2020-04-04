package com.xieyangzhe.first.s100;

public class Solution079 {
    //79. Word Search
    //Given a 2D board and a word, find if the word exists in the grid.
    //
    //The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    //
    //Example:
    //
    //board =
    //[
    //  ['A','B','C','E'],
    //  ['S','F','C','S'],
    //  ['A','D','E','E']
    //]
    //
    //Given word = "ABCCED", return true.
    //Given word = "SEE", return true.
    //Given word = "ABCB", return false.

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && searchNext(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchNext(char[][] board, String word, int start, int i, int j) {
        if (start == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 ||
                j >= board[0].length || j < 0 ||
                board[i][j] != word.charAt(start) ||
                visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (searchNext(board, word, start + 1, i + 1, j) ||
                searchNext(board, word, start + 1, i - 1, j) ||
                searchNext(board, word, start + 1, i, j + 1) ||
                searchNext(board, word, start + 1, i, j - 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
