/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int temLen = len1; len1 = len2; len2 = temLen;
        }
        
        int low  = 0, high = len1;
        int i, j;
        while(low <= high){
            i = (low + high)/2;
            j = (len1 + len2 + 1)/2 - i;
            if(i > low && nums1[i-1] > nums2[j]){
                high = i-1;
            }else if(i < high && nums2[j-1] > nums1[i])
                low = i+1;
            else
            {
                double resultLeft = 0, resultRight = 0;
                if(j==0)
                    resultLeft = nums1[i-1];
                else if(i==0)
                    resultLeft = nums2[j-1];
                else
                    resultLeft = Math.max(nums1[i-1],nums2[j-1]);
                
                if((len1 + len2)%2 == 1)
                    return resultLeft;
                
                if(j==len2)
                    resultRight = nums1[i];
                else if(i==len1)
                    resultRight = nums2[j];
                else
                    resultRight = Math.min(nums1[i],nums2[j]);
                
                return (resultLeft + resultRight)/2.0;
            }    
        }
        return 0.0;
    }
}
