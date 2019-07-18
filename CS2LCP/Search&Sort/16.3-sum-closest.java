/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return target;
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1, right = nums.length-1, sum = target;
            while(left < right){
                sum=nums[left]+nums[right]+nums[i];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
                int dist = Math.abs(target-sum);
                if(dist < min){
                    min = dist;
                    res = sum;
                }
            }
        }
        return res;
    }
}

