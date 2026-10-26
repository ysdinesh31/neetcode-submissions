class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        int left = 0;
        int right = 1;

        while(right < prices.length) {
            if(prices[right] > prices[left]) {
                ans = Math.max(ans, Math.abs(prices[left] - prices[right]));
            } else {
                left = right;
            }
            right ++;
        }

        return ans;
    }
}
