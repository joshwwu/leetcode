/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */
class Solution {
    public int longestMountain(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int base = 0, N = A.length, res = 0;
        while(base < N){
            int end = base;//start to raise
            if(end+1 < N && A[end]<A[end+1]){
                while(end+1 < N && A[end]<A[end+1]) end++;
    
                if(end+1 < N && A[end]>A[end+1]){
                    while(end+1 < N && A[end]>A[end+1]) end++;
                    res = Math.max(res, end-base+1);
                }
            }
            base = Math.max(end, base+1);
        }
        return res;
    }
}

