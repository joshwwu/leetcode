/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            int min = n;
            for(int j=1; j*j<=i; j++){
                min = Math.min(min, dp[i-j*j]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

