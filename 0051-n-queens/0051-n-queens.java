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
    
    public void NQ(char arr[][],int n,int row,List<List<String>> res){
        if(row==n){
            List<String> al=new ArrayList<String>();
            for(int i=0;i<n;i++){
                String s="";
                for(int j=0;j<n;j++){
                    s=s+arr[i][j];
                }
                al.add(s);
            }
            res.add(al);
            return;
        }
        for(int j=0;j<n;j++){
            if(isPoss(arr,n,row,j)==true){
                arr[row][j]='Q';
                NQ(arr,n,row+1,res);
                arr[row][j]='.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        NQ(arr,n,0,res);
        return res;
    }
}