class Solution {
    
//     public int maxP(int n,int prod,int final_n,int dp[]){
//         if(n==0 || n==1){
//             // if(prod==final_n){
//             //     return 1;
//             // }
//             return prod;
//         }
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         int fans = 1;
//         for(int i=n;i>=1;i--){
//          //   if(n-i > 0){
//                 int ans = maxP(n-i,prod*i,final_n,dp);
//                 fans = Math.max(fans,ans);
//            // }
//         }
//         return dp[n] = fans;
//     }
    
//     public int integerBreak(int n) {
//         if(n<3)
//         {
//             return n-1;
//         }
//         int dp[]=new int[n+1];
//         for(int i=0;i<=n;i++)
//         {
//             dp[i]=-1;
//         }
//         return maxP(n,1,n,dp);
//     }
     public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        if(n == 5) return 6;
        if(n == 6) return 9;
        return 3 * integerBreak(n - 3);
    }
}