class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        // BC not necessary as DP 0 se hi init rehti hai hamesha 
        int[][][] dp = new int[n+1][2][k+1];
        // Traverse from the opposite direction of the Memoization 
        for(int ind=n-1; ind>=0; ind--){
            for(int buy = 0; buy<=1; buy++){
                for(int cap = 1; cap<=k; cap++){
                    if(buy==0){
                        dp[ind][buy][cap] = Math.max(0+dp[ind+1][0][cap], -prices[ind]+dp[ind+1][1][cap] );

                    }
                    if(buy==1){
                        dp[ind][buy][cap] = Math.max(0+dp[ind+1][1][cap], prices[ind]+dp[ind+1][0][cap-1]);
                    }
                }
            }
        }

        return dp[0][0][k]; 
    }
}