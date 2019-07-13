/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1.0)
            return 1;
        if(n <= 0){
            if(n == Integer.MIN_VALUE)
                return 1/pow(x, Integer.MAX_VALUE)/x;//deal with corner case
            return 1/pow(x, -n);
        }else
            return pow(x, n);
    }
    
    private double pow(double x, int n){
        if(n == 1)
            return x;
        double temp = pow(x, n/2);
        if(n%2 == 0)
            return temp*temp;
        else
            return temp*temp*x;
    }
}

