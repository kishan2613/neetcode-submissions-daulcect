class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = Integer.MAX_VALUE/2;

        int dp[][] = new int[n+1][amount+1];

        for(int i=0;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                dp[i][j]=m;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

    return dp[n][amount]>amount?-1:dp[n][amount];
    }
}
