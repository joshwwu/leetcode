/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return false;
        int n = graph.length;
        int[] colors = new int[n];
    
        for(int i=0; i<n; i++){
            if(colors[i] == 0 && !isValid(graph, colors, i, 1)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(int[][] graph, int[] colors, int i, int color){
        if(colors[i] != 0){
            return colors[i] == color;
        }
        colors[i] = color;
        for(int j: graph[i]){
            if(!isValid(graph, colors, j, -color)){
                return false;
            }
        }
        return true;
    }
}

