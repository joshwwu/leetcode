/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
    
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited){
        if(idx >= word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j]){
            return false;
        }
        else{
            visited[i][j] = true;
            boolean res = dfs(board, word, i+1, j, idx+1, visited) ||
                dfs(board, word, i-1, j, idx+1, visited) ||
                dfs(board, word, i, j+1, idx+1, visited) ||
                dfs(board, word, i, j-1, idx+1, visited);
            visited[i][j] = false;
            return res;
        }
    }
}

