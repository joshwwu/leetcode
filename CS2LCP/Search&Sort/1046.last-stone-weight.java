/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, 
            new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        for(int stone: stones)
            queue.offer(stone);
        
        for(int i=0; i<stones.length-1; i++){
            queue.offer(queue.poll()-queue.poll());
        }
        return queue.poll();
    }
}

