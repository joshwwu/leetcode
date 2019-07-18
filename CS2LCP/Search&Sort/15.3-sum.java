/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        
        for(int i=0; i<nums.length-2; i++){//still 2 numbers left
            if(i==0 || nums[i] != nums[i-1]){//skip duplicates
                int low = i+1, high = nums.length-1, sum = -nums[i];
                while(low < high){
                    if(nums[low]+nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    }else if(nums[low]+nums[high] < sum){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        return res;
    }
}

