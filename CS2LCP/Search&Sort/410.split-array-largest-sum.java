/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0, sum = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        long left = max, right = sum;
        while(left <= right){
            long mid = (left+right)/2;
            if(valid(nums, mid, m))
                right = mid-1;
            else
                left = mid+1;
        }
        return (int)left;
    }
    
    private boolean valid(int[] nums, long maxsum, int m){
        int sum = 0, count = 1;
        for(int num: nums){
            sum += num;
            if(sum > maxsum){
                sum = num;
                count++;
                if(count > m)
                    return false;
            }
        }
        return true;
    }
}

