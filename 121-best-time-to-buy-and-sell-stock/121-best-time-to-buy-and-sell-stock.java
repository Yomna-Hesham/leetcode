class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int buyDay = 0;
        int sellDay = 0;
        
        for (; sellDay < prices.length; sellDay++) {
            if (prices[buyDay] > prices[sellDay]) {
                buyDay = sellDay;
                continue;
            }
            
            int profit = prices[sellDay] - prices[buyDay];
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}