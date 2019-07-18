/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */
class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[] num, int low, int high) {
        if(low == high)
            return low;
        else{
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] > num[mid2])
                return helper(num, low, mid1);
            else
                return helper(num, mid2, high);
        }
    }
}

