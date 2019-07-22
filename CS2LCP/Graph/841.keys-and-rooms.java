/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        stack.push(0);
        
        while(!stack.isEmpty()){
            int room = stack.pop();
            for(int key: rooms.get(room)){
                if(!visited[key]){
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        for(boolean isvisited: visited)
            if(!isvisited)
                return false;
        return true;
    }
}

