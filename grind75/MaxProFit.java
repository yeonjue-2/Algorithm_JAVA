// 초반 풀이
// prices[iBuy]로 계속 참조 (인덱스 기반 접근)
class MaxProFit {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int iBuy = 0; // index when buying

        for(int i = 0; i < prices.length; i++){
            if(prices[iBuy] > prices[i]) iBuy = i;
            profit = Math.max(profit, prices[i] - prices[iBuy]);
        }
        return profit;
    }
}

// 최종 개선
// else 추가하여 필요할때만 연산
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }
}
