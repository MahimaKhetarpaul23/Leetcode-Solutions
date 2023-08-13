class Solution {
    
//     public boolean isValid(int nums[],int s,int e,int[][] dp){
//         if(s>=e){
//             return false;
//         }
        
//         // If result is already evaluated:
//         if(dp[s][e]!=-1){
//             if(dp[s][e]==1){
//                 return true;
//             }
//             return false;
//         }
        
//         if(s==e-1){ // 2 equal
//             if(nums[s]==nums[e]){
//                 dp[s][e]=1;
//                 return true;
//             }
//             dp[s][e]=0;
//             return false;
//         }
//         if(s==e-2){ // 3equal or adjacent
//             if(nums[s]==nums[s+1] && nums[s]==nums[s+2]){
//                 dp[s][e]=1;
//                 return true;
//             }
//             if(nums[s]==nums[s+1]-1 && nums[s+1]==nums[s+2]-1){
//                 dp[s][e]=1;
//                 return true;
//             }
//             dp[s][e]=0;
//             return false;
//         }
        
//         boolean fAns=false;
//         for(int k=s+1;k<e-1;k++){
//             boolean isLeft=false,isRight=false;
//             isLeft = isValid(nums,s,k,dp);
//             if(isLeft==true){
//                 isRight = isValid(nums,k+1,e,dp);   
//             }
//             boolean tempAns = isLeft && isRight;
//             fAns = fAns || tempAns;
//             if(tempAns==true){
//                 break;
//             }
//         }
//         if(fAns == true){
//             dp[s][e]=1;
//         }
//         else{
//             dp[s][e]=0;
//         }
//         return fAns;
//     }
    
    
    
    public boolean isValid(int[] nums,int n,int i,int[] dp){
        if(i==n){
            return true;
        }
        if(dp[i]!=-1){
            if(dp[i]==1){
                return true;
            }
            return false;
        }
        if(i+1<n && nums[i]==nums[i+1]){ // 2 equal!!
            if(isValid(nums,n,i+2,dp)==true){
                dp[i]=1;
                return true;
            }          
            if(i+2<n && nums[i+1]==nums[i+2]){
                boolean ans = isValid(nums,n,i+3,dp);
                if(ans==true){
                    dp[i]=1;
                }
                else{
                    dp[i]=0;
                }
                return ans;
            }
        }
        if(i+2<n){
            if(nums[i]==nums[i+1]-1 && nums[i+1]==nums[i+2]-1){ // 3 consecutive!!
               boolean ans = isValid(nums,n,i+3,dp);
                if(ans==true){
                    dp[i]=1;
                }
                else{
                    dp[i]=0;
                }
                return ans;
            }
        }
        dp[i]=0;
        return false;
    }
    
    
    public boolean validPartition(int[] nums) {
        
        int n=nums.length;
       int[] dp = new int[n+1];
        
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=n;j++){
//                 dp[i][j]=-1;
//             }
//         }
        
        return isValid(nums,nums.length,0,dp);
    }
}