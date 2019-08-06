/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for(int i=0; i<gas.length; i++){
            tank += gas[i]-cost[i];
        }
        if(tank < 0)
            return -1;
        else
            tank = 0;
    
        int curr = 0, start = 0;
        for(int i=0; i<gas.length; i++){
            curr = gas[i]-cost[i];
            if(tank+curr < 0){
                start = i+1;
                tank = 0;
            }else
                tank += curr;
        }
        return start;
    }
}

