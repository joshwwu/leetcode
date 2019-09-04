/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 */
class Solution {
    public int maxProfitAssignment(int[] diff, int[] profit, int[] worker) {
        int max = 100000, len = diff.length, res = 0;
        int[] job = new int[max];
    
        for(int i=0; i<len; i++){
            job[diff[i]] = Math.max(job[diff[i]], profit[i]);
        }
        for(int i=1; i<max; i++){
            job[i] = Math.max(job[i], job[i-1]);
        }   
        for(int i=0; i<worker.length; i++){
            res += job[worker[i]];
        }
        return res;
    }
}

