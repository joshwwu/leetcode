/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxAll = nums[0], maxCurr = 0;
        for(int i=0; i<nums.length; i++){
            maxCurr = Math.max(maxCurr+nums[i], nums[i]);
            maxAll  = Math.max(maxCurr, maxAll);
        }
        return maxAll;
    }
}

