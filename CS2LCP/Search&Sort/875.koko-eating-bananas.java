/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles == null || piles.length == 0)
            return 0;
        int min = 1, max = (int)Math.pow(10,9);
        
        while(min < max){
            int K = (min+max)/2;
            if(calc(piles, K) > H)
                min = K+1;
            else
                max = K;
        }
        return min;
    }
    
    private int calc(int[] piles, int K){
        int res = 0;
        for(int pile: piles){
            res += (pile-1)/K+1;
        }
        return res;
    }
}

