/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int max = 0, n = nums.length;
        for(int i=0; i<n-1; i++){
            if(i+nums[i] > max)
                max = i+nums[i];
            if(max <= i)
                return false;
        }
        return max >= n-1;
    }
}

