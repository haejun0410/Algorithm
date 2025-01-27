class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = prices[0];
        int maxProfix = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfix = Math.max(maxProfix, price - minPrice);    
        }

        return maxProfix;
    }
}