class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int buyDay = 0;
        int sellDay = 1;
        
        for (; sellDay <= prices.length; sellDay++) {
            int sellDayPrice = sellDay <prices.length ? prices[sellDay] : 0;
            if (sellDayPrice >= prices[sellDay-1]) {
                continue; 
            } 
            
            maxProfit += (prices[sellDay-1] - prices[buyDay]);
            buyDay = sellDay;
        }
        
        return maxProfit;
    }
}