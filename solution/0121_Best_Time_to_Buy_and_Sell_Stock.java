class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) minPrice = prices[i];
            int delta = prices[i] - minPrice;
            if (delta > max) max = delta;
        }
        return max;
    }
}
