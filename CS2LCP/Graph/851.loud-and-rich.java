/*
 * @lc app=leetcode id=851 lang=java
 *
 * [851] Loud and Rich
 */
class Solution {
    int[] res;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adjs = new ArrayList<>();
        int n = quiet.length;
        for(int i=0; i<n; i++) adjs.add(new ArrayList<>());
        for(int[] edge: richer){
            adjs.get(edge[1]).add(edge[0]);
        }
        res = new int[n];
        Arrays.fill(res,-1);

        for(int i=0; i<n; i++){
            dfs(i, adjs, quiet);
        }
        return res;
    }

    private int dfs(int i, List<List<Integer>> adjs, int[] quiet){
        if(res[i] == -1){
            res[i] = i;
            for(int adj: adjs.get(i)){
                int curr = dfs(adj, adjs, quiet);
                if(quiet[curr] < quiet[res[i]])
                    res[i] = curr;
            }
        }
        return res[i];
    }
}

