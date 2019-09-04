/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        if(k <= 1)
            return 0;
        int prod = 1, res = 0, left = 0;
        for(int right = 0; right < nums.length; right++){
            prod *= nums[right];
            while(prod >= k) prod /= nums[left++];
            res += right-left+1;
        }
        return res;
    }
}

