/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */
class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        
        int m = grid.length, n = grid[0].length, count = 0, good = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    good++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        if(good == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                        continue;
                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx,ny});
                    good--;
                }
            }
            count++;
        }
        
        return good == 0? count-1: -1;
    }
}class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        
        int m = grid.length, n = grid[0].length, count = 0, good = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    good++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        if(good == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                        continue;
                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx,ny});
                    good--;
                }
            }
            count++;
        }
        
        return good == 0? count-1: -1;
    }
}

