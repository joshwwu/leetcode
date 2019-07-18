/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for(int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if(val[j] == ugly[i]){
                    val[j] = ugly[idx[j]++]*primes[j];
                }
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n-1];
    }
}

