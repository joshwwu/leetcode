/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */
class Solution {
    class UnionFind{
        private int count;
        private int[] parent, rank;
        
        public UnionFind(int n){
            count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
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
            
            if(rank[rootP] < rank[rootQ]){
                parent[rootP] = rootQ;
            }else{
                parent[rootQ] = rootP;
                if(rank[rootP] == rank[rootQ])
                    rank[rootP]++;
            }
            count--;
        }
        
        public int count(){
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(M[i][j] == 1)
                    uf.union(i,j);
            }
        }
        return uf.count(); 
    }
}

