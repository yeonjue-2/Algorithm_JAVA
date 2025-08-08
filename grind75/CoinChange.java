public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;  // 0원을 만드는 데는 0개의 동전이 필요

        // 1부터 amount까지 모든 금액에 대해 최소 동전 개수 계산
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // (i - coin)을 만드는 최소 동전 개수에 현재 동전 1개를 더한 값과
                    // 기존 dp[i] 값 중 더 작은 값을 선택
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
