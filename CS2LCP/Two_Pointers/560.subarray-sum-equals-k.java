/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0, res = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(map.containsKey(currSum-k))//a little imprivement by not using getOrDefault() here directly
                res += map.get(currSum-k);
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return res;
    }
}

