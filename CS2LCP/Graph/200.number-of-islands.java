/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {
    class UnionFind{
        private int count;
        private int[] parent, rank;
        
        public UnionFind(char[][] grid){
            int m = grid.length, n = grid[0].length;
            count = 0;
            parent = new int[m*n]; rank = new int[m*n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        parent[i*n+j] = i*n+j;
                    }
                }
            }
        }
        
        public int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q){
            int rootP = find(p), rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP;
            }else{
                parent[rootP] = rootQ;
                if(rank[rootP] == rank[rootQ])
                    rank[rootQ]++;
            }
            count--;
        }
        
        public int count(){
            return count;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[][] dir = {{0,1},{1,0}};
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    for(int k=0; k<dir.length; k++){
                        int x = i+dir[k][0], y = j+dir[k][1];
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1')
                            uf.union(i*n+j, x*n+y);
                    }
                }
            }
        }
        return uf.count();
    }
}

