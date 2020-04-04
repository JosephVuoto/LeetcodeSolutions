package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 21/3/20
 */
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
    //
    //
    //Constraints:
    //
    //board and word consists only of lowercase and uppercase English letters.
    //1 <= board.length <= 200
    //1 <= board[i].length <= 200
    //1 <= word.length <= 10^3
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(start)) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, i, j - 1, start + 1) ||
                dfs(board, word, i, j + 1, start + 1) ||
                dfs(board, word, i + 1, j, start + 1) ||
                dfs(board, word, i - 1, j, start + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
