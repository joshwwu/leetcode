/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        int[] dp = new int[amount+1];
        for(int i=1; i<amount+1; i++){
            int min = Integer.MAX_VALUE-1;
            for(int coin: coins){
                if(i-coin >= 0){
                    min = Math.min(min, dp[i-coin]);
                }
            }
            dp[i] = min+1;
        }
        return dp[amount] != Integer.MAX_VALUE? dp[amount]: -1;
    }
}

