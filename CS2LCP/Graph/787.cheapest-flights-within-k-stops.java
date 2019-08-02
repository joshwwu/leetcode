/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for(int[] edge: flights){
            if(!prices.containsKey(edge[0])) prices.put(edge[0], new HashMap<>());
            prices.get(edge[0]).put(edge[1], edge[2]);
        }
   
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        pq.offer(new int[]{0, src, K+1});
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0], city = top[1], stop = top[2];
            if(city == dst) return price;
            if(stop > 0){
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for(int a: adj.keySet()){
                    pq.offer(new int[]{price+adj.get(a), a, stop-1});
                }
            }
        }
        return -1;
    }
}

