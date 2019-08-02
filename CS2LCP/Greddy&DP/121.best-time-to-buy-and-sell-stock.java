/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE, res = 0;
        for(int price: prices){
            /*update min in traverse to make sure sell price is behind buy price*/
            if(price < min)
                min = price;
            /*update res when there is a higher profit*/
            else
                res = Math.max(res, price-min);
        }
        return res;
    }
}

