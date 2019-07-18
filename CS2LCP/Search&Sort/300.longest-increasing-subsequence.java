/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int count = 0;
        for(int num: nums){
            int left = 0, right = count;
            while(left < right){
                int mid = (left+right)/2;
                if(dp[mid] < num)
                    left = mid+1;
                else
                    right = mid;
            }
            dp[left] = num;
            if(left == count) count++;
        }
        return count;
    }
}

