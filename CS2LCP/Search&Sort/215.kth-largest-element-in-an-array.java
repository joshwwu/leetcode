/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        return quicksort(nums, 0, nums.length-1, k);
    }
    private int quicksort(int[] nums, int left, int right, int k){
        int pivot = (left+right)/2;
        int i = left, j = right;
        swap(nums, j, pivot);
        j--;
        while(i <= j){
            while(i <= j && nums[i] <= nums[right])
                i++;
            while(i <= j && nums[j] > nums[right])
                j--;
            if(i < j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, i, right);
        if(nums.length-i == k)
            return nums[i];
        else if(nums.length-i < k)
            return quicksort(nums, left, i-1, k);
        else
            return quicksort(nums, i+1, right, k);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

