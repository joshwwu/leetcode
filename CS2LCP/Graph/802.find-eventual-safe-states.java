/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> res = new ArrayList<>();
    
        for(int i=0; i<n; i++){
            if(dfs(i, color, graph)){
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean dfs(int i, int[] color, int[][] graph){
        if(color[i] > 0)
            return color[i] == 2;
        color[i] = 1;
        for(int nei: graph[i]){
            if(color[nei] == 2)
                continue;
            if(color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }
        color[i] = 2;
        return true;
    }
}

