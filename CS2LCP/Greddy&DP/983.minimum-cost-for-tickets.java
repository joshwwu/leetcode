/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[366];
        for(int i=0; i<n; i++)
            dp[days[i]] = 1;
        for(int i=1; i<366; i++){
            if(dp[i] == 0)
                dp[i] = dp[i-1];
            else
                dp[i] = Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(0, i-7)]+costs[1], dp[Math.max(0, i-30)]+costs[2]));
        }
        return dp[days[n-1]];
    }
}

