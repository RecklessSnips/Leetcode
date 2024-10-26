package Algorithm.Greedy;

public class Buy_Stock_121 {


    public int maxProfit(int[] prices) {
        int lp = 0;
        int rp = 1;
        int diff = 0, maxProfit = 0;
        while (rp < prices.length){
            if (prices[lp] > prices[rp]){
                lp = rp;
                rp += 1;
                continue;
            }
            diff = prices[rp] - prices[lp];
            maxProfit = Math.max(diff, maxProfit);
            rp++;
        }
        return maxProfit;
    }
}
