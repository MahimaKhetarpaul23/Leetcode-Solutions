class Solution {
    public boolean isPoss(char arr[][],int n,int row,int col){
        // check for column:
        for(int j=0;j<n;j++){
            if(arr[j][col]=='Q'){
                return false;
            }
        }
        // check left diagonal:
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(arr[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        
        i=row-1;
        j=col+1;
        while(i>=0 && j<n){
            if(arr[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    
    public int NQ(char arr[][],int n,int row){
        if(row==n){
            return 1;
        }
        int ans=0;
        for(int j=0;j<n;j++){
            if(isPoss(arr,n,row,j)==true){
                arr[row][j]='Q';
                ans += NQ(arr,n,row+1);
                arr[row][j]='.';
            }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        return NQ(arr,n,0);
    }
}