/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class Solution {
    List<Integer> list;
    List<List<Integer>> adjs;
    
    public int[] findOrder(int n, int[][] pres) {
        int[] inDegree = new int[n];
        list = new ArrayList<>();
        adjs = new ArrayList<>();
		//initialize the grah as a format of adjacent list
        initialGraph(pres, inDegree);
        
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
			//starts from nodes having Indegree 0 
			if(inDegree[i] == 0 && !visited[i]){
                list.add(i);
                dfs(i, inDegree, visited);
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i])
                return new int[0];
        }
        
        int a[]=new int[n];
        for(int i=0; i<n; i++)
            a[i]=list.get(i);
        
        return a;
        
    }
    
    private void initialGraph(int[][] pres, int[] inDegree){
        int n = inDegree.length;
        while(n-- > 0) adjs.add(new ArrayList<>());
        for(int[] edges: pres){
            inDegree[edges[0]]++;
            adjs.get(edges[1]).add(edges[0]);
        }
    }
    
    private void dfs(int i, int[] inDegree, boolean[] visited){
        visited[i] = true;
        for(int adj: adjs.get(i)){
            inDegree[adj]--;
        }
		//DFS
        for(int adj: adjs.get(i)){
            if(inDegree[adj] == 0 && !visited[adj]){
                list.add(adj);
                dfs(adj, inDegree, visited);
            }
        }
    }
}

