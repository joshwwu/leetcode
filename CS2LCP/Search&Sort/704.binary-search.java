/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length-1, mid = 0;
        while(left <= right){
            mid = left+((right-left)>>1);
            if(target > nums[mid])
                left = mid+1;
            else if(target < nums[mid])
                right = mid-1;
            else
                return mid;
        }
        return -1;
    }
}

