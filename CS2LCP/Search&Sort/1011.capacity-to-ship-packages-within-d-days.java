/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0)
            return -1;
        int sum = 0, left, right;
        for(int wht: weights){
            sum += wht;
        }
        
        left = sum/D; right = sum;
        while(left < right){
            int mid = (right-left)/2+left;
            if(getDays(weights, mid, D) > D)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
    
    private int getDays(int[] weights, int cap, int D){
        int days = 0, load = 0;
        for(int wht: weights){
            if(load + wht > cap){
                load = 0; days++;
            }
            load += wht;
            if(wht > cap){
                return D+1;
            }
        }
        return days+1;
    }
}

