class Solution {
    
    // RECURSION:
    int noOfPaths(int[][] grid,int i,int j,int m,int n){
        if(i>=m || j>=n){
            return 0;
        }
        if(grid[i][j]==1){ // if obstacle
            return 0;
        }
        if(i==m-1 && j==n-1){ // reached the destination
            return 1;
        }
        return noOfPaths(grid,i+1,j,m,n) + noOfPaths(grid,i,j+1,m,n);
    }
    
    
    // MEMOISATION:
    int noOfPaths1(int[][] grid,int i,int j,int m,int n,int dp[][]){
        if(i>=m || j>=n){
            return 0;
        }
        if(grid[i][j]==1){ // if obstacle
            return dp[i][j] = 0;
        }
        if(i==m-1 && j==n-1){ // reached the destination
            return dp[i][j]=1;
        }
        if(dp[i][j]!=-1){ // if result already evaluated.
            return dp[i][j];
        }
        return dp[i][j] = noOfPaths(grid,i+1,j,m,n) + noOfPaths(grid,i,j+1,m,n);
    }
    
    
    
    // Tabulation:
    int noOfPaths2(int[][] grid,int m,int n){
        
        int dp[][]=new int[m][n];
        
        if(grid[m-1][n-1]!=1){
            dp[m-1][n-1]=1;
        }
        
        for(int j=n-2;j>=0;j--){
            if(grid[m-1][j]==1){
                dp[m-1][j]=0;
            }
            else{
                dp[m-1][j]=dp[m-1][j+1];
            }
        }
        
        for(int i=m-2;i>=0;i--){
            if(grid[i][n-1]==1){
                dp[i][n-1]=0;
            }
            else{
                dp[i][n-1]=dp[i+1][n-1];
            }
        }
        
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(grid[i][j] == 0){
                   dp[i][j] = dp[i+1][j] + dp[i][j+1];   
                }
                // else{
                //     dp[i][j]=0; // if obstacle
                // }
            }
        }
        
        return dp[0][0];
        
    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        // Recursion:   TLE
        // return noOfPaths(obstacleGrid,0,0,m,n);
        
        
        
        // Memosation:   TLE
        // int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         dp[i][j]=-1;
        //     }
        // }

        // return noOfPaths1(obstacleGrid,0,0,m,n,dp);
        
        
        
        
        // Tabulation:
        return noOfPaths2(obstacleGrid,m,n);
        
    }
}