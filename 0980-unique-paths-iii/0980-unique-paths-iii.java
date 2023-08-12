class Solution {
    
    // m X n :size of grid
    // x and y : destination cell
    // i and j : current cell
    int uniquePaths(int[][] grid,int m,int n,int x,int y,int i,int j,int[][] visited){
        if(i<0 || i>=m || j<0 || j>=n){  // out of boundary
            return 0;
        }
        if(grid[i][j]==-1){  // obstacle
            return 0;
        }
        if(i==x && j==y){  // reached destination
            
            // checking if all non obstacles are covered or not!!
            for(int a=0;a<m;a++){
                for(int b=0;b<n;b++){
                    if(grid[a][b]==0 && visited[a][b]==0){ // if non obstacle & not visited.
                        return 0;
                    }
                }
            }
            
            return 1;
        }
        if(visited[i][j]==1){  // already visited
            return 0;
        }
        
        visited[i][j]=1;  // mark as visited
        
        int ans = uniquePaths(grid,m,n,x,y,i-1,j,visited) +
            uniquePaths(grid,m,n,x,y,i+1,j,visited) +
            uniquePaths(grid,m,n,x,y,i,j-1,visited) + 
            uniquePaths(grid,m,n,x,y,i,j+1,visited);
        
        visited[i][j]=0; // mark as unvisited ie backtrack
        
        return ans;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        
        int srcx=-1,srcy=-1;
        int destx=-1,desty=-1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    srcx=i;
                    srcy=j;
                }
                if(grid[i][j]==2){
                    destx=i;
                    desty=j;
                }
            }
        }
        
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=0;
            }
        }
        
        if(srcx==-1 && srcy==-1){
            return 0;
        }
        
        return uniquePaths(grid,m,n,destx,desty,srcx,srcy,visited);
        
    }
}