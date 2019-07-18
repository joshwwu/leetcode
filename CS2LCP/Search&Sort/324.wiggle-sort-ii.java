/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        
        int index = nums.length-1;
        for(int i=1; i<nums.length; i+=2)
            nums[i] = temp[index--];
        for(int i=0; i<nums.length; i+=2)
            nums[i] = temp[index--];
    }
}

