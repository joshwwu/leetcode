/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(grid[a[0]][a[1]])-grid[b[0]][b[1]]);
        queue.offer(new int[]{0,0});
        int level = 0, n = grid.length;
        int[][] next = {{0,-1},{0,1},{1,0},{-1,0}};
        boolean[][] isVisited = new boolean[n][n];
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            level = Math.max(level, grid[top[0]][top[1]]);
            if(top[0] == n-1 && top[1] == n-1)
                break;
            
            for(int[] dir: next){
                int x = top[0]+dir[0];
                int y = top[1]+dir[1];
                if((x >= 0 && x < n && y >= 0 && y < n) && !isVisited[x][y]){
                    isVisited[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return level;
    }
}

