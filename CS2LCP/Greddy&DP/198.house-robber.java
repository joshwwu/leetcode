/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
		    return 0;
        int fast = 0, slow = 0;
        for(int i=0; i<nums.length; i++){
            int temp = fast;
            fast = Math.max(fast, slow+nums[i]);
            slow = temp;
        }
        return fast;
    }
}

