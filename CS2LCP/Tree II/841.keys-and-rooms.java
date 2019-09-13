/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return false;
        int len = rooms.size();
        int[] flag = new int[len];
        dfs(rooms, 0, flag);
        for(int i: flag)
            if(i == 0)
                return false;
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int start, int[] flag){
        flag[start] = 1;
        for(int next: rooms.get(start)){
            if(flag[next] == 0){
                dfs(rooms, next, flag);
            }
        }
    }
}

