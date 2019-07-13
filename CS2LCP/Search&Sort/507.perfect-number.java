/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if ((1 << (prime - 1)) * ((1 << prime) - 1) == num)
                return true;
        }
        return false;
    }
}

