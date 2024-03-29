class Solution {
    
    // Memoization:
    public int noOfWays(int coins[],int amount,int dp[][],int idx){
        if(amount==0){
            return 1;
        }
        if(idx >= coins.length){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        if(coins[idx]<=amount){
            return dp[idx][amount] = noOfWays(coins,amount-coins[idx],dp,idx) 
                   + noOfWays(coins,amount,dp,idx+1);
        }
        return dp[idx][amount] = noOfWays(coins,amount,dp,idx+1);
    }
    
    
    // Tabulation:
    public int NOW(int amount,int[] coins){
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i==0){
                    dp[i][j]=0;
                }
                if(j==0){
                    dp[i][j]=1;
                }
            }
        }
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount];
    }
    
    
    
    public int change(int amount, int[] coins) {
        
        
//         int n=coins.length;
//         int[][] dp = new int[n+1][amount+1];
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=amount;j++){
//                 dp[i][j]=-1;
//             }
//         }
        
//         return noOfWays(coins,amount,dp,0);
        
        return NOW(amount,coins);
    }
}